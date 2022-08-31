import styled from "styled-components";

export const Container = styled.section`
  width: 100%;
  min-height: 100vh;
  background: #0034;

  .row-style-subjective {
    padding: 10px;
  }
`;

export const CardListDoctors = styled.div`
  display: flex;
  flex-direction: column;
  background: red;
  width: 100%;
  height: 230px;
  color: #fff;
  border-radius: 10px;
  padding: 5px;
  border: 0;
  align-items: center;
`;

export const ButtonCard = styled.button`
    border: 0;
    outline-style: none;
    border-radius: 5px;
    width: 100%;
    height: 40px;
    text-transform: uppercase;
    font-weight: 600;
    background-color: #3498DB;
    color: #fff;
    transition: ease-in-out .3s;
    margin: auto 0 0 0;

    &:hover {
        filter: brightness(1.2);
    }
`;

export const ImageProfile = styled.div`
    width: 5rem;
    height: 5rem;
    background: peru;
    border-radius: 50%;
`
