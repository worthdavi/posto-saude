import { Agenda } from "../agenda";
import { Medico } from "../medico";
import { Paciente } from "../paciente";
import { Usuario } from "../usuario";

export interface Consulta{
    idConsulta?: number;
    idAgenda: number
    idPaciente: number
    agenda?: Agenda
    paciente?: Paciente
}

const consulta: Consulta = {}