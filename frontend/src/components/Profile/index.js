import React, {useContext, useEffect, useState} from 'react';
import AppContext from '../../context/AppContext';
import {fetchProfile} from "../../context/Actions";
import '../../styles/profile.css'

function Profile() {
    const {state, dispatch} = useContext(AppContext);
    const {loggedUser, profile} = state;
    const {id} = loggedUser;
    const {loading, error, profileData} = profile;
    // const {emails} = profileData;
    const [showInput, setShowInput] = useState(false);
    const onClick = () => setShowInput(true);


    useEffect(() => {
        fetchProfile(dispatch, id);
    }, []);

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
                                    {/*<button className="addbutton" onClick={"Cliked"}>Add email</button>*/}
                                    {/*<input type="text" value={value} onChange={handleChange} />
                                    <button type="button" onClick={handleAdd}>
                                        Add
                                    </button>*/}
                                    <div>
                                        <input type="submit" value="Add email" onClick={onClick}/>
                                        {showInput ? <input type="text"/> : null}
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