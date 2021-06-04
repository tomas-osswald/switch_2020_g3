import React, {useContext, useEffect} from 'react';
import AppContext from "../../context/AppContext";
import {fetchFamilyRelationsFA} from "../../context/Actions";
import {Table} from 'react-bootstrap';
import {func} from "prop-types";


function MembersRelationsFA() {

    const {state, dispatch} = useContext(AppContext);
    const {loggedUser, loggeduserTest, family} = state;
    const {familyId} = loggeduserTest;
    const {id} = loggedUser;
    //const {familyID} = state.profile.data;
    const {loading, error, data} = family
    const {familyMemberAndRelationsDTO} = data


    useEffect(() => {
        //fetchNewProfile(dispatch, id);
        fetchFamilyRelationsFA(dispatch, familyId);
        //fetchFamilyRelationsFA(dispatch, familyID);
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
                    <div>
                        <tr key={relationsIndex}> {relationsRow.relationDesignation} of {findMemberTwoName(relationsRow.memberTwoID)}  </tr>
                        )
                        <Table striped bordered hover variant="dark">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>Username</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td key={relationsIndex}>1</td>
                                <td>{}</td>
                                <td>{relationsRow.relationDesignation}</td>
                                <td>{relationsRow.memberTwoID}</td>
                            </tr>
                            <tr>
                                <td>2</td>
                                <td>Jacob</td>
                                <td>Thornton</td>
                                <td>@fat</td>
                            </tr>
                            <tr>
                                <td>3</td>
                                <td colSpan="2">Larry the Bird</td>
                                <td>@twitter</td>
                            </tr>
                            </tbody>
                        </Table>
                    </div>
                )
            })
        })
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