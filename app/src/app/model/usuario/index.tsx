export interface Usuario{
    idUsuario?: number;
    login: string;
    senha: string;
    nome: string;
    telefone: string;
    endereco: object;
    unidade: object;
    tipoUsuario: number
    cpf?: string
    crm?: string
}

const usuario: Usuario = {}