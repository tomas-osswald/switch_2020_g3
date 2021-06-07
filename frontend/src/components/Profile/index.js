import React, {useContext, useEffect, useState} from 'react';
import AppContext from '../../context/AppContext';
import {addEmailToFamilyMember, fetchProfile} from "../../context/Actions";
import '../../styles/profile.css'

function Profile() {
    const {state, dispatch} = useContext(AppContext);
    const {loggedUser, profile} = state;
    const {id} = loggedUser;
    const {loading, error, profileData} = profile;
    //const {emails} = profileData;
    const [showInput, setShowInput] = useState(false);

    useEffect(() => {
        fetchProfile(dispatch, id);
    }, []);

    /*function handleInput() {
       addEmailToFamilyMember(dispatch, id)
    }

    //-----------------------------------------------

    const addEmailToList = event => {
        event.preventDefault();
    }

    let newEmail = {
        email: this.state.email
    }

    this.setState(
        {email: [...this.state.profileData.emails, ]}
    )*/



    //--------------------------------------

    function getInputEmail(){
        // Selecting the input element and get its value
        let inputVal = document.getElementById("myInput").value;

        // Displaying the value
        console.log(inputVal);
    }

    const handleOnClick = (id) => {
        addEmailToFamilyMember(dispatch,id)
        }

       function addEmail (event) {
        event.preventDefault();
       }




    //---------------------------

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

                    <p className="title">Family id : {profileData.familyID}</p>

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

                                        <input type="text" placeholder="add email here" id="myInput"/>
                                        <button type="button" onClick={getInputEmail}>Add email</button>

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