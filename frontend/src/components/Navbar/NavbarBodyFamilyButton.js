import React, {useContext} from 'react'
import {NavbarBodyButton} from "./NavBarElements";
import AppContext from "../../context/AppContext";
import {changeView} from "../../context/Actions";



function NavbarBodyFamilyButton() {

    const { dispatch } = useContext(AppContext);

    function handleClick(value) {
        dispatch(changeView(value))
    }

    return(
        <NavbarBodyButton onClick={() => handleClick('family')}>Family</NavbarBodyButton>
    )
}

export default NavbarBodyFamilyButton;