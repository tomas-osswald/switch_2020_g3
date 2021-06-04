import React, {useContext, useEffect} from 'react';
import AppContext from "../../context/AppContext";
import {fetchFamilyRelationsFA, fetchProfile} from "../../context/Actions";
import { Table } from 'react-bootstrap';


function MembersRelationsFA() {

    const {state, dispatch} = useContext(AppContext);
    const {loggedUser, loggeduserTest, family, profile} = state;
    const {familyId} = loggeduserTest;
    const {id} = loggedUser;
    const {profileData} = profile;
    //const {familyID} = profileData;
    const {loading, error, data} = family
    const {familyMemberAndRelationsDTO} = data


    useEffect(() => {
        fetchProfile(dispatch, id);

    }, [])
    useEffect(() => {
        console.log(state.profile)
        fetchFamilyRelationsFA(dispatch, familyId);
        //fetchFamilyRelationsFA(dispatch, state.profile.data.familyID);
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

        return (
            <div>
                <table>{html}</table>
                <br/>
            </div>
        )
    }

    function buildTable() {
        const dto = familyMemberAndRelationsDTO.map((row, index) => {
            const relations = row.relations.map((relationsRow, relationsIndex) => {
                return(
                    <div>
                        <br/>
                        <Table striped bordered hover variant="dark">
                            <tbody>
                            <tr>
                                <td key={index}>{index}</td>
                                <td>{relationsRow.memberOneID}</td>
                                <td>{relationsRow.relationDesignation}</td>
                                <td>{relationsRow.memberTwoID}</td>
                            </tr>
                            </tbody>
                        </Table>
                    </div>
                )
            })
            return (
                <div>
                    <div>{relations}</div>
                </div>
            )
        })
        return (<div>{dto}</div>)
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

                    {<p>{buildInnerText()}</p>}
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Username</th>
                    </tr>
                    </thead>
                    <div>{buildTable()}</div>

                </div>
            )
        }
    }
}

export default MembersRelationsFA;