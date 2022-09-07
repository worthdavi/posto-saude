import { Usuario } from "../usuario";

export interface Medico{
    idMedico?: number;
    crm: string
    idUsuario: number
    usuario?: Usuario
}

const medico: Medico = {}