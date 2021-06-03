import styled from 'styled-components';

// Usando Styled Components, o naming desta styled.div não pode ser o mesmo do Componente
// em JS visto que no momento do import na classe correspondente não causa overflow

// Como a row só tem uma partição, apenas se coloca da "linha" 1 à 2
// Como as colunas são constituidas por duas divisões, a primeirpartição é da linha
// 1 à 2 enquanto que a restante vai ser definida no outro componente
export const NavbarDiv = styled.div`

  grid-row-start: 1;
  grid-row-end: 2;
  
  grid-column-start: 1;
  grid-column-end: 2;
  background-color: lightgreen;

  // Implementar o grid system no Parent através da construção do esqueleto e nos childs definir as dimensões de cada secção.
  display: grid;
  height: 100vh;
  
  // Neste situação o "fr" indica a totalidade da tela
  grid-template-columns: 1fr;
  
  // Divisão da tela completa em dois grupos proporcionais, o primeiro de 1/4 do tamanho
  // e o segundo com 3/4 do tamanho. O "fr" indica essa proporção.
  grid-auto-rows: 1fr 2fr 1fr;

`

export const NavbarHeaderDiv = styled.div`

  padding: 20px;
  
`

export const ImageProperties = styled.img`

`

export const NavbarBodyDiv = styled.div`
`

export const NavbarFooterDiv = styled.div`
`

export const NavbarFooterButton = styled.button`

`

export const NavbarBodyButtonStyle = styled.button`
`