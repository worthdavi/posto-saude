
import { useEffect, useState } from 'react';
import { Modal, ModalFooter, ModalBody, ModalHeader, Row, Col, Button } from 'reactstrap';

import api from '../../api'

export const ModalComp = ({ toggleModal, isOpen, idAgenda }) => {

    const [agendaData, setAgendaData] = useState([]);
    const [medicoData, setMedicoData] = useState([])
    const [usuarioData, setUsuarioData] = useState([])
    // ID TA FIXO EM 5 PQ NÃO TEM LOGIN NISSO
    const [pacienteId, setPacienteId] = useState(5)

    useEffect(() => {
        api.get(`/api/agenda/listar/${idAgenda}`).then(response => {
            setAgendaData(response.data)
            setMedicoData(response.data.medico)
        })
        api.get(`/api/usuario/${medicoData.idUsuario}`).then(response => {
            setUsuarioData(response.data)
        })
    }, [idAgenda])

    function marcarConsulta(idPacienteButton, idAgendaButton){
        api.post(`/api/consulta/marcar/${idPacienteButton}/${idAgendaButton}`).then(response => {
            console.log("consulta marcada")
        })
        isOpen = !isOpen
    }

    function showAgenda() {
        return (
            <Row>
                <Col md={6}>
                    Nome do médico: {usuarioData.nome}
                </Col>
                <Col md={6}>
                    CRM: {medicoData.crm}
                </Col>
                <Col md={6}>
                    Telefone: {usuarioData.telefone}
                </Col>
                <Col md={6}>
                    Horário: {agendaData.horario}
                </Col>
                <Col md={6}>
                    Disponibilidade: {agendaData.disponibilidade}
                </Col>
                <Button onClick={() => (marcarConsulta(pacienteId, idAgenda))}>
                    Confirmar
                </Button>
            </Row>
        )
    }

    return (
        <Modal isOpen={isOpen} toggle={toggleModal}>
            <ModalHeader>
                Agendamento de consulta
            </ModalHeader>
            <ModalBody>
                {showAgenda()}
            </ModalBody>
            <ModalFooter/>
        </Modal>
    )
}