import React, {useContext, useState} from 'react'
import {LoginDiv} from "./LoginElements";
import AppContext from "../../context/AppContext";
import {changeUser} from "../../context/Actions";
import logo from "../../logo.svg";
import {useHistory} from "react-router-dom";
// import '../../index.css'
import '../../styles/login.css'
import apes from '../../assets/atr-small.png'


const Login = () => {

    const {state, dispatch} = useContext(AppContext);
    const [email, setEmail] = useState('');
    const [loginRole, setRole] = useState('');
    const {loggedUser} = state;
    const {role} = loggedUser;
    const history = useHistory();

    if (role !== '') {
        let path = `/`;
        history.push(path);
    }

    function handleClick(email, loginRole) {
        dispatch(changeUser(email, loginRole))
    }

    return (

        <LoginDiv className="login">
            <div className="row">
                <div className="column-left">
                    <img style={{width: 150, height: 150}} src={logo} className="App-logo" alt="logo" loading="eager"/>
                </div>
                <div className="column-right">
                    <img src={apes} alt="apes" loading="eager" id="apes-img"/>
                </div>
            </div>


            <div>
                <label form="email">Email </label>
                <input type="text" id="email" name="email" onChange={(e) => setEmail(e.target.value)}/>


                <label htmlFor="password">Password </label>
                <input type="password" id="password" name="password"/>

                <p className="login-profile-title">Choose login profile :</p>
                <div className="radio-group">
                    <div className="col-one">
                        <input type="radio" id="option-one" name="role" value="sm" onClick={() => setRole('systemManager')}/>
                        <label className="lbl-role" htmlFor="option-one">System Manager</label>
                    </div>
                    <div className="col-two">
                        <input type="radio" id="option-two" name="role" value="fa" onClick={() => setRole('familyAdministrator')}/>
                        <label className="lbl-role" htmlFor="option-two">Family Administrator</label>
                    </div>
                    <div className="col-three">
                        <input type="radio" id="option-three" name="role" value="fm" onClick={() => setRole('familyMember')}/>
                        <label className="lbl-role" htmlFor="option-three"> Family Member </label>
                    </div>


           {/* <input type="radio" id="option-one" name="role" value="sm" onClick={() => setRole('systemManager')}/>
            <label htmlFor="option-one">System Manager</label>
            <input type="radio" id="option-two" name="role" value="fa" onClick={() => setRole('familyAdministrator')}/>
            <label htmlFor="option-two">Family Administrator</label>
            <input type="radio" id="option-three" name="role" value="fm" onClick={() => setRole('familyMember')}/>
            <label htmlFor="option-three">Family Member</label>*/}

        </div>

                <div className="row-button">
                    <button className="login-button" onClick={() => handleClick(email, loginRole)} id="login-button" to={'/'}>Login</button>
                </div>

                {/*<div className="row-selector">


                        <div className="col-one">
                            <div>
                            <button id="systemManager" name="role" value="sm" onClick={() => setRole('systemManager')}>System Manager</button>

                            </div>
                        </div>
                        <div className="col-two">

                            <button id="familyAdministrator" name="role" value="fa" onClick={() => setRole('familyAdministrator')}>Family Administrator</button>
                        </div>
                        <div className="col-three">

                            <button id="familyMember" name="role" value="fm" onClick={() => setRole('familyMember')}>FamilyMember</button>
                        </div>

                        <div className="row-button">
                            <button className="login-button" onClick={() => handleClick(email, loginRole)} id="login-button" to={'/'}>Login</button>
                        </div>
                    </div>*/}

            </div>


        </LoginDiv>



    )
}

export default Login;