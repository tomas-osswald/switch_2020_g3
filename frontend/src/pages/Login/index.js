import React, {useContext, useEffect, useState} from 'react'
import {LoginDiv} from "./LoginElements";
import AppContext from "../../context/AppContext";
import {changeUser} from "../../context/Actions";
import {ImageProperties} from "../../components/Navbar/NavBarElements";
import logo from "../../logo.svg";
import { useHistory } from "react-router-dom";



const Login = () => {

    const { state, dispatch } = useContext(AppContext);
    const [ email, setEmail ] = useState('');
    const [ loginRole, setRole ] = useState('');
    const { loggedUser } = state;
    const { role } = loggedUser;
    const history = useHistory();

    if(role !== '') {
        let path = `/`;
        history.push(path);
    }

    function handleClick(email, loginRole) {
        dispatch(changeUser(email, loginRole))
    }

    return(
        <LoginDiv>

            <ImageProperties style={{width:150, height:150}} src={logo} className="App-logo" alt="logo" />
            <br />

            <label form="email">Email </label>
            <input type="text" id="email" name="email" onChange={(e) => setEmail(e.target.value)}/>
            <br />
            <label htmlFor="password">Password </label>
            <input type="password" id="password" name="password"/>

            <br />
            <label htmlFor="systemManager">System Manager </label>
            <input type="radio" id="systemManager" name="role" value="sm" onClick={() => setRole('systemManager')} />
            <br />
            <label htmlFor="familyAdministrator">Family Administrator </label>
            <input type="radio" id="familyAdministrator" name="role" value="fa" onClick={() => setRole('familyAdministrator')} />
            <br />
            <label htmlFor="familyMember">Family Member </label>
            <input type="radio" id="familyMember" name="role" value="fm" onClick={() => setRole('familyMember')} />

            <br />
            <button onClick={() => handleClick(email, loginRole)} to={'/'}>Login</button>

        </LoginDiv>
    )
}

export default Login;