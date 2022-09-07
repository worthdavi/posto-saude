import { useEffect } from 'react'
import { Loader } from '../../common/loader'
import { Layout } from '../../layout'
import Link from 'next/link'
import Router from 'next/router'
import { TabelaConsultas } from './tabela'
import useSWR from 'swr'
import { httpClient } from '../../../app/http'
import { AxiosResponse } from 'axios'
import { useState } from 'react'
import { Alert } from '../../common/message'
import { Consulta } from '../../../app/model/consulta'
import { DropdownPacientes, Input, InputInutil } from '../../common/input'
import { Paciente } from '../../../app/model/paciente'
import { Agenda } from '../../../app/model/agenda'
import { Usuario } from '../../../app/model/usuario'

export const ListagemConsultas: React.FC = () => {

    const [ messages, setMessages ] = useState<Array<Alert>>([])
    const [ pacienteData, setPacienteData ] = useState<Paciente[]>([])

    const [ lista, setLista ] = useState<Consulta[]>([])
    const [ listaAgendas, setListaAgendas] = useState<Agenda[]>([])
    const [ idPaciente, setIdPaciente ] = useState(0)
    const [ usuario, setUsuario] = useState<Usuario>()
    const [ consulta, setConsulta ] = useState<Consulta>()

    useEffect(() => {
        httpClient.get("/api/paciente/listar").then(response => {setPacienteData(response.data)})
    }, []);    

    useEffect(() => {
        httpClient.get(`/api/paciente/buscarUsuarioDoPaciente/${idPaciente}`).then(response => {setUsuario(response.data)})
        httpClient.get(`/api/consulta/listar/${idPaciente}`).then(response => {setLista(response.data)})    
        let agendas = []
        for(let i = 0; i < lista.length; i++){
            agendas.push(lista[i].idAgenda)
        }
        if(agendas.length > 0){
            httpClient.get(`/api/agenda/listar/${agendas}`).then(response => {setListaAgendas(response.data)})
        }
    }, [idPaciente, listaAgendas])

    const deletar = (agenda: Agenda) => {
        httpClient.get(`/api/consulta/buscarPorIdAgenda/${agenda.idAgenda}`).then(response => {setConsulta(response.data)})
        console.log(consulta)
        if(consulta){
            httpClient.delete(`/api/consulta/${consulta?.idConsulta}`).then(response => {
                setMessages([
                    {  tipo: "success", texto: "Consulta desmarcada." }
                ])
                const listaAlterada: Agenda[] = listaAgendas?.filter(item => consulta?.idAgenda != item.idAgenda)
                setListaAgendas(listaAlterada)
            }).catch(error => {
                setMessages([
                    {  tipo: "falha", texto: error.response.data.message }
                ])
                console.log(error.response.data.message)
            })
        }     
    }

    return (
        <Layout title="Horários" mensagens={messages}>
            <DropdownPacientes
                onChange={setIdPaciente}
                label="Paciente (por CPF) *" 
                columnClasses="is-one-third"
                id="idPaciente"
                selecionado={idPaciente > 0 ? idPaciente : pacienteData.length > 0 ? pacienteData[0].idPaciente : 0}
                items={pacienteData.length > 0 ? pacienteData : []}
            />
            {idPaciente > 0 && (
                <div className="columns">
                    <Input
                        label="Nome: "
                        columnClasses="is-one-third"
                        id="nome"
                        name="nome"
                        value={usuario?.nome}
                        disabled
                    />
                    <Input
                        label="Telefone: "
                        columnClasses="is-one-third"
                        id="telefone"
                        name="telefone"
                        value={usuario?.telefone}
                        disabled
                    />
                    <Input
                        label="ID Unidade: "
                        columnClasses="is-one-third"
                        id="idUnidade"
                        name="idUnidade"
                        value={usuario?.unidade != null ? usuario?.unidade.nome : ""}
                        disabled
                    />
                </div>
            )}
            <br /><br />
            <Loader show={!listaAgendas} />
            {idPaciente > 0 && (<TabelaConsultas onDelete={deletar} consultas={lista} agendas={listaAgendas} />)}
        </Layout>
    )
}