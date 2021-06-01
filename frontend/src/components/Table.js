import React, { useContext, useEffect } from 'react';
import AppContext from '../context/AppContext';
import { fetchNewProfile, changeUser } from '../context/Actions';

//export let personID = 'tonyze@latinlover.com';

function Table() {
    const { state, dispatch} = useContext(AppContext);
    const {profile} = state;
    const {loggeduser} = state;
    const { loading, error, data } = profile;
//    const personID = 'tonyze@latinlover.com';

    useEffect(() =>{
        /*
        dispatch(fetchUsersStarted());
        fetch(`${URL_API}/users`)
        .then(res =>  res.json())
        .then(res => dispatch(fetchUsersSuccess(res)))
        .catch(err => dispatch(fetchUsersFailure(err.message)))
        ;
        */
        fetchNewProfile(dispatch,loggeduser);
    });

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
                        <button onClick={()=>alert('valor and honour'+ document.getElementById('personID').value)}>Press me please!</button>
                        <input id='personID' type='submit' value='tonyze@latinlover.com'></input>
                        <h1>{data.name}</h1>
                        <p>{data.id}</p>
                        <h2><a href="http://vs116.dei.isep.ipp.pt:8080/categories">base de dados</a></h2>
                        <p>{data.birthdate}</p>
                        <h3>hamburger</h3>
                    </div>
                );
            //} else {
            //    return (<h1>No data ....</h1>);
            //}
        }
    }
}

//()=>alert('valor and honour'+ document.getElementById('personID').value)
//{()=>changeUser(dispatch,document.getElementById('personID').value)}

export default Table;