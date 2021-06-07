import React, {useContext, useEffect} from 'react';
import AppContext from "../../context/AppContext";
import {fetchFamilyName, fetchFamilyRelationsFA} from "../../context/Actions";
import {Button} from 'react-bootstrap';
import {HeaderCell, HeaderSection, MembersRelationsFADiv} from "./MembersRelationsFAElements";

//import { Table } from 'antd';

function MembersRelationsFA() {

    const {state, dispatch} = useContext(AppContext);
    const {loggedUser, loggeduserTest, family, profile, familyData} = state;
    const {familyId} = loggeduserTest;
    //const {id, role} = loggedUser;
    //const {profileData} = profile;
    //const {familyID} = profileData;
    const {familyName} = familyData;
    const {loading, error, data} = family
    const {familyMemberAndRelationsDTO} = data
    const {landingPage} = state;
    const {family_id} = landingPage;

    useEffect(() => {
        // console.log(state.profile)
        //fetchProfile(dispatch, id);

        /*
        Estes fetch não estão a funcionar porque o familyID que entra é nulo, tanto o do profileData
        como o da landingPage. É preciso garantir que o familyID é atulizado no state no momento do
        login
        - fetchFamilyRelationsFA(dispatch, family_id);
        - fetchFamilyRelationsFA(dispatch, state.profile.data.familyID);
         */

        fetchFamilyRelationsFA(dispatch, family_id)
        //fetchFamilyName(dispatch, family_id)

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

    /*
    function buildTableAntd(){

        const dataTable = [
            {
                key: '1',
                name: 'John Brown',
                age: 32,
                address: 'New York No. 1 Lake Park',
            },
            {
                key: '2',
                name: 'Jim Green',
                age: 42,
                address: 'London No. 1 Lake Park',
            },
            {
                key: '3',
                name: 'Joe Black',
                age: 32,
                address: 'Sidney No. 1 Lake Park',
            },
            {
                key: '4',
                name: 'Jim Red',
                age: 32,
                address: 'London No. 2 Lake Park',
            },
        ];

        const columns = [
            {
                title: 'Name',
                dataIndex: 'name',
                filters: [
                    {
                        text: 'Joe',
                        value: 'Joe',
                    },
                    {
                        text: 'Jim',
                        value: 'Jim',
                    },
                    {
                        text: 'Submenu',
                        value: 'Submenu',
                        children: [
                            {
                                text: 'Green',
                                value: 'Green',
                            },
                            {
                                text: 'Black',
                                value: 'Black',
                            },
                        ],
                    },
                ],
                // specify the condition of filtering result
                // here is that finding the name started with `value`
                onFilter: (value, record) => record.name.indexOf(value) === 0,
                sorter: (a, b) => a.name.length - b.name.length,
                sortDirections: ['descend'],
            },
            {
                title: 'Age',
                dataIndex: 'age',
                defaultSortOrder: 'descend',
                sorter: (a, b) => a.age - b.age,
            },
            {
                title: 'Address',
                dataIndex: 'address',
                filters: [
                    {
                        text: 'London',
                        value: 'London',
                    },
                    {
                        text: 'New York',
                        value: 'New York',
                    },
                ],
                onFilter: (value, record) => record.address.indexOf(value) === 0,
            },
        ];

        function onChange(pagination, filters, sorter, extra) {
            console.log('params', pagination, filters, sorter, extra);
        }


        return (
            <Table columns={columns} dataSource={dataTable} onChange={onChange} />
        )
    }

     */

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
                    <td>{displayRole(index)}</td>
                    <td>{row.name}</td>
                    <td>See relations<Button variant="dark">+</Button></td>
                </tr>
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
                <MembersRelationsFADiv>
                    <div>
                        <p>{buildInnerText()}</p>
                        <h2>{familyName}</h2>
                        <thead>
                        <HeaderSection>
                            <HeaderCell>Role</HeaderCell>
                            <HeaderCell>Name</HeaderCell>
                            <HeaderCell>Relations</HeaderCell>
                        </HeaderSection>
                        </thead>
                        <div>{buildTable()}</div>

                        <div>{/*buildTableAntd()*/}</div>
                    </div>
                </MembersRelationsFADiv>
            )
        }
    }
}

export default MembersRelationsFA;