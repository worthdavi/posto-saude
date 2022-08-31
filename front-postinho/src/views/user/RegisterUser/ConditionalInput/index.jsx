import { Input } from "reactstrap";

export const ConditionalInput = ({ typeUser, handleValue }) => {
  // handleValue = (e) => {
  //   let regex = e.replace(/\D/g, "");
  //   regex = regex.replace(/(\d{3})(\d)/, "$1.$2");
  //   regex = regex.replace(/(\d{3})(\d)/, "$1.$2");
  //   regex = regex.replace(/(\d{3})(\d{1,2})$/, "$1-$2");
  //   return regex;
  // };

  return (
    <>
      <Input
        bsSize="lg"
        onChange={(e) => handleValue(e)}
        name={typeUser == 1
          ? "cpf"
          : typeUser == 3
          ? "registro"
          : typeUser == 2
          ? "crm"
          : ""}
        placeholder={
          typeUser == 1
            ? "CPF"
            : typeUser == 3
            ? "Registro"
            : typeUser == 2
            ? "CRM"
            : "CODIGO - (ADM)"
        }
      />
    </>
  );
};
