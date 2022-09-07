import { Layout } from '../../layout'
import { DropdownAgendas, DropdownMedicos, DropdownMenu, DropdownPacientes, DropdownTiposUsuarios, DropdownUnidades, Input, InputCPF, InputTelefone } from '../../common/input'
import { useEffect, useState } from 'react'
import { Consulta } from '../../../app/model/consulta'
import { httpClient } from '../../../app/http'
import { useRouter } from 'next/router'
import { Paciente } from '../../../app/model/paciente'
import { Agenda } from '../../../app/model/agenda'
import agenda from '../../../pages/pesquisar/agenda'
import { Alert } from '../../common/message'
export const addConsulta = () => {

    const [ messages, setMessages ] = useState<Array<Alert>>([])

    const [idConsulta, setIdConsulta] = useState(0)
    const [idPaciente, setIdPaciente] = useState(0)
    const [idAgenda, setIdAgenda] = useState(0)
    const [pacienteData, setPacienteData] = useState<Paciente[]>([])
    const [agendaData, setAgendaData] = useState<Agenda[]>([])
    const [data, setData] = useState<Date>()

    const router = useRouter();
    const { id: queryId } = router.query;

    useEffect(() => {
        httpClient.get("/api/paciente/listar").then(response => {
            setPacienteData(response.data)
        })
    }, []);

    useEffect(() => {
        httpClient.get(`/api/agenda/listar/data/${data}`).then(response => {
            setAgendaData(response.data)
        })
    }, [data]);

    useEffect( () => {  
        if(queryId){
            httpClient.get(`/api/consulta/${+queryId}`).then(response => {
                const consultaEncontrada : Consulta = response.data
                if(consultaEncontrada){
                    setIdConsulta(consultaEncontrada.idConsulta || 0)
                    setIdPaciente(consultaEncontrada.idPaciente)
                    setIdAgenda(consultaEncontrada.idAgenda)
                }   
            })
        } 
    }, [queryId])

    const Submit = (atualizar: boolean) => {
        const consulta: Consulta = {
            idConsulta,
            idAgenda,
            idPaciente
        }
        if(!atualizar){
            httpClient.post(`/api/consulta/add/${idPaciente}/${idAgenda}`).then(response => {
                setMessages([
                    {  tipo: "success", texto: "Consulta marcada com sucesso." }
                ])
                const agendaFiltrada: Agenda[] = agendaData.filter(agenda => agenda.idAgenda != idAgenda)
                setAgendaData(agendaFiltrada)
            });
        }else{
            httpClient.put(`/api/consulta/${consulta.idConsulta}`, consulta).then(response => {
                setMessages([
                    {  tipo: "success", texto: "Consulta atualizada com sucesso." }
                ])
            });
        }      
    }

    return (
        <Layout title={idConsulta ? 'Atualizar consulta' : 'Marcar consulta'} mensagens={messages}>
            {(+idConsulta > 0) &&
                <div className="columns">
                    <Input
                        label="Código: "
                        columnClasses="is-half"
                        id="code"
                        name="code"
                        value={idConsulta}
                        onChange={setIdConsulta}
                        disabled
                    />
                </div>
            }
            <div className="columns">
                <Input
                    id="data" 
                    name="data"
                    label="Selecione a data: *"
                    autoComplete="off"
                    columnClasses="is-one-third"
                    onChange={setData}
                    type="date" 
                />
                { data != null && (
                    <DropdownAgendas
                        onChange={setIdAgenda}
                        label="Horários disponíveis:" 
                        columnClasses="is-one-third"
                        id="idAgenda"
                        selecionado={idAgenda > 0 ? idAgenda : agendaData.length > 0 ? agendaData[0].idAgenda : 0}
                        items={agendaData.length > 0 ? agendaData : []}
                    />
                )}
                { idAgenda != 0 && (
                    <DropdownPacientes
                        onChange={setIdPaciente}
                        label="Paciente (por CPF) *" 
                        columnClasses="is-one-third"
                        id="idPaciente"
                        selecionado={idPaciente > 0 ? idPaciente : pacienteData.length > 0 ? pacienteData[0].idPaciente : 0}
                        items={pacienteData.length > 0 ? pacienteData : []}
                    />
                )}              
            </div>

            <div className="field is-grouped">
                <div className="control">
                    <button
                        onClick={() => Submit(+idConsulta > 0 ? true : false)}
                        className="button is-dark">
                            {idConsulta ? 'Atualizar' : 'Salvar'}
                    </button>
                </div>
            </div>
        </Layout>
    )
}