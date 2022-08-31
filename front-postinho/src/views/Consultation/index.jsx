import { useState } from "react";
import { useParams } from "react-router-dom";

import * as Style from "./style";

import { Row, Col, Label } from "reactstrap";
import { FaClinicMedical } from 'react-icons/fa';

export const Consultation = () => {
  const paramsUrl = useParams();

  const [dates, setDates] = useState(new Date());

  return (
    <Style.Container>
      <Row xs={2} md={6} style={{ padding: '10px' }}>
        <Col md={6} sm={12}>
          <Style.CardConsultation>
            <Style.ProfileImage />
            <Label>CRM</Label>
          </Style.CardConsultation>
        </Col>
        <Col md={6} sm={12}>
          <Style.CardConsultation>
            <FaClinicMedical size={35} color='#3498DB' />
            <Label>CRM</Label>
          </Style.CardConsultation>
        </Col>
      </Row>
      <Row style={{ padding: '10px' }}>
        <Col md={8}>
          <Style.CardSchedule>

          </Style.CardSchedule>
        </Col>
        <Col md={4}>
          <Style.CardSchedule>
            
          </Style.CardSchedule>
        </Col>
      </Row>
    </Style.Container>
  );
};
