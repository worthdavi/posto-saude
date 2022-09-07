import { FormatUtils } from '@4us-dev/utils'
import { InputHTMLAttributes } from 'react';
import { Agenda } from '../../../app/model/agenda';
import { Medico } from '../../../app/model/medico';
import { Paciente } from '../../../app/model/paciente';
import { TipoUsuario } from '../../../app/model/tipoUsuario';
import { UnidadeDeSaude } from '../../../app/model/unidade';

const formatUtils = new FormatUtils();

interface InputProps extends InputHTMLAttributes<HTMLInputElement> {
    id: string;
    label: string;
    columnClasses?: string;
    error?: string;
    inputtype?: string;
    formatter?: (value: string) => string;
    onChange?: (value: any) => void
}

export const Input: React.FC<InputProps> = ({
    label,
    columnClasses,
    id,
    type,
    error,
    formatter,
    onChange,
    ...inputProps
}: InputProps) => {

    const onInputChange = (event: any) => {
        const value = event.target.value;
        const name = event.target.name;
        const formattedValue = (formatter && formatter(value as string)) || value
        onChange(formattedValue)
    }

    return (
        <div className={`field column ${columnClasses}` }>
            <label className="label" htmlFor={id}>{label}</label>
            <div className="control">
                <input type={type != undefined ? type : "string"} className="input" 
                    onChange={onInputChange}
                    id={id} {...inputProps} />
                {error &&
                    <p className="help is-danger">{ error }</p>
                }
            </div>
        </div>
    )
}

interface DropdownProps{
    onChange?: (value: any) => void
    label: string
    columnClasses: string;
    id: string;
    items: string[]
}

export const DropdownMenu: React.FC<DropdownProps> = (props: DropdownProps) => {
    function renderItems(){
        return props.items.map((item, i) => {
            return <option key={i} value={item}>{item}</option>
        })
    }
    return(
        <div className={`field column ${props.columnClasses}`}>
            <label className="label" htmlFor={props.id}>{props.label}</label>
            <div className="select is-primary">
                <select
                
                onChange={ event => {
                    if(props.onChange){
                        props.onChange(event.target.value);
                    }
                }}>
                    {renderItems()}
                </select>
            </div>
        </div>       
    )
}

interface DropdownMenuCustomer{
    onChange?: (value: any) => void
    label: string
    columnClasses: string;
    id: string;
    customers: Customer[]
}

export const DropdownMenuCustomer: React.FC<DropdownMenuCustomer> = (props: DropdownMenuCustomer) => {
    function renderItems(){
        return props.customers.map((customer: Customer, i) => {
            return <option key={i} value={customer.id}>{customer.name}</option>
        })
    }
    return(
        <div className={`field column ${props.columnClasses}`}>
            <label className="label" htmlFor={props.id}>{props.label}</label>
            <div className="select is-primary">
                <select              
                    onChange={ event => {
                        if(props.onChange){
                            props.onChange(event.target.value);
                        }
                    }}>
                    {renderItems()}
                </select>
            </div>
        </div>       
    )
}

export const InputCPF: React.FC<InputProps> = (props: InputProps) => {
    return (
        <Input {...props} formatter={formatUtils.formatCPF} />
    )
}

export const InputTelefone: React.FC<InputProps> = (props: InputProps) => {
    return (
        <Input {...props} formatter={formatUtils.formatPhone} />
    )
}


interface DropdownUnidadesProps{
    onChange?: (value: any) => void
    label: string
    columnClasses: string;
    id: string;
    items: UnidadeDeSaude[]
    index: number
}

export const DropdownUnidades: React.FC<DropdownUnidadesProps> = (props: DropdownUnidadesProps) => {
    return(
        <div className={`field column ${props.columnClasses}`}>
            <label className="label" htmlFor={props.id}>{props.label}</label>
            <div className="select is-primary">
                <select         
                    onChange={ event => {
                        if(props.onChange){
                            props.onChange(event.target.value);
                        }
                    }}>
                    {props.items.map(unidade => {
                        return <option key={unidade.idUnidade} selected={props.index == unidade.idUnidade} value={unidade.idUnidade}>{unidade.nome}</option>
                    })}
                </select>
            </div>
        </div>       
    )
}


interface DropdownTiposUsuariosProps{
    onChange?: (value: any) => void
    label: string
    columnClasses: string;
    id: string;
    items: TipoUsuario[]
    index: number
}

export const DropdownTiposUsuarios: React.FC<DropdownTiposUsuariosProps> = (props: DropdownTiposUsuariosProps) => {
    function renderItems(){
        return props.items.map((item, i) => {
            return <option selected={item.id == props.index} key={i} value={item.id}>{item.nome}</option>
        })
    }
    return(
        <div className={`field column ${props.columnClasses}`}>
            <label className="label" htmlFor={props.id}>{props.label}</label>
            <div className="select is-primary">
                <select        
                    onChange={ event => {
                        if(props.onChange){
                            props.onChange(event.target.value);
                        }
                    }}>
                    {renderItems()}
                </select>
            </div>
        </div>       
    )
}


interface DropdownMedicosProps{
    onChange?: (value: any) => void
    label: string
    columnClasses: string;
    id: string;
    items: Medico[]
    selecionado?: number
}

export const DropdownMedicos: React.FC<DropdownMedicosProps> = (props: DropdownMedicosProps) => {
    return(
        <div className={`field column ${props.columnClasses}`}>
            <label className="label" htmlFor={props.id}>{props.label}</label>
            <div className="select is-primary">
                <select         
                    onChange={event => {
                        if(props.onChange){
                            props.onChange(event.target.value);
                        }
                    }}>
                    {props.items.map(medico => {
                        return <option key={medico.idMedico} selected={props.selecionado == medico.idMedico} value={medico.idMedico}>{medico.crm}</option>
                    })}
                </select>
            </div>
        </div>       
    )
}

interface DropdownPacientesProps{
    onChange?: (value: any) => void
    label: string
    columnClasses: string;
    id: string;
    items: Paciente[]
    selecionado?: number
}

export const DropdownPacientes: React.FC<DropdownPacientesProps> = (props: DropdownPacientesProps) => {
    return(
        <div className={`field column ${props.columnClasses}`}>
            <label className="label" htmlFor={props.id}>{props.label}</label>
            <div className="select is-primary">
                <select         
                    onChange={event => {
                        if(props.onChange){
                            props.onChange(event.target.value);
                        }
                    }}>
                    {props.items.map(paciente => {
                        return <option key={paciente.idPaciente} selected={props.selecionado == paciente.idPaciente} value={paciente.idPaciente}>{paciente.cpf}</option>
                    })}
                </select>
            </div>
        </div>       
    )
}

interface DropdownAgendasProps{
    onChange?: (value: any) => void
    label: string
    columnClasses: string;
    id: string;
    items: Agenda[]
    selecionado?: number
}

export const DropdownAgendas: React.FC<DropdownAgendasProps> = (props: DropdownAgendasProps) => {
    return(
        <div className={`field column ${props.columnClasses}`}>
            <label className="label" htmlFor={props.id}>{props.label}</label>
            <div className="select is-primary">
                <select         
                    onChange={event => {
                        if(props.onChange){
                            props.onChange(event.target.value);
                        }
                    }}>
                    {props.items.map(agenda => {
                        return <option key={agenda.idAgenda} selected={props.selecionado == agenda.idAgenda} value={agenda.idAgenda}>{agenda.horario}</option>
                    })}
                </select>
            </div>
        </div>       
    )
}