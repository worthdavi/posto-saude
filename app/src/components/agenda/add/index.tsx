import { Layout } from '../../layout'
import { DropdownMedicos, DropdownMenu, DropdownTiposUsuarios, DropdownUnidades, Input, InputCPF, InputTelefone } from '../../common/input'
import { useEffect, useState } from 'react'
import { Usuario } from '../../../app/model/usuario'
import { UnidadeDeSaude } from '../../../app/model/unidade'
import { httpClient } from '../../../app/http'
import { TipoUsuario } from '../../../app/model/tipoUsuario'
import { useRouter } from 'next/router'
import { Medico } from '../../../app/model/medico'
import { Paciente } from '../../../app/model/paciente'
import { Agenda } from '../../../app/model/agenda'

export const addAgenda = () => {

    const [medicosLista, setMedicosLista] = useState<Medico[]>([])
    const [idAgenda, setIdAgenda] = useState(0)
    const [data, setData] = useState('')
    const [horario, setHorario] = useState("")
    const [idMedico, setIdMedico] = useState(0)
    const [medico, setMedico] = useState<Medico>()
    const [disponibilidade, setDisponibilidade] = useState("LIVRE")

    const ClearFields = () => {
        setIdAgenda(0)
        setData('')
        setHorario('')
        setDisponibilidade('')
    }

    const router = useRouter();
    const { id: queryId } = router.query;

    useEffect(() => {
        httpClient.get("/api/medico/listar").then(response => {
            setMedicosLista(response.data)
        })
        console.log(medicosLista)
    }, []);

    useEffect( () => {  
        if(queryId){
            httpClient.get(`/api/agenda/${+queryId}`).then(response => {
                const agendaEcontrada : Agenda = response.data
                if(agendaEcontrada){
                    setIdAgenda(agendaEcontrada.idAgenda || 0)
                    setData(agendaEcontrada.data)
                    setHorario(agendaEcontrada.horario)
                    setMedico(agendaEcontrada.medico)
                    setIdMedico(agendaEcontrada.medico.idMedico)
                    setDisponibilidade(agendaEcontrada.disponibilidade)
                }   
            })
        } 
    }, [queryId])

    useEffect( () => {
        httpClient.get(`/api/medico/${idMedico}`).then(response => {
            setMedico(response.data)
        })
    }, [idMedico])

    const Submit = (atualizar: boolean) => {
        const agenda: Agenda = {
            idAgenda,
            data,
            horario,
            medico,
            disponibilidade
        }
        if(!atualizar){
            httpClient.post(`/api/agenda/add/${agenda.medico.idMedico}`, agenda).then(response => {
                alert("Agenda cadastrada!")
            });
        }else{
            httpClient.put(`/api/agenda/${agenda.idAgenda}`, agenda).then(response => {
                alert("Agenda atualizada!")
            });
        }      
    }

    return (
        <Layout title={idAgenda ? 'Atualizar agenda' : 'Salvar agenda'}>
            {(+idAgenda > 0) &&
                <div className="columns">
                    <Input
                        label="Código: "
                        columnClasses="is-half"
                        id="code"
                        name="code"
                        value={idAgenda}
                        onChange={setIdAgenda}
                        disabled
                    />
                </div>
            }               
            <div className="columns">
                <Input
                    id="data" 
                    name="data"
                    label="Data (YYYY-mm-dd): *"
                    autoComplete="off"
                    columnClasses="is-half"
                    onChange={setData} 
                    value={data}
                />
                <Input
                    id="horario" 
                    name="horario"
                    label="Horario: (hh:mm) *"
                    autoComplete="off" 
                    columnClasses="is-half"
                    onChange={setHorario} 
                    value={horario}
                />
            </div>

            <div className="columns">
                <Input
                    id="disponibilidade" 
                    name="disponibilidade"
                    label="Disponilidade: *"
                    autoComplete="off"
                    columnClasses="is-half"
                    onChange={setDisponibilidade} 
                    value={disponibilidade}
                />
                 <DropdownMedicos
                    onChange={setIdMedico}
                    label="Medico responsável (por CRM) *" 
                    columnClasses="is-half"
                    id="idMedico"
                    selecionado={idMedico != null ? idMedico : 0}
                    items={medicosLista}
                />
            </div>

            <div className="field is-grouped">
                <div className="control">
                    <button
                        onClick={() => Submit(+idAgenda > 0 ? true : false)}
                        className="button is-dark">
                            {
                                idAgenda ? 'Atualizar' : 'Salvar'
                            }
                    </button>
                </div>
                <div className="control">
                    <button 
                        onClick={ClearFields}
                        className="button is-dark">
                        Limpar campos
                    </button>
                </div>
            </div>
        </Layout>
    )
}