import React, {useContext, useEffect} from 'react';
import AppContext from "../../context/AppContext";
import {fetchFamilyRelationsFA, fetchProfile} from "../../context/Actions";
import Loading from "../Loading";


function MembersRelationsFA() {

    const {state, dispatch} = useContext(AppContext);
    const {loggedUser, loggeduserTest, family, profile, landingPage} = state;
    //const {familyId} = loggeduserTest;
    const {id} = loggedUser;
    //const {familyID} = state.profile.data;
    const {loading, error, data} = family;
    const {familyMemberAndRelationsDTO} = data;

    const {data: profileData} = profile
    //const {familyId} = profileData;

    const {family_id} = landingPage;

    useEffect(() => {
        //fetchProfile(dispatch, id);

        fetchFamilyRelationsFA(dispatch, family_id);
    }, [])

    function findMemberTwoName(TwoID) {
        return familyMemberAndRelationsDTO.map((personDTO) => {
            if (TwoID === personDTO.personID) {
                return personDTO.name
            }
        })

    }

    function buildInnerText() {
        let html = familyMemberAndRelationsDTO.map((row, index) => {
            let relassoes = row.relations.map((relationsRow, relationsIndex) => {
                return (
                    <tr key={relationsIndex}> {relationsRow.relationDesignation} of {findMemberTwoName(relationsRow.memberTwoID)}  </tr>)
            })
            return (<tr key={index}>Name: {row.name} Email: {row.personID} <p>Relações : {relassoes}</p></tr>)
        })

        return <table>{html}</table>

    }


    if (loading === true) {
        return (
            <div>
                Loading...
            </div>
        )
    } else {
        if (error !== null) {
            return (
                <div>
                    Error...
                </div>
            )
        } else {
            return (
                <div>

                    <p>{buildInnerText()}</p>


                </div>
            )
        }
    }
}

export default MembersRelationsFA;