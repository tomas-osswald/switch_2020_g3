import React, {useContext} from 'react';
import {NavbarBodyButtonStyle, NavbarBodyDiv} from "./NavBarElements";
import AppContext from "../../context/AppContext";
import NavbarBodyButton from "./NavbarBodyButton";
import {FETCH_PROFILE_STARTED} from "../../context/Actions";
import {Redirect} from "react-router-dom";

function NavbarBody() {

    const { state, dispatch } = useContext(AppContext);
    const { loggedUser } = state;
    const { role } = loggedUser;


    switch (role) {
        case 'systemManager':
            return (
                <NavbarBodyDiv>
                    <NavbarBodyButton valor="family" description="Family"/>
                    <br/>
                    <NavbarBodyButton valor="profile" description="Profile"/>
                    <br/>
                    <NavbarBodyButton valor="createFamily" description="Create a Family"/>
                </NavbarBodyDiv>
            )
        case 'familyAdministrator':
            return (
                <NavbarBodyDiv>
                    <NavbarBodyButton valor="family" description="Family"/>
                    <br/>
                    <NavbarBodyButton valor="profile" description="Profile"/>
                </NavbarBodyDiv>
            )
        case 'familyMember':
            return (
                <NavbarBodyDiv>
                    <NavbarBodyButton valor="profile" description="Profile"/>
                </NavbarBodyDiv>
            )
        default:
            return (<Redirect to="/login"/>)
    }

}

export default NavbarBody;