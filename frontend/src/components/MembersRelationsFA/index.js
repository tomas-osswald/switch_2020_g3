import React, {useContext, useEffect} from 'react';
import AppContext from "../../context/AppContext";
import {fetchFamilyRelationsFA} from "../../context/Actions";


function MembersRelationsFA() {

    const {state, dispatch} = useContext(AppContext);
    const {family, landingPage} = state;

    const {loading, error, data} = family;
    const {familyMemberAndRelationsDTO} = data;
    const {family_id} = landingPage;

    useEffect(() => {
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