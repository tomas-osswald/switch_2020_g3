import React, {useContext} from 'react';
import {NavbarBodyButtonStyle, NavbarBodyDiv} from "./NavBarElements";
import AppContext from "../../context/AppContext";
import NavbarBodyButton from "./NavbarBodyButton";

function NavbarBody() {

    const { state, dispatch } = useContext(AppContext);
    const { loggedUser } = state;
    const { sm, fa } = loggedUser;



    if(sm === true) {
        return (
            <NavbarBodyDiv>
                <NavbarBodyButton valor="family" description="Family" />
                <br />
                <NavbarBodyButton valor="profile" description="Profile" />
                <br />
                <NavbarBodyButton valor="createFamily" description="Create a Family" />
            </NavbarBodyDiv>
        )
    } else if (fa === true) {
        return (
            <NavbarBodyDiv>
                <NavbarBodyButton valor="family" description="Family" />
                <br />
                <NavbarBodyButton valor="profile" description="Profile" />
            </NavbarBodyDiv>
        )
    } else {
        return (
            <NavbarBodyDiv>
                <NavbarBodyButton valor="profile" description="Profile" />
            </NavbarBodyDiv>
        )
    }

}

export default NavbarBody;