import React, {useContext, useEffect} from 'react'
import {LandingPageDiv, MainText, UserName} from "./LandingPageElements";
import '../../styles/global.css';
import '../../styles/landingPage.css';
import AppContext from "../../context/AppContext";
import {fetchName, loadingLandigPageFalse} from "../../context/Actions";
import Loading from "../Loading";

function LandingPage() {

    const {state, dispatch} = useContext(AppContext);
    const {landingPage} = state;
    const {loggedUser} = state;
    const {loading, name} = landingPage;

    useEffect(() => {
        if (name === '' && loggedUser.role !== 'systemManager') {
            fetchName(dispatch, loggedUser.id)
        } else {
            dispatch(loadingLandigPageFalse())
        }

    }, [])

    if (loading === true) {
        return (
            <Loading/>
        )
    }

    return (
        <>
            <LandingPageDiv  className="userName">
                <MainText className="header font-class">
                    Welcome
                </MainText>
                <UserName className="userName font-class">
                    {name}
                </UserName>
            </LandingPageDiv>
        </>
    )
}

export default LandingPage