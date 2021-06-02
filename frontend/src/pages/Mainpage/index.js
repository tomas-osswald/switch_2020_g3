import React from 'react';

import Navbar from "../../components/Navbar";
import Mainview from "../../components/Mainview";
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