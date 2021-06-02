import React, {useContext} from 'react'
import {NavbarBodyButton} from "./NavBarElements";
import AppContext from "../../context/AppContext";
import {changeView} from "../../context/Actions";



function NavbarBodyProfileButton() {

    const { dispatch } = useContext(AppContext);

    function handleClick(value) {
        dispatch(changeView(value))
    }

    return(
        <NavbarBodyButton onClick={() => handleClick('profile')}>Profile</NavbarBodyButton>
    )
}

export default NavbarBodyProfileButton;