import { useEffect } from 'react'
import { Loader } from '../../common/loader'
import { Layout } from '../../layout'
import Link from 'next/link'
import Router from 'next/router'
import { TabelaOrder } from './tabela'
import useSWR from 'swr'
import { httpClient } from '../../../app/http'
import { AxiosResponse } from 'axios'
import { useState } from 'react'
import { Alert } from '../../common/message'
import { Paciente } from '../../../app/model/paciente'
import { Input } from '../../common/input'

export const ListagemPacientes: React.FC = () => {

    const [cpf, setCPF] = useState('')
    const [ messages, setMessages ] = useState<Array<Alert>>([])
    const { data: dataPacientes, error } = useSWR<AxiosResponse<Paciente[]>>
                    ('/api/paciente/listar', url => httpClient.get(url) )    

    const [ lista, setLista ] = useState<Paciente[]>([])

    useEffect(() => {
        if(cpf == "")
            setLista(dataPacientes?.data || [])
    }, [lista])

    useEffect(() => {       
        httpClient.get(`/api/paciente/listar/${cpf}`).then(response => {
            setLista(response.data)
        })
    }, [cpf])

    const editar = (paciente : Paciente) => {
        const url = `/add/usuario?id=${paciente.idUsuario}&tipo=${1}`
        Router.push(url)
    } 

    const deletar = (paciente: Paciente) => {
        httpClient.delete(`/api/paciente/${paciente.idPaciente}`).then(response => {
            setMessages([
                {  tipo: "success", texto: "Paciente excluído." }
            ])
            const listaAlterada: Paciente[] = lista?.filter(item => item.idPaciente != paciente.idPaciente)
            setLista(listaAlterada)
        })
    }

    const resetarPesquisa = () => {
        setCPF('')
        setLista([])
    }

    return (
        <Layout title="Pacientes" mensagens={messages}>
            <Input
                id="cpf" 
                name="cpf"
                label="Pesquise por CPF: *"
                autoComplete="off"
                columnClasses="is-half"
                onChange={setCPF} 
            />
            <button 
                onClick={resetarPesquisa}
                className="button is-dark">
                Resetar
            </button>
            <br /><br />
            <Loader show={!dataPacientes} />
            <TabelaOrder onEdit={editar} onDelete={deletar} pacientes={lista} />
        </Layout>
    )
}