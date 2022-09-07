import { Medico } from "../medico";
import { Usuario } from "../usuario";

export interface Agenda{
    idAgenda?: number;
    data: string
    horario: string
    medico: Medico
    disponibilidade: string
}

const agenda: Agenda = {}