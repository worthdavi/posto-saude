import { Usuario } from "../usuario";

export interface Paciente{
    idPaciente?: number;
    cpf: string
    idUsuario: number
    usuario?: Usuario
}

const paciente: Paciente = {}