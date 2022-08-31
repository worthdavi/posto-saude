
import * as Style from './style';

export const Calendar = () => {
    const date = new Date();

    const weekdays = ["domingo", "segunda-feira", "terça-feira", "quarta-feira", "quinta-feira", "sexta-feira", 'sábado'];

    const day = date.getDate();
    const month = date.getMonth();
    const year = date.getFullYear();

    const firstDayOfMonth = new Date(year, month, 1);
    const daysInMonth = new Date(year, month + 1, 0).getDate();

    const dateString = firstDayOfMonth.toLocaleDateString('pt-br', {
        weekday: "long",
        year: "numeric",
        month: "numeric",
        day: "numeric"
    });

    const paddingDays = weekdays.indexOf(dateString.split(', ')[0]);
    
    const teste = [];

    for(let i = 1; i <= paddingDays + daysInMonth; i++){
       if(i > paddingDays){
        teste.push(i);
       }
    }
    return (
        <Style.Container>
            {teste.map(item => {
                return (
                    <Style.ContentDay>{item}</Style.ContentDay>
                )
            })}
        </Style.Container>
    )
}