import React, {useContext} from 'react';
import {NavbarBodyButtonStyle, NavbarBodyDiv} from "./NavBarElements";
import '../../styles/navbarBody.css'
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
                    <link rel="stylesheet"
                          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
                          integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
                          crossOrigin="anonymous" referrerPolicy="no-referrer"/>
                    <h3><i className="fas fa-user userIcon"></i>{role}</h3>
                    <NavbarBodyButton className="systemManager-1" valor="createFamily" description="Create a Family"/>
                </NavbarBodyDiv>
            )
        case 'familyAdministrator':
            return (
                <NavbarBodyDiv>
                    <NavbarBodyButton className="familyAdmin-1" valor="family" description="Family"/>
                    <NavbarBodyButton className="familyAdmin-2" valor="profile" description="Profile"/>
                </NavbarBodyDiv>
            )
        case 'familyMember':
            return (
                <NavbarBodyDiv>
                    <NavbarBodyButton className="familyMember-1" valor="profile" description="Profile"/>
                </NavbarBodyDiv>
            )
        default:
            return (<Redirect to="/login"/>)
    }

}

export default NavbarBody;