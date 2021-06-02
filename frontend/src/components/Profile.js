import React, { useContext, useEffect} from 'react';
import AppContext from '../context/AppContext';
import ProfileBody from "./ProfileBody";

import {fetchProfile} from '../context/Actions';
import '../styles/profile.css'


function Profile() {
    const { state, dispatch} = useContext(AppContext);
    const {profile} = state;
    const { loading, error, data } = profile;

    useEffect(() =>{
        fetchProfile(dispatch);
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
              <div>
                 <ProfileBody/>
              </div>
            );
            /*} else {
                return (<h1>No data ....</h1>);
            }*/
        }
    }

}

export default Profile;