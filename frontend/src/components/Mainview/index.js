import React, {useContext} from 'react';
import {MainviewDiv} from "./MainviewElements";
import MembersRelationsFA from "../MembersRelationsFA";
import logo from "../../logo.svg";
import Table from "../Table";
import AppContext from "../../context/AppContext";
import Navbar from "../Navbar";


function Mainview(){
    const { state, dispatch } = useContext(AppContext);
    const { name } = state;
    const { data } = name;

    return(
        <MainviewDiv>
            Mainview deste lado
            <MembersRelationsFA />
        </MainviewDiv>
    )

}

export default Mainview