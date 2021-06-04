import React, {useContext, useEffect} from 'react';
import AppContext from "../../context/AppContext";
import {fetchFamilyRelationsFA, fetchProfile} from "../../context/Actions";
import { Table, Button } from 'react-bootstrap';
import {MembersRelationsFADiv, HeaderCell, HeaderSection} from "./MembersRelationsFAElements";


function MembersRelationsFA() {

    const {state, dispatch} = useContext(AppContext);
    const {loggedUser, loggeduserTest, family, profile} = state;
    const {familyId} = loggeduserTest;
    const {id, role} = loggedUser;
    const {profileData} = profile;
    //const {familyID} = profileData;
    const {loading, error, data} = family
    const {familyMemberAndRelationsDTO} = data
    const {family, landingPage} = state;

    const {loading, error, data} = family;
    const {familyMemberAndRelationsDTO} = data;
    const {family_id} = landingPage;

    useEffect(() => {
        // console.log(state.profile)
        fetchProfile(dispatch, id);
        fetchFamilyRelationsFA(dispatch, family_id);
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
                        <tbody>
                        <tr>
                            <td key={index}></td>
                            <br/>
                            <td>{relationsRow.relationDesignation}</td>
                            <br/>
                            <td>{relationsRow.memberTwoID}</td>
                            <br/>
                            <br/>
                        </tr>
                        </tbody>
                    </div>
                )
            })
            return (
                <tr key={index}>
                    <td>{role}</td>
                    <td>{row.name}</td>
                    <td>See relations<Button variant="dark">+</Button></td>
                </tr>
            )
        })
        return (<div>{dto}</div>)
    }

    // Ir buscar o Name da Family
    const familyName = "Sopranos";

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
                <MembersRelationsFADiv>
                    <div>
                        {<p>{buildInnerText()}</p>}
                        <h2>{familyName}</h2>
                        <Table striped bordered hover variant="dark">
                            <thead>
                            <HeaderSection>
                                <HeaderCell>Role</HeaderCell>
                                <HeaderCell>Name</HeaderCell>
                                <HeaderCell>Relations</HeaderCell>
                            </HeaderSection>
                            </thead>
                            <div>{buildTable()}</div>
                        </Table>
                    </div>
                </MembersRelationsFADiv>
            )
        }
    }
}

export default MembersRelationsFA;