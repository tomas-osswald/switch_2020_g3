import {
    createFamilySMService,
    familyNameGlobal,
    familyRelationsFA,
    fetchNameWS,
    fetchProfileFromLogin,
    fetchProfileFromWS,
    postNewMember
} from './Service'
import {func} from "prop-types";

/**
 * Insert functions for Service:
 * - Success function
 * - Error function
 *
 * Both functions should have as ARG the dispatcher
 */


export const FETCH_PROFILE_STARTED = 'FETCH_PROFILE_STARTED';
export const FETCH_PROFILE_SUCCESS = 'FETCH_PROFILE_SUCCESS';
export const FETCH_PROFILE_FAILURE = 'FETCH_PROFILE_FAILURE';
export const DO_NOTHING = 'DO_NOTHING';
export const UPDATE_NAME = 'UPDATE_NAME';
export const CHANGE_USER = 'CHANGE_USER';
export const LOGOUT = 'LOGOUT';
export const CHANGE_VIEW = 'CHANGE_VIEW';
export const FETCH_FAMILYRELATIONS_STARTED = 'FETCH_FAMILYRELATIONS_STARTED';
export const FETCH_FAMILYRELATIONS_SUCCESS = 'FETCH_FAMILYRELATIONS_SUCCESS';
export const FETCH_FAMILYRELATIONS_FAILURE = 'FETCH_FAMILYRELATIONS_FAILURE';
export const FETCH_USER_NAME_START = "FETCH_USER_NAME_START";
export const FETCH_USER_NAME_SUCCESS = "FETCH_USER_NAME_SUCCESS";
export const FETCH_USER_NAME_FAILURE = "FETCH_USER_NAME_FAILURE";
export const CREATE_FAMILY_STARTED = "FETCH_USER_NAME_FAILURE";
export const CREATE_FAMILY_SUCCESS = "CREATE_FAMILY_SUCCESS";
export const CREATE_FAMILY_FAILURE = "CREATE_FAMILY_FAILURE";
export const ADD_EMAIL = 'ADD_EMAIL';

export function doNothing() {
    return {
        type: DO_NOTHING,
        payload: {}
    }
}

export function updateName(variable) {
    return {
        type: UPDATE_NAME,
        payload: {
            data: variable
        }
    }
}

export function logout(dispatch) {
    return {
        type: LOGOUT,
    }
}

export function changeView(value) {
    return {
        type: CHANGE_VIEW,
        payload: {
            mainView: value
        }
    }
}

export function fetchProfile(dispatch, id) {
    dispatch(fetchProfileStarted());
    fetchProfileFromLogin((res) => dispatch(fetchProfileSuccess(res)), (err) => dispatch(fetchProfileFailure(err.message)), id);
}

export function fetchNewProfile(dispatch, id) {
    dispatch(fetchProfileStarted());
    fetchProfileFromWS((res) => dispatch(fetchProfileSuccess(res)), (err) => dispatch(fetchProfileFailure(err.message)), id);
}

// Uniformizar actions com pedidos fetch para poder utilizar com families, person etc...

export function fetchProfileStarted() {
    return {
        type: FETCH_PROFILE_STARTED,
    }
}

export function fetchProfileSuccess(profile) {
    return {
        type: FETCH_PROFILE_SUCCESS,
        payload: {
            data: profile
        }
    }
}

export function fetchProfileFailure(message) {
    return {
        type: FETCH_PROFILE_FAILURE,
        payload: {
            error: message
        }
    }
}



export const FETCH_FAMILY_NAME_STARTED = 'FETCH_FAMILY_NAME_STARTED';
export const FETCH_FAMILY_NAME_SUCCESS = 'FETCH_FAMILY_NAME_SUCCESS';
export const FETCH_FAMILY_NAME_FAILURE = 'FETCH_FAMILY_NAME_FAILURE';

export function fetchFamilyName(dispatch, familyId) {
    dispatch(fetchFamilyNameStarted());
    familyNameGlobal((res) => dispatch(fetchFamilyNameSuccess(res)), (err) => dispatch(fetchFamilyNameFailure(err.message)), familyId)
}

export function fetchFamilyRelationsFA(dispatch, familyId) {
    dispatch(fetchFamilyRelationStarted());
    familyRelationsFA((res) => dispatch(fetchFamilyRelationsSuccess(res)), (err) => dispatch(fetchFamilyRelationsFailure(err.message)), familyId)
}

/***** FAMILY *******/

export function fetchFamilyRelationStarted() {
    return {
        type: FETCH_FAMILYRELATIONS_STARTED
    }
}

export function fetchFamilyNameStarted() {
    return {
        type: FETCH_FAMILY_NAME_STARTED
    }
}

export function fetchFamilyNameSuccess(familyRelations) {
    return {
        type: FETCH_FAMILYRELATIONS_SUCCESS,
        payload: {
            data: familyRelations
        }
    }
}


export function fetchFamilyRelationsSuccess(relations) {
    return {
        type: FETCH_FAMILYRELATIONS_SUCCESS,
        payload: {
            data: relations
        }
    }
}

export function fetchFamilyRelationsFailure(message) {
    return {
        type: FETCH_FAMILYRELATIONS_FAILURE,
        payload: {
            data: message
        }
    }
}

export function fetchFamilyNameFailure(message) {
    return {
        type: FETCH_FAMILY_NAME_FAILURE,
        payload: {
            data: message
        }
    }
}

export function changeUser(email, role) {
    return {
        type: CHANGE_USER,
        payload: {
            id: email,
            role: role,
        },
    }
}

export function createFamilySM(dispatch, createFamily) {
    dispatch(createFamilySMStarted());
    createFamilySMService((res) => dispatch(createFamilySMSuccess(res)), (err) => dispatch(createFamilySMFailure(err.message)), createFamily);

}

export function createFamilySMStarted() {
    return {
        type: CREATE_FAMILY_STARTED
    }
}

export function createFamilySMSuccess(family) {
    return {
        type: CREATE_FAMILY_SUCCESS,
        payload: {
            familyName: family.familyName,
            familyID: family.familyID,
            adminID: family.adminID,
            registrationDate: family.registrationDate
        }
    }
}

export function createFamilySMFailure(errorMessage) {
    return {
        type: CREATE_FAMILY_FAILURE,
        payload: errorMessage
    }
}


/**
 * LandingPage
 */



export function fetchName(dispatch, id) {
    dispatch(fetchNameStart())
    fetchNameWS((res) => dispatch(fetchNameSuccess(res)), (err) => dispatch(fetchNameFailure(err)), id)
}


export function fetchNameStart() {
    return {
        type: FETCH_USER_NAME_START,
    }
}

export function fetchNameSuccess(wsData) {
    return {
        type: FETCH_USER_NAME_SUCCESS,
        payload: {
            name: wsData.data.name,
            family_id: wsData.data.familyID
        }

    }
}

export function fetchNameFailure(error) {
    return {
        type: FETCH_USER_NAME_FAILURE,
        payload: error
    }
}

export function addEmail(emailToAdd) {
    return {
        type: ADD_EMAIL,
        payload: emailToAdd
    }
}

export const ADD_NEW_MEMBER_START = 'ADD_NEW_MEMBER_START'
export const ADD_NEW_MEMBER_SUCCESS = 'ADD_NEW_MEMBER_SUCCESS';
export const ADD_NEW_MEMBER_FAILURE = 'ADD_NEW_MEMBER_FAILURE';

export function addNewMember(dispatch, newMember){
    dispatch(addNewMemberStart())
    postNewMember((response) => addNewMemberSuccess(response), (err) => addNewMemberFailure(err), newMember)

}

export function addNewMemberStart(){
    return {
        type: ADD_NEW_MEMBER_START,
    }
}

export function addNewMemberSuccess(newMember){
    return {
        type: ADD_NEW_MEMBER_SUCCESS,
        payload: {
            adminID: newMember.adminID,
            emailID: newMember.emailID,
            name: newMember.name,
            birthDate: newMember.birthDate,
            vatNumber: newMember.vatNumber,
            phone: newMember.phone,
            street: newMember.street,
            city: newMember.city,
            houseNumber: newMember.houseNumber,
            zipCode: newMember.zipCode,
        }
    }
}

export function addNewMemberFailure(error){
    return {
        type: ADD_NEW_MEMBER_FAILURE,
        payload: error
    }
}


