import React, {useContext, useEffect} from 'react';
import AppContext from "../../context/AppContext";
import {fetchFamilyRelationsFA} from "../../context/Actions";
import {Table} from 'react-bootstrap';
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
                return (
                    <div>
                        <tr key={relationsIndex}> {relationsRow.memberTwoID} : {relationsRow.relationDesignation} </tr>
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