import React, {useContext, useEffect} from 'react';
import AppContext from "../../context/AppContext";
import {fetchFamilyRelationsFA} from "../../context/Actions";
import {func} from "prop-types";


function MembersRelationsFA() {

    const {state, dispatch} = useContext(AppContext);
    const {loggeduserTest, family} = state;
    const {email, familyId} = loggeduserTest;
    const {loading, error, data} = family
    const {familyMemberAndRelationsDTO}= data




    useEffect(() => {

        fetchFamilyRelationsFA(dispatch, familyId);



    }, [])

    function buildInnerText(){
        let html = familyMemberAndRelationsDTO.map((row,index) => {
            let relassoes = row.relations.map((relationsRow,relationsIndex)=>{
                return (<tr key={relationsIndex}> {relationsRow.memberTwoID} : {relationsRow.relationDesignation} </tr>)
            })
            return (<tr key={index}>Name: {row.name} Email: {row.personID} Relações : {relassoes}  </tr>)});

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