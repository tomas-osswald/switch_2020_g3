import React, {useContext} from 'react'
import {NavbarBodyButton} from "./NavBarElements";
import AppContext from "../../context/AppContext";
import {fetchNewProfile} from "../../context/Actions";


function NavbarBodyProfileButton() {

    const { state, dispatch } = useContext(AppContext);
    const { loggedUser } = state;
    const { id } = loggedUser;

    function handleClick() {
    }

    return(
        <NavbarBodyButton onClick={handleClick()}>Profile</NavbarBodyButton>
    )
}

export default NavbarBodyProfileButton;