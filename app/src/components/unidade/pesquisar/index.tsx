import { useEffect } from 'react'
import { Loader } from '../../common/loader'
import { Layout } from '../../layout'
import Link from 'next/link'
import Router from 'next/router'
import { TabelaUnidades } from './tabela'
import useSWR from 'swr'
import { httpClient } from '../../../app/http'
import { AxiosResponse } from 'axios'
import { useState } from 'react'
import { Alert } from '../../common/message'
import { UnidadeDeSaude } from '../../../app/model/unidade'
import { Input } from '../../common/input'

export const ListagemUnidades: React.FC = () => {

    const [ nome, setNome ] = useState('')
    const [ messages, setMessages ] = useState<Array<Alert>>([])
    const { data: dataUnidades, error } = useSWR<AxiosResponse<UnidadeDeSaude[]>>
                    ('/api/unidade/listar', url => httpClient.get(url) )    

    const [ lista, setLista ] = useState<UnidadeDeSaude[]>([])

    useEffect(() => {
        if(nome == "")
            setLista(dataUnidades?.data || [])
    }, [lista])

    useEffect(() => {
        httpClient.get(`/api/unidade/listar/${nome}`).then(response => {setLista(response.data)})
    }, [nome])

    const editar = (unidade : UnidadeDeSaude) => {
        const url = `/add/unidade?id=${unidade.idUnidade}`
        Router.push(url)
    } 

    const deletar = (unidade: UnidadeDeSaude) => {
        httpClient.delete(`/api/unidade/${unidade.idUnidade}`).then(response => {
            setMessages([
                {  tipo: "success", texto: "UnidadeDeSaude excluído." }
            ])
            const listaAlterada: UnidadeDeSaude[] = lista?.filter(item => item.idUnidade != unidade.idUnidade)
            setLista(listaAlterada)
        }).catch(error => {
            setMessages([
                {  tipo: "falha", texto: error.response.data.message }
            ])
            console.log(error.response.data.message)
        })
    }

    const resetarPesquisa = () => {
        setNome('')
        setLista([])
    }

    return (
        <Layout title="Unidades de Saúde" mensagens={messages}>
            <Input
                id="nome" 
                name="nome"
                label="Pesquise por nome: *"
                autoComplete="off"
                columnClasses="is-half"
                onChange={setNome} 
                value={nome}
            />
            <button 
                onClick={resetarPesquisa}
                className="button is-dark">
                Resetar
            </button>
            <br /><br />
            <Loader show={!dataUnidades} />
            <TabelaUnidades onEdit={editar} onDelete={deletar} unidades={lista} />
        </Layout>
    )
}