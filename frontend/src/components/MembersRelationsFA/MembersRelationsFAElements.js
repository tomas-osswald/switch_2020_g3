import styled from 'styled-components';

export const MembersRelationsFADiv = styled.div`
  
    background-color: lightblue;
`

export const HeaderCell = styled.div`

  padding-left: 100px;

`

export const HeaderSection = styled.div`

  width: 1000px;
  //background-color: coral;
  display: flex;
  flex-direction: row;
  
`

export const ButtonCell = styled.div`
  margin-left: 50px;
`

export const RelationsList = styled.td`
  display: ${ ({props}) => (props ? 'block' : 'none') } ;
  //{display => (display ? "block" : "none")}
`

