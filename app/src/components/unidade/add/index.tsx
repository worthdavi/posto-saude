import { Layout } from '../../layout'
import { DropdownMedicos, DropdownMenu, DropdownTiposUsuarios, DropdownUnidades, Input, InputCPF, InputTelefone } from '../../common/input'
import { useEffect, useState } from 'react'
import { UnidadeDeSaude } from '../../../app/model/unidade'
import { httpClient } from '../../../app/http'
import { useRouter } from 'next/router'
import { Alert } from '../../common/message'
export const addUnidade = () => {

    const [idUnidade, setIdUnidade] = useState(0)
    const [nome, setNome] = useState('')
    const [rua, setRua] = useState('')
    const [numero, setNumero] = useState('')
    const [bairro, setBairro] = useState('')
    const [estado, setEstado] = useState('')
    const [pais, setPais] = useState('')

    const [ messages, setMessages ] = useState<Array<Alert>>([])

    const router = useRouter();
    const { id: queryId } = router.query;

    useEffect( () => {  
        if(queryId){
            httpClient.get(`/api/unidade/${+queryId}`).then(response => {
                const unidadeEncontrada : UnidadeDeSaude = response.data
                if(unidadeEncontrada){
                    setIdUnidade(unidadeEncontrada.idUnidade)
                    setNome(unidadeEncontrada.nome)
                    setRua(unidadeEncontrada.endereco.rua)
                    setNumero(unidadeEncontrada.endereco.numero)
                    setBairro(unidadeEncontrada.endereco.bairro)
                    setEstado(unidadeEncontrada.endereco.estado)
                    setPais(unidadeEncontrada.endereco.pais)
                }   
            })
        } 
    }, [queryId])

    const Submit = (atualizar: boolean) => {
        const unidade: UnidadeDeSaude = {
            idUnidade,
            endereco: {rua, numero, bairro, estado, pais},
            nome
        }
        if(!atualizar){
            httpClient.post(`/api/unidade/add`, unidade).then(response => {
                setMessages([
                    {  tipo: "success", texto: "Unidade de saúde cadastrada com sucesso." }
                ])
            });
        }else{
            httpClient.put(`/api/unidade/${unidade.idUnidade}`, unidade).then(response => {
                setMessages([
                    {  tipo: "success", texto: "Unidade de saúde atualizada com sucesso." }
                ])
            });
        }      
    }

    return (
        <Layout title={idUnidade ? 'Atualizar unidade de saúde' : 'Salvar unidade de saúde'} mensagens={messages}>
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

            <div className="columns">
                <Input
                    id="rua"
                    name="rua"
                    label="Rua *"
                    autoComplete="off" 
                    columnClasses="is-one-third"
                    onChange={setRua}              
                    value={rua}
                />
                <Input
                    id="numero"
                    name="numero"
                    label="Numero *"
                    autoComplete="off"    
                    columnClasses="is-one-third"
                    onChange={setNumero}               
                    value={numero}
                    type="number"
                />
                <Input
                    id="bairro"
                    name="bairro"
                    label="Bairro *"
                    autoComplete="off"    
                    columnClasses="is-one-third"
                    onChange={setBairro}               
                    value={bairro}
                />
            </div>

            <div className="columns">
            <Input
                    id="pais"
                    name="pais"
                    label="País *"
                    autoComplete="off"    
                    columnClasses="is-one-third"
                    onChange={setPais}               
                    value={pais}
                />
                <Input
                    id="estado"
                    name="estado"
                    label="Estado *"
                    autoComplete="off"    
                    columnClasses="is-one-third"
                    onChange={setEstado}               
                    value={estado}
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