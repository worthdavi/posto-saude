import styled from "styled-components";

export const Container = styled.section`
  width: 100%;
  min-height: 100vh;
  background: #fbfafa;

  .row-style-subjective {
    padding: 10px;
  }
`;

export const CardConsultation = styled.div`
  display: flex;
  flex-direction: column;
  background: #fff;
  width: 100%;
  height: 230px;
  color: #000;
  border-radius: 10px;
  padding: 5px;
  border: 0;
  align-items: center;
  -webkit-box-shadow: 0px 0px 5px 0px rgba(0, 0, 0, 0.07);
  -moz-box-shadow: 0px 0px 5px 0px rgba(0, 0, 0, 0.07);
  box-shadow: 0px 0px 5px 0px rgba(0, 0, 0, 0.07);
`;

export const CardSchedule = styled.div`
  width: 100%;
  height: 600px;
  border-radius: 10px;
  background: #fff;
  -webkit-box-shadow: 0px 0px 5px 0px rgba(0, 0, 0, 0.07);
  -moz-box-shadow: 0px 0px 5px 0px rgba(0, 0, 0, 0.07);
  box-shadow: 0px 0px 5px 0px rgba(0, 0, 0, 0.07);
`;

export const ProfileImage = styled.div`
  height: 7rem;
  width: 7rem;
  border: 0;
  border-radius: 50%;
  background: blue;
`;
