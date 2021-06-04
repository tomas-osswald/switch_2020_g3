import React, { useContext, useEffect} from 'react';
import AppContext from '../../context/AppContext';
import {fetchProfile} from "../../context/Actions";
import '../../styles/profile.css'
import { useHistory } from 'react-router-dom';

function Profile() {
    const { state, dispatch} = useContext(AppContext);
    const {loggedUser, profile} = state;
    const {id} = loggedUser;
    const {loading, error, data } = profile;

    useEffect(() =>{
        fetchProfile(dispatch, id);
    },[]);

    if (loading === true) {
        return (
            <h1>Loading ....</h1>

        );
    }
    else {
        if (error !== null) {
            return (
                <div>
                    <h1>Error ....</h1>
                </div>
            );
        }
        else {
            /*  if (data.length > 0) {*/
            return (
                <div className="card">
                    <div>
                        <div>
                            <img src="https://i.pravatar.cc/300" alt="Tony" width="200px"/>

                        </div>
                        <div>

                            <h3 >Name : {data.name}</h3>
                            <h3>Birth date : {data.birthdate}</h3>
                            <ul>

                            </ul>
                            <h3>Emails : {data.emails}</h3>
                            <h3>Phone numbers : {data.phoneNumbers}</h3>
                            <h3>Vat : {data.vat}</h3>
                            <h2>Adress :</h2>
                            <ul>
                                <li>Street :{data.street}</li>
                                <li>City :{data.city}</li>
                                <li>Door number :{data.doorNumber}</li>
                            </ul>


                            <p><button>Go back</button></p>
                        </div>
                    </div>
                </div>
            );
            /*} else {
                return (<h1>No data ....</h1>);
            }*/
        }
    }

}

export default Profile;