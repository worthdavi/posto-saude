import { Medico } from '../../../../app/model/medico'
import { Button } from 'primereact/button'
import { confirmDialog } from 'primereact/confirmdialog'
import { DataTable } from 'primereact/datatable'
import { Column } from 'primereact/column'

interface TabelaOrderProps{
    onEdit: (medico: Medico) => void
    onDelete: (medico: Medico) => void
    medicos: Array<Medico>
}

export const TabelaOrder: React.FC<TabelaOrderProps> = ({
    medicos,
    onDelete,
    onEdit
}) => {

    const actionTemplate = (registro: Medico) => {

        const url = `api/medico/${registro.idMedico}`
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
        <DataTable value={medicos} paginator rows={10}>
            <Column field="idMedico" header="ID médico"/>
            <Column field="crm" header="CRM"/>
            <Column field="idUsuario" header="ID Usuário"/>
            <Column header="" body={actionTemplate} />
        </DataTable>
    )
}
