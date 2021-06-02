import React, {useContext} from 'react';
import NavbarItem from "./NavbarItem";
import {NavbarBodyButton, NavbarBodyDiv} from "./NavBarElements";
import AppContext from "../../context/AppContext";
import NavbarBodyProfileButton from "./NavbarBodyProfileButton";

function NavbarBody() {

    const { state, dispatch } = useContext(AppContext);
    const { loggedUser } = state;
    const { sm, fa } = loggedUser;

    if(sm === true) {
        return (
            <NavbarBodyDiv>
                <NavbarBodyButton>Create Family</NavbarBodyButton>
            </NavbarBodyDiv>
        )
    } else if (fa === true) {
        return (
            <NavbarBodyDiv>
                <NavbarBodyButton>Family</NavbarBodyButton>
                <br />
                <NavbarBodyProfileButton />
            </NavbarBodyDiv>
        )
    } else {
        return (
            <NavbarBodyDiv>
                <NavbarBodyProfileButton />
            </NavbarBodyDiv>
        )
    }

}

export default NavbarBody;