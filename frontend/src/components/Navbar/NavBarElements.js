import styled from 'styled-components';

// Usando Styled Components, o naming desta styled.div não pode ser o mesmo do Componente
// em JS visto que no momento do import na classe correspondente não causa overflow
export const NavbarDiv = styled.div`


    // Como a row só tem uma partição, apenas se coloca da "linha" 1 à 2
    grid-row-start: 1;
    grid-row-end: 2;
    // Como as colunas são constituidas por duas divisões, a primeirpartição é da linha 
    // 1 à 2 enquanto que a restante vai ser definida no outro componente
    grid-column-start: 1;
    grid-column-end: 2;


`