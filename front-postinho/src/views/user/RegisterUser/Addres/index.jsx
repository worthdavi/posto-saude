import { useEffect, useState } from "react";

import { Col, FormGroup, Input, Label, Button } from "reactstrap";
import api from "../../../../api";
import { toast } from 'react-toastify'

export const Adress = ({ data, toggleStep }) => {
  const [dataUser, setDataUser] = useState({});
  const [unidade, setUnidade] = useState([]);

  const handleData = (event) => {
    const value = event.target.value;
    const name = event.target.name;

    setDataUser({
      ...dataUser,
      [name]: value,
    });
  };

  const onRegisterUser = () => {
    const payload = { ...data, endereco: dataUser, unidade: unidade[0] };

    api
      .post("api/usuario/add", payload)
      .then((response) => {
        toast.success("Usuario salvo com sucesso!", {
          position: toast.POSITION.TOP_CENTER
        });
      })
      .catch((error) => {
        console.log("error", error);
      });
  };

  useEffect(() => {
    api
      .get("api/unidade/listar")
      .then((response) => {
        setUnidade(response.data);
      })
      .catch((error) => error);
  }, []);

  return (
    <FormGroup
      onChange={(event) => handleData(event)}
      row
      className="form-group-style"
    >
      <Col md={12}>
        <Button
          size="lg"
          className="button-register-style"
          onClick={toggleStep}
        >
          Voltar
        </Button>
      </Col>
      <Col md={6} className="column-card-register">
        <Label size="lg">Endereço</Label>
        <Input
          placeholder="País"
          bsSize="lg"
          className="input-register-style"
          name="pais"
        />
        <Input
          placeholder="Estado"
          type="select"
          bsSize="lg"
          className="input-register-style"
          name="estado"
        >
          {unidade.map((item) => {
            return (
              <option key={item.idUnidade} value={item}>
                {item.nome}
              </option>
            );
          })}
        </Input>
        <Input
          placeholder="Estado"
          type="text"
          bsSize="lg"
          className="input-register-style"
          name="estado"
        />
        <Input
          bsSize="lg"
          placeholder="Rua"
          className="input-register-style"
          name="rua"
        />
        <Input
          bsSize="lg"
          placeholder="Bairro"
          type="text"
          className="input-register-style"
          name="bairro"
        />
        <Input
          bsSize="lg"
          placeholder="Número"
          className="input-register-style"
          name="numero"
          type="number"
        />
        <Button
          size="lg"
          onClick={onRegisterUser}
          className="button-register-style"
        >
          Registrar
        </Button>
      </Col>
    </FormGroup>
  );
};
