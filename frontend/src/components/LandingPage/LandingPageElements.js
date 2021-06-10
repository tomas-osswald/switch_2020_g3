import styled from "styled-components";
import background from '../../assets/bg-gorila.jpg'

export const LandingPageDiv = styled.div`
  background: url(${background}) center center/cover no-repeat;
  height: 100vh;
  width: 100%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  box-shadow: inset 0 0 0 1000px rgba(0,0,0, 0.2);
  object-fit: contain;
`

export const MainText = styled.text`
  color: #fff;
  font-size: 100px;
  margin-top: 0px;
`

export const UserName = styled.text`
  color: #fff;
  font-size: 32px;
  margin-top: 8px;
`