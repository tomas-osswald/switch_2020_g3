import React from 'react';
import Navbar from "../Navbar";
import Mainview from "../Mainview";
import {MainpageDiv} from "./MainpageElements";


function Mainpage() {

    return (
        <MainpageDiv>
            <Navbar />
            <Mainview/>
        </MainpageDiv>
    )
}

export default Mainpage;