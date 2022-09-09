import { Layout } from '../../layout'
import { DropdownMenu, DropdownTiposUsuarios, DropdownUnidades, Input, InputCPF, InputTelefone } from '../../common/input'
import { useEffect, useState } from 'react'
import { useUsuarioService } from '../../../app/service/usuario.service'
import { useUnidadeDeSaudeService } from '../../../app/service/unidade.service'
import { Usuario } from '../../../app/model/usuario'
import { UnidadeDeSaude } from '../../../app/model/unidade'
import { httpClient } from '../../../app/http'
import { TipoUsuario } from '../../../app/model/tipoUsuario'
import { useRouter } from 'next/router'
import { Medico } from '../../../app/model/medico'
import { Paciente } from '../../../app/model/paciente'

export const addUsuario = () => {

    const tiposUsuario: TipoUsuario[] = [{id: 1, nome: "Paciente"}, {id: 2, nome: "Medico"}]

    const [idUsuario, setIdUsuario] = useState(0)
    const [login, setLogin] = useState('')
    const [medico, setMedico] = useState<Medico>({idMedico: 0, crm: "0", idUsuario: 0})
    const [paciente, setPaciente] = useState<Paciente>({idPaciente: 0, cpf: "0", idUsuario: 0})
    const [senha, setSenha] = useState('')
    const [nome, setNome] = useState('')
    const [telefone, setTelefone] = useState('')
    const [unidadesDeSaude, setUnidadesDeSaude] = useState<UnidadeDeSaude[]>([])
    const [idUnidade, setIdUnidade] = useState(0)
    const [unidadeSelecionada, setUnidadeSelecionada] = useState<UnidadeDeSaude>()
    const [tipoUsuario, setTipoUsuario] = useState(0)
    const [cpf, setCPF] = useState("")
    const [crm, setCRM] = useState("")

    const [rua, setRua] = useState('')
    const [numero, setNumero] = useState('')
    const [bairro, setBairro] = useState('')
    const [estado, setEstado] = useState('')
    const [pais, setPais] = useState('')

    const ClearFields = () => {
        setLogin('')
        setSenha('')
        setNome('')
        setTelefone('')
        setRua('')
        setNumero('')
        setBairro('')
        setEstado('')
        setPais('')
    }

    const router = useRouter();
    const { id: queryId, tipo: tipoId } = router.query;

    useEffect(() => {
        httpClient.get("/api/unidade/listar").then(response => {
            setUnidadesDeSaude(response.data)
        })
    }, []);

    useEffect(() => {
        httpClient.get(`api/unidade/${idUnidade}`).then(response => {
            setUnidadeSelecionada(response.data)
        })
    }, [idUnidade])

    useEffect( () => {  
        if(queryId){
            httpClient.get(`/api/usuario/${+queryId}`).then(response => {
                const usuarioEncontrado : Usuario = response.data
                if(usuarioEncontrado){
                    setIdUsuario(usuarioEncontrado.idUsuario || 0)
                    setLogin(usuarioEncontrado.login)
                    setNome("sexo")
                    setSenha(usuarioEncontrado.senha)
                    setTelefone(usuarioEncontrado.telefone)
                    setRua(usuarioEncontrado.endereco.rua)
                    setNumero(usuarioEncontrado.endereco.numero)
                    setBairro(usuarioEncontrado.endereco.bairro)
                    setEstado(usuarioEncontrado.endereco.estado)
                    setPais(usuarioEncontrado.endereco.pais)
                    setUnidadeSelecionada({idUnidade: usuarioEncontrado.unidade.idUnidade, nome: usuarioEncontrado.unidade.nome})
                    setTipoUsuario(+tipoId)
                }
                if(tipoId){
                    switch(+tipoId){
                        case 1:
                            httpClient.get(`/api/paciente/buscarPorUsuario/${usuarioEncontrado.idUsuario}`).then(response => {
                                const paciente : Paciente = response.data 
                                setPaciente(paciente)
                                setCPF(paciente.cpf)
                            })
                            break;
                        case 2:
                            httpClient.get(`/api/medico/buscarPorUsuario/${usuarioEncontrado.idUsuario}`).then(response => {
                                const medico : Medico = response.data 
                                setMedico(medico)
                                setCRM(medico.crm)
                            })
                            break
                        default:
                            break;
                    }
                }    
            })
        } 
    }, [queryId])

    const Submit = (atualizar: boolean) => {
        const usuario: Usuario = {
            idUsuario,
            login,
            senha,
            nome,
            telefone,
            endereco: {rua, numero, bairro, estado, pais},
            unidade: unidadeSelecionada,
            tipoUsuario,
            cpf,
            crm
        }
        if(!atualizar){
            httpClient.post("/api/usuario/add", usuario).then(response => {
                alert("Cadastrado com sucesso!")
            });
        }else{
            httpClient.put(`/api/usuario/${usuario.idUsuario}`, usuario).then(response => {
                alert("Atualizado")
            });
            switch(+tipoId){
                case 1:
                    httpClient.put(`/api/paciente/${paciente.idPaciente}`, {idPaciente: paciente.idPaciente, cpf: cpf, idUsuario: paciente.idUsuario})
                    break;
                case 2:
                    httpClient.put(`/api/medico/${medico.idMedico}`, {idMedico: medico.idMedico, crm: crm, idUsuario: medico.idUsuario})
                    break
                default:
                    break;
            }
        }      
    }

    return (
        <Layout title={idUsuario ? 'Atualizar usuário' : 'Salvar usuário'}>
            {(+idUsuario > 0) &&
                <div className="columns">
                    <Input
                        label="Código: "
                        columnClasses="is-half"
                        id="code"
                        name="code"
                        value={idUsuario}
                        onChange={setIdUsuario}
                        disabled
                    />
                    {(paciente.idPaciente != null && paciente.idPaciente > 0) &&
                        <Input
                            label="Código paciente: "
                            columnClasses="is-half"
                            id="codePaciente"
                            name="codePaciente"
                            value={paciente.idPaciente}
                            disabled
                        />
                    }
                    {(medico.idMedico != null && medico.idMedico > 0) &&
                    <Input
                        label="Código medico: "
                        columnClasses="is-half"
                        id="codeMedico"
                        name="codeMedico"
                        value={medico.idMedico}
                        disabled
                    />
                }
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
                <InputTelefone
                    id="telefone" 
                    name="telefone"
                    label="Telefone: *"
                    autoComplete="off" 
                    columnClasses="is-half"
                    onChange={setTelefone} 
                    value={telefone}
                />
            </div>

            <div className="columns">
                <Input
                    id="login" 
                    name="login"
                    label="Login: *"
                    autoComplete="off"
                    columnClasses="is-half"
                    onChange={setLogin} 
                    value={login}
                />
                <InputTelefone
                    id="senha" 
                    name="senha"
                    label="Senha: *"
                    autoComplete="off" 
                    columnClasses="is-half"
                    type="password"
                    onChange={setSenha}
                    value={senha} 
                />
            </div>

            <div className="columns">
                <DropdownUnidades
                    onChange={setIdUnidade}
                    label="Unidade De Saude *" 
                    columnClasses="is-one-third"
                    id="inputUnidadeDeSaude"
                    index={idUnidade}
                    items={unidadesDeSaude}
                />
                <DropdownTiposUsuarios
                    onChange={setTipoUsuario}
                    label="Tipo de Usuário *" 
                    columnClasses="is-one-third"
                    id="inputTipoUsuario"
                    index={tipoId}  
                    items={tiposUsuario}
                />
                { tipoUsuario == 1 ? (
                    <Input
                        id="cpf"
                        name="cpf"
                        label="CPF *"
                        autoComplete="off" 
                        columnClasses="is-one-third"
                        onChange={setCPF}              
                        value={cpf}
                    />
                ) : tipoUsuario == 2 ? (
                    <Input
                        id="crm"
                        name="crm"
                        label="CRM *"
                        autoComplete="off" 
                        columnClasses="is-one-third"
                        onChange={setCRM}              
                        value={crm}
                    />
                ) : <></>}
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
                        onClick={() => Submit(+idUsuario > 0 ? true : false)}
                        className="button is-dark">
                            {
                                idUsuario ? 'Atualizar' : 'Salvar'
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