import React, {useContext} from 'react';
import {NavbarFooterButton, NavbarFooterDiv} from "./NavBarElements";
import AppContext from "../../context/AppContext";
import {logout} from "../../context/Actions";


function NavbarFooter() {

    const { dispatch } = useContext(AppContext);

    function handleClick() {
        dispatch(logout())
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