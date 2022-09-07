import { Layout } from '../../layout'
import { DropdownMedicos, DropdownMenu, DropdownTiposUsuarios, DropdownUnidades, Input, InputCPF, InputTelefone } from '../../common/input'
import { useEffect, useState } from 'react'
import { UnidadeDeSaude } from '../../../app/model/unidade'
import { httpClient } from '../../../app/http'
import { useRouter } from 'next/router'
export const addUnidade = () => {

    const [idUnidade, setIdUnidade] = useState(0)
    const [nome, setNome] = useState('')

    const ClearFields = () => {
        setNome('')
    }

    const router = useRouter();
    const { id: queryId } = router.query;

    useEffect( () => {  
        if(queryId){
            httpClient.get(`/api/unidade/${+queryId}`).then(response => {
                const unidadeEncontrada : UnidadeDeSaude = response.data
                if(unidadeEncontrada){
                    setIdUnidade(unidadeEncontrada.idUnidade)
                    setNome(unidadeEncontrada.nome)
                }   
            })
        } 
    }, [queryId])

    const Submit = (atualizar: boolean) => {
        const unidade: UnidadeDeSaude = {
            idUnidade,
            nome
        }
        if(!atualizar){
            httpClient.post(`/api/unidade/add`, unidade).then(response => {
                alert("Agenda cadastrada!")
            });
        }else{
            httpClient.put(`/api/unidade/${unidade.idUnidade}`, unidade).then(response => {
                alert("Agenda atualizada!")
            });
        }      
    }

    return (
        <Layout title={idUnidade ? 'Atualizar unidade de saúde' : 'Salvar unidade de saúde'}>
            {(+idUnidade > 0) &&
                <div className="columns">
                    <Input
                        label="Código: "
                        columnClasses="is-half"
                        id="code"
                        name="code"
                        value={idUnidade}
                        onChange={setIdUnidade}
                        disabled
                    />
                </div>
            }               
            <div className="columns">
                <Input
                    id="nome" 
                    name="nome"
                    label="Nome: *"
                    autoComplete="off"
                    columnClasses="is-half"
                    onChange={setNome} 
                    value={nome}
                />
            </div>

            <div className="field is-grouped">
                <div className="control">
                    <button
                        onClick={() => Submit(+idUnidade > 0 ? true : false)}
                        className="button is-dark">
                            {
                                idUnidade ? 'Atualizar' : 'Salvar'
                            }
                    </button>
                </div>
            </div>
        </Layout>
    )
}