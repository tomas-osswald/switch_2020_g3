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

    mainView: 'profile',

    loggedUser: {
        id: 'tonyze@latinlover.com',
        sm: false,
        fa: true,
    },

    name: {
        loading: true,
        error: null,
        data: [],
    },

    loggeduser: 'kvanessa@latina.com',

    family: {
        loading: true,
        error: null,
        members: [{
            email: [],
            name: [],
            relations: [{
                loading: true,
                error: null,
                description: [],
                emailB: [],
            }],
        }],
    },

    familymembers: {
        loading: true,
        error: null,
        data: [],
        relations: [{
            userid: 0,
            loading: true,
            error: null,
            data: [],
        }],
    },
    profile: {
        loading: true,
        error: null,
        data: [],
    }
};

// -> Insert more data objects in a different way
// ex:
const headers = {

    id: "ID",
    name: "Name",
    username: "User Name",
    email: "Email",


};

const labels = {

    one: "1",
    two: "2",
    three: "3",

}

const AppProvider = (props) =>{
    const [state, dispatch] = useReducer(reducer, initialState);
    return (
        <Provider value={{
            state,
            headers,
            labels,
            dispatch}}>
            {props.children}
        </Provider>
    );
};
AppProvider.propTypes = {
    children: PropTypes.node,
};


export default AppProvider;