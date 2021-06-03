import React, {useContext} from 'react';
import {CreateFamilyDiv} from "./CreateFamilyElements";
import AppContext from "../../context/AppContext";


export default function CreateFamilySM() {
        const {state, dispatch} = useContext(AppContext);
        const {createfamily} = state;
        const {loading, error, data} = createfamily;
       // const {emailID, name, birthdate, vatNumber, phone, street,
        //        city, houseNumber, zipCode, familyName, registrationDate} = data;
}

/*
function handleSubmit(variable) {
        variable.preventDefault();
        dispatch({type: Actions.CREATE_FAMILY, payload: emailID : emailID})
        const [emailID, setEmailID] = dispatch;
} */

function Index() {
        let emailID;
        return (
        <form onSubmit={handleSubmit}>
            <input type="text" value={emailID}/>
            <input type="text" value={name}/>
            <input type="text" value={birthdate}/>
            <input type="text" value={}/>
            <input type="text" value={}/>
            <input type="text" value={}/>
            <input type="text" value={}/>
            <input type="text" value={}/>
            <input type="text" value={}/>
            <input type="text" value={}/>
            <input type="text" value={}/>
            <input type="text" value={}/>
            <input type="text" value={}/>




        </form>
    );
}

export default Index;