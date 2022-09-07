import { Paciente } from '../../../../app/model/paciente'
import { Button } from 'primereact/button'
import { confirmDialog } from 'primereact/confirmdialog'
import { DataTable } from 'primereact/datatable'
import { Column } from 'primereact/column'

interface TabelaOrderProps{
    onEdit: (paciente: Paciente) => void
    onDelete: (paciente: Paciente) => void
    pacientes: Array<Paciente>
}

export const TabelaOrder: React.FC<TabelaOrderProps> = ({
    pacientes,
    onDelete,
    onEdit
}) => {

    const actionTemplate = (registro: Paciente) => {

        const url = `api/paciente/${registro.idPaciente}`
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
        <DataTable value={pacientes} paginator rows={10}>
            <Column field="idPaciente" header="ID paciente"/>
            <Column field="cpf" header="CPF"/>
            <Column field="idUsuario" header="ID Usuário"/>
            <Column header="" body={actionTemplate} />
        </DataTable>
    )
}
