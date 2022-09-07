import { useEffect } from 'react'
import { Loader } from '../../common/loader'
import { Layout } from '../../layout'
import Link from 'next/link'
import Router from 'next/router'
import { TabelaAgenda } from './tabela'
import useSWR from 'swr'
import { httpClient } from '../../../app/http'
import { AxiosResponse } from 'axios'
import { useState } from 'react'
import { Alert } from '../../common/message'
import { Agenda } from '../../../app/model/agenda'
import { Input } from '../../common/input'

export const ListagemAgendas: React.FC = () => {

    const [ data, setData ] = useState('2022-02-21')
    const [ messages, setMessages ] = useState<Array<Alert>>([])
    const [ lista, setLista ] = useState<Agenda[]>([])

    useEffect(() => {
        if(data == ""){
            httpClient.get("/api/agenda/listar").then(response => {
                setLista(response.data)
            })
        }          
    }, [lista])

    useEffect(() => {
        httpClient.get(`/api/agenda/listar/datatodos/${data}`).then(response => {
            setLista(response.data)
        })
    }, [data])

    const editar = (agenda : Agenda) => {
        const url = `/add/agenda?id=${agenda.idAgenda}`
        Router.push(url)
    } 

    const deletar = (agenda: Agenda) => {
        httpClient.delete(`/api/agenda/${agenda.idAgenda}`).then(response => {
            setMessages([
                {  tipo: "success", texto: "Agenda excluída." }
            ])
            const listaAlterada: Agenda[] = lista?.filter(item => item.idAgenda != agenda.idAgenda)
            setLista(listaAlterada)
        })
    }

    const resetarPesquisa = () => {
        setData('')
        setLista([])
    }

    return (
        <Layout title="Agendas" mensagens={messages}>
            <Input
                id="data" 
                name="data"
                label="Pesquise por data: *"
                autoComplete="off"
                columnClasses="is-half"
                onChange={setData} 
            />
            <button 
                onClick={resetarPesquisa}
                className="button is-dark">
                Resetar
            </button>
            <br /><br />
            <Loader show={!lista} />
            <TabelaAgenda onEdit={editar} onDelete={deletar} agendas={lista} />
        </Layout>
    )
}