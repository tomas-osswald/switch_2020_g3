import React, {useContext} from 'react'
import {NavbarBodyButton} from "./NavBarElements";
import AppContext from "../../context/AppContext";
import {changeView} from "../../context/Actions";



function NavbarBodyCreateFamilyButton(props) {

    const { dispatch } = useContext(AppContext);

    function handleClick(value) {
        dispatch(changeView(value))
    }

    return(
        <NavbarBodyButton onClick={() => handleClick(props.valor)}>{props.description}</NavbarBodyButton>
    )
}

export default NavbarBodyCreateFamilyButton;