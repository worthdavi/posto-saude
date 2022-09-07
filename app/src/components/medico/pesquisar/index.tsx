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
import { Medico } from '../../../app/model/medico'
import { Input } from '../../common/input'

export const ListagemMedicos: React.FC = () => {

    const [ crm, setCRM ] = useState('')
    const [ messages, setMessages ] = useState<Array<Alert>>([])
    const { data: dataMedicos, error } = useSWR<AxiosResponse<Medico[]>>
                    ('/api/medico/listar', url => httpClient.get(url) )    

    const [ lista, setLista ] = useState<Medico[]>([])

    useEffect(() => {
        if(crm == "")
            setLista(dataMedicos?.data || [])
    }, [lista])

    useEffect(() => {
        httpClient.get(`/api/medico/listar/${crm}`).then(response => {
            setLista(response.data)
        })
    }, [crm])


    const editar = (medico : Medico) => {
        const url = `/add/usuario?id=${medico.idUsuario}&tipo=${2}`
        Router.push(url)
    } 

    const deletar = (medico: Medico) => {
        httpClient.delete(`/api/medico/${medico.idMedico}`).then(response => {
            setMessages([
                {  tipo: "success", texto: "Médico excluído." }
            ])
            const listaAlterada: Medico[] = lista?.filter(item => item.idMedico != medico.idMedico)
            setLista(listaAlterada)
        })
    }

    const resetarPesquisa = () => {
        setCRM('')
        setLista([])
    }

    return (
        <Layout title="Medicos" mensagens={messages}>
            <Input
                id="crm" 
                name="crm"
                label="Pesquise por CRM: *"
                autoComplete="off"
                columnClasses="is-half"
                onChange={setCRM} 
            />
             <button 
                onClick={resetarPesquisa}
                className="button is-dark">
                Resetar
            </button>
            <br /><br />
            <Loader show={!dataMedicos} />
            <TabelaOrder onEdit={editar} onDelete={deletar} medicos={lista} />
        </Layout>
    )
}