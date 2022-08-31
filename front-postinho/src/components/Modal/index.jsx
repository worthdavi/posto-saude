
import { useEffect, useState } from 'react';
import { Modal, ModalFooter, ModalBody, ModalHeader, Row, Col, Button } from 'reactstrap';

import api from '../../api'

export const ModalComp = ({ toggleModal, isOpen, idUser }) => {

    const [medicalData, setMedicalData] = useState([]);

    useEffect(() => {
        api.get(`/api/medico/listar`).then(res => {
            setMedicalData(res.data)
        })
    }, [idUser]);

    useEffect(() => {
        api.get(`/api/agenda/listar/${1}`).then(response => {
            console.log(response)
        })
    }, [])

    return (
        <Modal isOpen={isOpen} toggle={toggleModal}>
            <ModalHeader>
                Agendamento de consulta
            </ModalHeader>
            <ModalBody>
                <Row>
                    <Col md={6}>
                        nome: 
                    </Col>
                    <Col md={6}>
                        crm: 
                    </Col>
                    <Col md={6}>
                        cidade: 
                    </Col>
                    <Col md={6}>
                        info1: 
                    </Col>
                </Row>
            </ModalBody>
            <ModalFooter>
                <Button>
                    Confirmar
                </Button>
            </ModalFooter>
        </Modal>
    )
}