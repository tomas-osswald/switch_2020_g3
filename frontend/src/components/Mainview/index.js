import React, {useContext} from 'react';
import AppContext from "../../context/AppContext";
import {MainviewDiv} from "./MainviewElements";


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
            </MainviewDiv>
        )
    }


}

export default Mainview