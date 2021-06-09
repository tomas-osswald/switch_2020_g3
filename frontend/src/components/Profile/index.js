import React, {useContext, useEffect, useState} from 'react';
import AppContext from '../../context/AppContext';
import {addEmailToFamilyMember, fetchProfile, postNewRelation} from "../../context/Actions";
import '../../styles/profile.css'


function Profile() {
    const {state, dispatch} = useContext(AppContext);
    const {loggedUser, profile} = state;
    const {id} = loggedUser;
    const {loading, error, profileData} = profile;
    // const [emails] = profileData;


    const [email, setemail] = useState("");
    const [refresh, setRefresh] = useState(false);

    useEffect(() => {
        fetchProfile(dispatch, id);
        setRefresh(false);
    }, [refresh]);

    useEffect(() => {
        fetchProfile(dispatch, id);

    }, []);


    function addEmails() {
        addEmailToFamilyMember(dispatch,id,email);
    }

 /*  function handleChange(event) {
        let c = event.target.value;
        setEmail(c);
        setRefresh(true);
    }*/


    function handleSubmit(){
        addEmails();
        setRefresh(true);
    }

    function EmailsList() {
        const emailList = profileData.emails.map(email => <p className="info">{email}</p>)
        return <div>{emailList}</div>

    }

    if (loading === true) {
        return (
            <h1>Loading ....</h1>

        );
    } else {
        if (error !== null) {
            return (
                <div>
                    <h1>Error ....</h1>
                </div>
            );
        } else {
            /*  if (data.length > 0) {*/
            return (

                <div className="card">

                    <h1>{profileData.name}</h1>

                    {/*<p className="title">Family id : {profileData.familyID}</p>*/}

                    <div className="row-divider">

                    </div>

                    <div className="card-body">
                        <div className="row">
                            <div className="column-left">
                                <p className="item">Birth date: </p>
                            </div>
                            <div className="column-right">
                                <p className="info">{profileData.birthdate}</p>
                            </div>
                        </div>

                        <div className="row">
                            <div className="column-left">
                                <p className="item">Emails :</p>
                            </div>
                            <div className="column-right">
                                <div>
                                    {EmailsList()}
                                    <div>
                                        <input type="text" id="email" onChange={email => setemail(email.target.value)}  required/>

                                        <button onClick={handleSubmit}>Add email</button>

                                    </div>

                                </div>
                            </div>
                        </div>

                        <div className="row">
                            <div className="column-left">
                                <p className="item">Phone number :</p>
                            </div>
                            <div className="column-right">
                                <p className="info">{profileData.phoneNumbers}</p>
                            </div>
                        </div>

                        <div className="row">
                            <div className="column-left">
                                <p className="item">VAT :</p>
                            </div>
                            <div className="column-right">
                                <p className="info">{profileData.vat}</p>
                            </div>
                        </div>

                        <div className="row">
                            <p className="address-title">Address </p>
                        </div>

                        <div className="row">
                            <div className="column-left">
                                <p className="item">City :</p>
                            </div>
                            <div className="column-right">
                                <p className="info">{profileData.city}</p>
                            </div>
                        </div>

                        <div className="row">
                            <div className="column-left">
                                <p className="item">Street :</p>
                            </div>
                            <div className="column-right">
                                <p className="info">{profileData.street}</p>
                            </div>
                        </div>

                        <div className="row">
                            <div className="column-left">
                                <p className="item">Door number :</p>
                            </div>
                            <div className="column-right">
                                <p className="info">{profileData.doorNumber}</p>
                            </div>
                        </div>

                        <div className="row">
                            <div className="column-left">
                                <p className="item">Zip code :</p>
                            </div>
                            <div className="column-right">
                                <p className="info">{profileData.zipCode}</p>
                            </div>
                        </div>

                        {/* <div className="row">
                        <p><button onClick={goBack}>Go back</button></p>

                    </div>*/}

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