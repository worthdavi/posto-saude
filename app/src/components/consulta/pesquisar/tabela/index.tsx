import { Consulta } from '../../../../app/model/consulta'
import { Button } from 'primereact/button'
import { confirmDialog } from 'primereact/confirmdialog'
import { DataTable } from 'primereact/datatable'
import { Column } from 'primereact/column'
import { Agenda } from '../../../../app/model/agenda'

interface TabelaConsultasProps{
    onEdit: (consulta: Consulta) => void
    onDelete: (consulta: Consulta) => void
    consultas: Array<Consulta>
    agendas: Array<Agenda>
}

export const TabelaConsultas: React.FC<TabelaConsultasProps> = ({
    consultas,
    agendas,
    onDelete,
    onEdit
}) => {

    const actionTemplate = (registro: Consulta) => {
        return (
            <div>
                <Button 
                    label="Desmarcar" 
                    className="p-button-rounded p-button-danger"
                    onClick={e => onDelete(registro)}
                />
            </div>
        )
    }

    return(
        <DataTable value={agendas} paginator rows={10}>
            <Column field="idAgenda" header="ID Agenda"/>
            <Column field="data" header="Data"/>
            <Column field="horario" header="Horario"/>
            <Column field="medico.crm" header="Médico (CRM)"/>
            <Column field="disponibilidade" header="Disponibilidade"/>
            <Column header="Actions" body={actionTemplate} />
        </DataTable>
    )
}
