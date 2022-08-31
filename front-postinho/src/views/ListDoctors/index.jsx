import { useEffect, useState } from "react";

import { useNavigate } from "react-router-dom";

import * as Style from "./style";

import api from "../../api";

import { ModalComp } from "../../components/Modal";

import { Row, Col } from "reactstrap";
import { MdAccountCircle } from "react-icons/md";

export const ListDoctors = () => {
  const navigate = useNavigate();

  const [modal, setModal] = useState(false);
  const [dataUser, setDataUsers] = useState([]);
  const [idCurrentUser, setIdCurrentUser] = useState(null);

  useEffect(() => {
    api.get("/api/usuario/listar").then((response) => {
      setDataUsers(response.data);
    });
  }, []);

  const toggleModal = (id) => {
    setIdCurrentUser(id);
    if(id) {
      setModal(!modal);
    }
  };

  return (
    <Style.Container>
      <Row className="row-style-subjective" xs={1} md={4}>
        <ModalComp toggleModal={toggleModal} idUser={idCurrentUser} isOpen={modal} />
        {dataUser.length > 0 &&
          dataUser.map((user) => {
            return (
              <Col key={user.idUsuario} md={3} sm={6}>
                <Style.CardListDoctors>
                  {false ? (
                    <Style.ImageProfile src={null} />
                  ) : (
                    <MdAccountCircle size={65} />
                  )}
                  <Style.ButtonCard
                    onClick={() =>toggleModal(3)}
                  >
                    Agendar
                  </Style.ButtonCard>
                </Style.CardListDoctors>
              </Col>
            );
          })}
      </Row>
    </Style.Container>
  );
};
