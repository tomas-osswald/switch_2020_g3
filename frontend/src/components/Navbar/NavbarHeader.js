import React from 'react';
import logo from '../../logo.svg';
import {ImageProperties, NavbarHeaderDiv} from "./NavBarElements";


function NavbarHeader() {

    return(
        <NavbarHeaderDiv>
            <ImageProperties style={{width:150, height:150}} src={logo} className="App-logo" alt="logo" />
        </NavbarHeaderDiv>
    )
}

export default NavbarHeader;