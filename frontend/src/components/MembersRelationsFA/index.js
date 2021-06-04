import React, {useContext, useEffect} from 'react';
import AppContext from "../../context/AppContext";
import {fetchFamilyRelationsFA, fetchNewProfile} from "../../context/Actions";


function MembersRelationsFA() {

    const {state, dispatch} = useContext(AppContext);
    const {loggedUser, loggeduserTest, family} = state;
    const {familyId} = loggeduserTest;
    const {id} = loggedUser;
    const {profile} = state;
    const {familyID} = profile.data.familyID;
    const {loading, error, data} = family
    const {familyMemberAndRelationsDTO} = data


    useEffect(() => {
        fetchNewProfile(dispatch, id);
        fetchFamilyRelationsFA(dispatch, familyId);
        //fetchFamilyRelationsFA(dispatch, familyID);


    }, [])

    function buildInnerText() {
        let html = familyMemberAndRelationsDTO.map((row, index) => {
            let relassoes = row.relations.map((relationsRow, relationsIndex) => {
                return (<tr key={relationsIndex}> {relationsRow.memberTwoID} : {relationsRow.relationDesignation} </tr>)
            })
            return (<tr key={index}>Name: {row.name} Email: {row.personID} Relações : {relassoes}  </tr>)
        });

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