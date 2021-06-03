import React, {useContext} from 'react';
import {MainviewDiv} from "./MainviewElements";
import MembersRelationsFA from "../MembersRelationsFA";
import AppContext from "../../context/AppContext";
import LandingPage from "../LandingPage";


function Mainview() {
    const {state, dispatch} = useContext(AppContext);
    const {name, mainView} = state;
    const {data} = name;

    if (mainView === 'profile') {
        return (
            <MainviewDiv>
                Mainview deste lado
                <br/>
                Profile aqui
            </MainviewDiv>
        )
    } else if (mainView === 'createFamily') {
        return (
            <MainviewDiv>
                Mainview deste lado
                <br/>
                Create Family aqui
            </MainviewDiv>
        )
    } else if (mainView === 'family') {
        return (
            <MainviewDiv>
                Mainview deste lado
                <br/>
                Family aqui
                <MembersRelationsFA/>
            </MainviewDiv>
        )
    }

    return (
        <MainviewDiv>
            <LandingPage/>
        </MainviewDiv>
    )

}

export default Mainview