import styled from "styled-components";

export const Container = styled.section`
    width: 100%;
    min-height: 100vh;
    background: #fff;

    .row-style-subjective {
        padding: 10px;
    }
`;

export const CardConsultation = styled.div`
    background: red;
    width: 100%;
    height: 200px;
    color: #fff;
    border-radius: 10px;
    padding: 3px;
    border: 0;
`;

export const ButtonAction = styled.button`
    border: 0;
    padding: 5px;
    background: transparent;
    cursor: pointer;
    border-radius: 12px;
    transition: ease .3s;
    margin: 0 5px;

    svg {
        color: ${({ setColor }) => setColor ? setColor : "gray"};
    }

    &:hover {
        background: ${({ setColor }) => setColor ? setColor : "gray"};
        svg {
            color: #fff;
        }
    }
`;