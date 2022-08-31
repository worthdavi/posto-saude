import { useSelector, useDispatch } from 'react-redux';
import { changeModalRealTime } from '../../../features/modalEdit/chengeModal';

import * as Style from './style';
import { Modal, ModalHeader, ModalBody, ModalFooter } from 'reactstrap';

export const EditUser = () => {
    const isOpenModalEdit = useSelector(state => state.modal.isOpen);

    const dispatch = useDispatch();

    return (
        <Style.Container>
            <Modal isOpen={isOpenModalEdit} fullscreen>
                <ModalHeader>teste</ModalHeader>
                <ModalBody>
                    bodyyyyy
                </ModalBody>
                <ModalFooter>
                    footer
                </ModalFooter>
            </Modal>
        </Style.Container>
    )
}