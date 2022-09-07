import { Agenda } from '../../../../app/model/agenda'
import { Button } from 'primereact/button'
import { confirmDialog } from 'primereact/confirmdialog'
import { DataTable } from 'primereact/datatable'
import { Column } from 'primereact/column'

interface TabelaAgendaProps{
    onEdit: (agenda: Agenda) => void
    onDelete: (agenda: Agenda) => void
    agendas: Array<Agenda>
}

export const TabelaAgenda: React.FC<TabelaAgendaProps> = ({
    agendas,
    onDelete,
    onEdit
}) => {

    const actionTemplate = (registro: Agenda) => {

        const url = `api/agenda/${registro.idAgenda}`
        return (
            <div>
                <Button label="Editar" 
                        className="p-button-rounded p-button-info"
                        onClick={e => onEdit(registro)}
                        />
                <Button label="Deletar" 
                    className="p-button-rounded p-button-danger"
                    onClick={e => onDelete(registro)}
                     />
            </div>
        )
    }

    return(
        <DataTable value={agendas} paginator rows={10}>
            <Column field="idAgenda" header="ID agenda"/>
            <Column field="data" header="Data"/>
            <Column field="horario" header="horario"/>
            <Column field="medico.idMedico" header="ID médico"/>
            <Column field="disponibilidade" header="Disponibilidade"/>
            <Column header="" body={actionTemplate} />
        </DataTable>
    )
}
