import styled from 'styled-components';

export const MembersRelationsFADiv = styled.div`
  
    background-color: var(--backgroundGrey);;
`

export const HeaderCell = styled.div`

  padding-left: 100px;

`

export const HeaderSection = styled.div`
  width: 90%;
  
`

export const ButtonCell = styled.div`
  margin-left: 50px;
`

export const RelationsList = styled.td`
  display: ${ ({props}) => (props ? 'block' : 'none') } ;
  
`

