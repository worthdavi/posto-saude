import { useRef, useState } from "react";

import { Col, FormGroup, Input, Label, Button } from "reactstrap";

import { HiArrowSmRight } from "react-icons/hi";
import * as Style from "./style";

import { ConditionalInput } from "./ConditionalInput";

import { Adress } from "./Addres";

export const RegisterUser = () => {
  const ref = useRef([]);

  const [data, setData] = useState([]);
  const [userType, setUserType] = useState(0);
  const [nextStep, setNextStep] = useState(false);

  const handleData = (event) => {

    const value = event.target.value
    const name = event.target.name
    setData({
      ...data,
      [name]: value
    });

  };

  console.log(data)

  const toggleStep = () => {
    setNextStep(false)
  }

  return (
    <Style.FormContainer ref={ref}>
      {!nextStep ? (
        <FormGroup onChange={(e) => handleData(e)} row className="form-group-style">
          <Col md={6} className="column-card-register">
            <Label size="lg">Dados do usuário</Label>
            <Input
              bsSize="lg"
              type="select"
              className="input-register-style"
              onChange={() => setUserType(ref.current[0].value)}
              name="tipoUsuario"
            >
              <option selected value="">
                Tipo de usuário
              </option>
              <option value={4}>Administrador</option>
              <option value={3}>Funcionário</option>
              <option value={2}>Médico</option>
              <option value={1}>Paciente</option>
            </Input>
            <ConditionalInput
              typeUser={userType}
              handleValue={(event) => {
                handleData(event)
              }}
            />
            <Input
              placeholder="Nome"
              bsSize="lg"
              className="input-register-style"
              name="nome"
            />
            <Input
              placeholder="Telefone"
              type="text"
              bsSize="lg"
              className="input-register-style"
              name="telefone"
            />
            <Input
              bsSize="lg"
              placeholder="(login)Nome de usuário"
              className="input-register-style"
              name="login"
            />
            <Input
              bsSize="lg"
              placeholder="senha"
              type="password"
              className="input-register-style"
              name="senha"
            />
            <Button
              size="lg"
              className="button-register-style"
              onClick={() => setNextStep(true)}
            >
              Continuar
              <HiArrowSmRight color="#fff" size={25} />
            </Button>
          </Col>
        </FormGroup>
      ) : (
        <Adress toggleStep={toggleStep} data={data} />
      )}
    </Style.FormContainer>
  );
};
