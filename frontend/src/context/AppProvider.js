import React, {useReducer} from 'react';
// prop-types is an installed dependency
import PropTypes from "prop-types";
import {Provider} from './AppContext';
import reducer from './Reducer';

const initialState = {
    /*
    -> Insert data objects
    ex:
    users: {
        loading: true,
        error: null,
        data: [],
    },

     */

    mainView: '',

    loggedUser: {
        id: 'tonyze@latinlover.com',
        sm: true,
        fa: true,
    },

    name: {
        loading: true,
        error: null,
        data: [],
    },

    loggeduser: 'tonyze@latinlover.com',

    loggeduserTest: {
        email: ['tonyze@latinlover.com'],
        familyId: ['@tonyze@latinlover.com'],
    },


    family: {
        loading: true,
        error: null,
        data: {
            familyMemberAndRelationsDTO: [{
                name: "",
                personID: "",
                relations: [{
                    memberOneID: "",
                    memberTwoID: "",
                    relationDesignation: "",
                }]
            }],
        },
    },


    familymembers: {
        loading: true,
        error: null,
        data: [],
        relations: [{
            userid: 0,
            data: [],
        }],
    },

    profile: {
        loading: true,
        error: null,
        data: [],
    },

    createfamily: {
        loading: true,
        error: null,
        data: [
            {
                emailID: '',
                name: '',
                birthdate: '',
                vatNumber: '',
                phone: '',
                street: '',
                city: '',
                houseNumber: '',
                zipCode: '',
                familyName: '',
                registrationDate: ''
            }
        ]
    }
};


// -> Insert more data objects in a different way
// ex:
const headers = {

    id: "ID",
    name: "Name",
    username: "User Name",
    vat: "VAT",
    birthdate: "Birthdate",
    city: "City",

};
/*
const labels = {

    one: "1",
    two: "2",
    three: "3",

}*/

const AppProvider = (props) => {
    const [state, dispatch] = useReducer(reducer, initialState);
    return (
        <Provider value={{
            state,
            headers,
            dispatch
        }}>
            {props.children}
        </Provider>
    );
};
AppProvider.propTypes = {
    children: PropTypes.node,
};


export default AppProvider;