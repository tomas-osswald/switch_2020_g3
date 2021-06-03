import React, {useContext} from 'react';
import NavbarItem from "./NavbarItem";
import {NavbarBodyButton, NavbarBodyDiv} from "./NavBarElements";
import AppContext from "../../context/AppContext";
import NavbarBodyProfileButton from "./NavbarBodyProfileButton";
import NavbarBodyFamilyButton from "./NavbarBodyFamilyButton";
import NavbarBodyCreateFamilyButton from "./NavbarBodyCreateFamilyButton";

function NavbarBody() {

    const { state, dispatch } = useContext(AppContext);
    const { loggedUser } = state;
    const { sm, fa } = loggedUser;



    if(sm === true) {
        return (
            <NavbarBodyDiv>
                <NavbarBodyFamilyButton />
                <br />
                <NavbarBodyProfileButton />
                <br />
                <NavbarBodyCreateFamilyButton valor="createFamily" description="Create a Family" />
            </NavbarBodyDiv>
        )
    } else if (fa === true) {
        return (
            <NavbarBodyDiv>
                <NavbarBodyFamilyButton />
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