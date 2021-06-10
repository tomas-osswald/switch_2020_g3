import React, {useContext, useEffect, useState} from 'react';
import AppContext from "../../context/AppContext";
import '../../styles/global.css';
import '../../styles/memberRelations.css';
import {changeRefresh, changeView, fetchFamilyRelationsFA, postNewRelation} from "../../context/Actions";
import {Button, Table} from 'react-bootstrap';
import {
    ButtonCell,
    HeaderCell,
    HeaderSection,
    MembersRelationsFADiv,
    RelationsList
} from "./MembersRelationsFAElements";


function MembersRelationsFA() {

    const {state, dispatch} = useContext(AppContext);
    let {family, familyData, refresh} = state;
    const {familyName} = familyData;
    const {loading, error, data} = family
    const {familyMemberAndRelationsDTO} = data
    const {landingPage} = state;
    const [display, setDisplay] = useState(false)
    const {family_id} = landingPage;

    /*const [refreshVariable, setrefreshVariable] = useState(false);

    useEffect(() => {

        fetchFamilyRelationsFA(dispatch, family_id);
        setrefreshVariable(false);
    }, [refreshVariable]);*/


    useEffect(() => {

        fetchFamilyRelationsFA(dispatch, family_id)


    }, [])

    useEffect(() => {

        fetchFamilyRelationsFA(dispatch, family_id);
        dispatch(changeRefresh(false));
    }, [refresh])


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
                    <tr key={relationsIndex}> {relationsRow.relationDesignation} of {findMemberTwoName(relationsRow.memberTwoID)}  </tr>
                )
            })
            return (
                <tr key={index}>Name: {row.name} Email: {row.personID} <p>Relações : {relassoes}</p></tr>
            )
        })
        return (
            <div>
                <table>{html}</table>
                <br/>
            </div>
        )
    }

    function displayChange() {
        setDisplay(!display)
    }

    function addMemberRedirect(value) {
        //let path = `/addMember`;
        //history.push(path);
        //dispatch(addMemberView)
        dispatch(changeView(value))
    }

    //ReactDOM.render(<Table columns={columns} dataSource={dataTable} onChange={onChange} />, mountNode);

    function displayRole(index) {
        let tableRole = '';
        if (index === 0) {
            tableRole = 'Family Administrator';
        } else {
            tableRole = 'Family Member';
        }
        return tableRole;
    }

    function buildTable() {
        const dto = familyMemberAndRelationsDTO.map((row, index) => {
            const relations = row.relations.map((relationsRow, relationsIndex) => {
                return (
                    <div className="relation-row" key={relationsIndex}>
                        <td className="relation-row-1">{relationsRow.relationDesignation} of {findMemberTwoName(relationsRow.memberTwoID)}</td>
                        <td></td>
                    </div>
                )
            })
            return (
                <tr className="table-row font-class" style={{padding: "30px"}} key={index}>
                    <td className="table-row-element-1">{row.name}</td>
                    <td className="table-row-element-2">{displayRole(index)}</td>
                    <td className="relationList"><RelationsList props={display}>{relations}</RelationsList></td>
                </tr>
            )
        })
        return (<div>{dto}</div>)
    }


    function populateSelection() {
        let html = familyMemberAndRelationsDTO.map((row, index) => {
            return (
                <option key={index} value={row.personID}>{row.name}</option>
            )
        })
        return html;
    }

    const [memberA, setMemberA] = useState('');
    const [memberB, setMemberB] = useState('');
    const [relationDesignation, setRelationDesignation] = useState('');

    function handleSubmit() {
        const newRelationDTO = {
            memberOneID: memberA,
            memberTwoID: memberB,
            relationDesignation: relationDesignation
        }

        postNewRelation(dispatch, newRelationDTO, family_id);
        //setrefreshVariable(true);
        window.alert("Relation successfully created!");
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
                <MembersRelationsFADiv>
                    <div className="relation-add-table">
                        <Table>
                            <tr className="table-header font-class">
                                <th className="table-header-element-1">NAME</th>
                                <th className="table-header-element-2">ROLE</th>
                            </tr>
                            {buildTable()}
                        </Table>
                    </div>
                    <div className="table-interaction font-class">
                        <Button className="check-relations button-two" variant="dark" onClick={displayChange}>Check Relations</Button>
                        <Button className="add-member button-two" variant="dark" onClick={() => addMemberRedirect('addMember')}>Add Member</Button>
                    </div>
                    <div className="relation-select-container font-class">
                        <label className="relation-label-header" htmlFor="memberA">Create Relation</label>
                        <div>
                            <select className="select-option button-two" name="memberA" id="memberA" onChange={memberA => setMemberA(memberA.target.value)}>
                                <option className="select-option">Select Member A</option>
                                {populateSelection()}
                            </select>
                        </div>
                        <div>
                            <label className="relation-label-text" htmlFor="relDesignation">Relation Designation</label>
                            <input className="relation-input" type="text" id="relDesignation" name="relDesignation" onChange={relationDesignation => setRelationDesignation(relationDesignation.target.value)}></input>
                        </div>
                        <div>
                            <select className="button-two" name="memberB" id="memberB" onChange={memberB => setMemberB(memberB.target.value)}>
                                <option className="select-option">Select Member B</option>
                                {populateSelection()}
                            </select>
                            <Button className="add-relation button-two" onClick={handleSubmit} variant="dark">Add Relation</Button>
                        </div>
                    </div>

                </MembersRelationsFADiv>
            )
        }
    }
}


export default MembersRelationsFA;