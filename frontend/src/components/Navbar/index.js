import React, {useContext, useState} from 'react';
import {NavbarDiv} from "./NavBarElements";
import NavbarHeader from "./NavbarHeader";
import NavbarBody from "./NavbarBody";
import NavbarFooter from "./NavbarFooter";
import AppContext from "../../context/AppContext";

function Navbar(){

    const { state, dispatch } = useContext(AppContext);
    const { loggedUser } = state;
    const { role } = loggedUser;

    //let color;
    //color: '#52ec85';
    //color: '#61dafb';
    //color: '#b787f1';

    const theme = {
        sm: "#c6a974",
        admin: "#52ec85",
        member: "#cacaca",
    }

    switch (role) {
        case 'systemManager':

            return (
                <NavbarDiv theme={theme.sm} >
                    <NavbarHeader />
                    <NavbarBody />
                    <NavbarFooter />
                </NavbarDiv>
            )
        case 'familyAdministrator':
            return (
                <NavbarDiv theme={theme.admin}>
                    <NavbarHeader />
                    <NavbarBody />
                    <NavbarFooter />
                </NavbarDiv>
            )
        case 'familyMember':
            return (
                <NavbarDiv theme={theme.member}>
                    <NavbarHeader />
                    <NavbarBody />
                    <NavbarFooter />
                </NavbarDiv>
            )
    }
}

export default Navbar;