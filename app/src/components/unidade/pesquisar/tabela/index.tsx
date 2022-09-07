import { UnidadeDeSaude } from '../../../../app/model/unidade'
import { Button } from 'primereact/button'
import { confirmDialog } from 'primereact/confirmdialog'
import { DataTable } from 'primereact/datatable'
import { Column } from 'primereact/column'

interface TabelaUnidadesProps{
    onEdit: (unidade: UnidadeDeSaude) => void
    onDelete: (unidade: UnidadeDeSaude) => void
    unidades: Array<UnidadeDeSaude>
}

export const TabelaUnidades: React.FC<TabelaUnidadesProps> = ({
    unidades,
    onDelete,
    onEdit
}) => {

    const actionTemplate = (registro: UnidadeDeSaude) => {

        const url = `api/unidade/${registro.idUnidade}`
        return (
            <div>
                <Button 
                    label="Editar" 
                    className="p-button-rounded p-button-info"
                    onClick={e => onEdit(registro)}
                />
                <Button 
                    label="Deletar" 
                    className="p-button-rounded p-button-danger"
                    onClick={e => onDelete(registro)}
                />
            </div>
        )
    }

    return(
        <DataTable value={unidades} paginator rows={10}>
            <Column field="idUnidade" header="ID unidade"/>
            <Column field="nome" header="Nome"/>
            <Column header="Actions" body={actionTemplate} />
        </DataTable>
    )
}
