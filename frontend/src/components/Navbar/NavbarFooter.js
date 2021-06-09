import React, {useContext} from 'react';
import {NavbarFooterButton, NavbarFooterDiv} from "./NavBarElements";
import AppContext from "../../context/AppContext";
import {logout} from "../../context/Actions";
import { useHistory } from "react-router-dom";


function NavbarFooter() {

    const { state, dispatch } = useContext(AppContext);
    const { loggedUser } = state;
    const { role } = loggedUser;
    const history = useHistory();

    function logoutRedirect() {
        let path = `/login`;
        history.push(path);
    }

    function handleClick() {
        dispatch(logout())
        logoutRedirect();
    }

    return (
        <NavbarFooterDiv>
            <NavbarFooterButton onClick={() => alert("apes together strong \nGrupo 3")}>About</NavbarFooterButton>
                <br />
            <NavbarFooterButton onClick={() => alert("we contact you")}>Contact Us</NavbarFooterButton>
                <br />
            <NavbarFooterButton onClick={handleClick}>Logout</NavbarFooterButton>
        </NavbarFooterDiv>
    )
}

export default NavbarFooter;