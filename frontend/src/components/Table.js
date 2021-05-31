import React, { useContext, useEffect } from 'react';
import AppContext from '../context/AppContext';
import {fetchProfile } from '../context/Actions';
import TableHeader from './TableHeader';

//export let personID = 'tonyze@latinlover.com';

function handleClick(){
    const personID = document.getElementById('personID').value;
}

function Table() {
    const { state, dispatch} = useContext(AppContext);
    const {profile} = state;
    const { loading, error, data } = profile;

    useEffect(() =>{
        /*
        dispatch(fetchUsersStarted());
        fetch(`${URL_API}/users`)
        .then(res =>  res.json())
        .then(res => dispatch(fetchUsersSuccess(res)))
        .catch(err => dispatch(fetchUsersFailure(err.message)))
        ;
        */
        fetchProfile(dispatch);
    },[]);

    if (loading === true) {
        return (<h1>Loading ....</h1>);
    }
    else {
        if (error !== null) {
            return (<h1>Error ....</h1>);
        } else {
            //if (data.length > 0) {
                return (
                    <div>
                        <button onClick={handleClick}>Press me please!</button>
                        <input id='personID'></input>
                        <h1>{data.name}</h1>
                        <p>{data.id}</p>
                        <p>{data.birthdate}</p>
                    </div>
                );
            //} else {
            //    return (<h1>No data ....</h1>);
            //}
        }
    }
}

//()=>alert('valor and honour'+ document.getElementById('personID').value)

export default Table;