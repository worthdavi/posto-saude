import { useEffect, useState } from "react";
import { useDispatch } from "react-redux";
import { changeModalRealTime } from "../../../features/modalEdit/chengeModal";

import * as Style from "./style";

import { Row, Col, Table } from "reactstrap";
import { MdUnfoldMore, MdEdit, MdDelete } from "react-icons/md";

import { EditUser } from '../Edit';

export const ListUser = () => {
  const dispatch = useDispatch();
  const [data, setData] = useState([]);

  useEffect(() => {}, []);

  return (
    <Style.Container>
      <Row className="row-style-subjective" xs={1} md={12}>
        <Table responsive>
          <thead>
            <tr>
              <th>NOME</th>
              <th>TELEFONE</th>
              <th>TIPO</th>
              <th>LOGIN</th>
              <th>AÇÕES</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>line</td>
              <td>line</td>
              <td>line</td>
              <td>line</td>
              <td>
                <Style.ButtonAction setColor="#5793ED">
                  <MdUnfoldMore size={30} />
                </Style.ButtonAction>
                <Style.ButtonAction
                  onClick={() => dispatch(changeModalRealTime())}
                  setColor="#5793ED"
                >
                  <MdEdit size={30} />
                </Style.ButtonAction>
                <Style.ButtonAction setColor="#F97272">
                  <MdDelete size={30} />
                </Style.ButtonAction>
              </td>
            </tr>
          </tbody>
        </Table>
        <EditUser />
      </Row>
    </Style.Container>
  );
};
