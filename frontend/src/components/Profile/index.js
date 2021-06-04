import React, { useContext, useEffect} from 'react';
import AppContext from '../../context/AppContext';
import {fetchProfile} from "../../context/Actions";
import '../../styles/profile.css'
import { useHistory } from 'react-router-dom';

function Profile() {
    const { state, dispatch} = useContext(AppContext);
    const {loggedUser, profile} = state;
    const {id} = loggedUser;
    const {loading, error, profileData } = profile;

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

                            <h3 >Name : {profileData.name}</h3>
                            <h3>Birth date : {profileData.birthdate}</h3>
                            <ul>

                            </ul>
                            <h3>Emails : {profileData.emails}</h3>
                            <h3>Phone numbers : {profileData.phoneNumbers}</h3>
                            <h3>Vat : {profileData.vat}</h3>
                            <h2>Address :</h2>
                            <ul>
                                <li>Street :{profileData.street}</li>
                                <li>City :{profileData.city}</li>
                                <li>Door number :{profileData.doorNumber}</li>
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