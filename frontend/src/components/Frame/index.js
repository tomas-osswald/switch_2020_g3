import React from 'react';
import Navbar from "../Navbar";
import Mainview from "../Mainview";
import {FrameDiv} from "./FrameElements";


function Frame() {

    return (
        <>
            <FrameDiv>
                <Navbar />
                <Mainview/>
            </FrameDiv>
        </>
    )
}

export default Frame;