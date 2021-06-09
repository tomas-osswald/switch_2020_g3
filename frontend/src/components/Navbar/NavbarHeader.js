import React, {useContext} from 'react';
import logo from '../../logo.svg';
import {ImageProperties, NavbarHeaderDiv} from "./NavBarElements";
import AppContext from "../../context/AppContext";
import {changeView} from "../../context/Actions";


function NavbarHeader() {

    const { dispatch } = useContext(AppContext);

    function handleClick(value) {
        dispatch(changeView(value))
    }

    return(
        <NavbarHeaderDiv onClick={() => handleClick('')} >
            <ImageProperties style={{width:150, height:150}} src={logo} className="App-logo" alt="logo" />
        </NavbarHeaderDiv>
    )
}

export default NavbarHeader;