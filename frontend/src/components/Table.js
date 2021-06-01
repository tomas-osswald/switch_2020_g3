import React, { useContext, useEffect, useState } from 'react';
import AppContext from '../context/AppContext';
import {fetchProfile, updateName} from '../context/Actions';


function Table() {
    const { state, dispatch} = useContext(AppContext);
    const {profile, name} = state;
    const [naming , setName ] = useState('');
    const { loading, error } = profile;
    const { data } = name;

    function handleSubmit(){
        //dispatch({ type: UPDATE_NAME, payload: { data: naming } })
        // OU
        dispatch(updateName(naming))
    }

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

    console.log(name);

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
                        <button onClick={handleSubmit}>Press me please!</button>
                        <input value={naming} onChange={(event) => setName(event.target.value)}></input>
                        {/*<h1>{data.name}</h1>
                        <p>{data.id}</p>
                        <p>{data.birthdate}</p>*/}
                        <p></p>
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