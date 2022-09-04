import { useEffect, useState } from "react";

import { useNavigate } from "react-router-dom";

import * as Style from "./style";

import api from "../../api";

import { ModalComp } from "../../components/Modal";

import { Row, Col, Input } from "reactstrap";
import { MdAccountCircle } from "react-icons/md";

export const ListDoctors = () => {
  const navigate = useNavigate();

  const [modal, setModal] = useState(false);
  const [dataAgenda, setDataAgenda] = useState([]);
  const [data, setData] = useState("2022-02-20")
  const [idCurrentAgenda, setIdCurrentAgenda] = useState(0);

  useEffect(() => {
    api.get(`/api/agenda/listar/data/${data}`).then((response) => {
      setDataAgenda(response.data);
    });
  }, [data]);

  const toggleModal = (id) => {
    setIdCurrentAgenda(id);
    setModal(!modal);
  };

  return (
    <Style.Container>
      <Row className="row-style-subjective" xs={1} md={4}>
        <Input
          placeholder="Data"
          bsSize="lg"
          className="input-register-style"
          name="data"
          value={data}
          onChange={(event) => setData(event.target.value)}
        />
        <ModalComp toggleModal={toggleModal} idAgenda={idCurrentAgenda} isOpen={modal} />
        {dataAgenda.length > 0 &&
          dataAgenda.map((agenda) => {
            return (
              <Col key={agenda.idAgenda} md={3} sm={6}>
                <Style.CardListDoctors>
                  {false ? (
                    <Style.ImageProfile src={null} />
                  ) : (
                    <MdAccountCircle size={65} />
                  )}
                  STATUS: {agenda.disponibilidade}
                  {
                    agenda.disponibilidade != "OCUPADO" ? (
                      <Style.ButtonCard
                        onClick={() =>toggleModal(agenda.idAgenda)}
                      >
                        Agendar
                      </Style.ButtonCard>
                    ) : <></>
                  }
                </Style.CardListDoctors>
              </Col>
            );
          })}
      </Row>
    </Style.Container>
  );
};
