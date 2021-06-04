import {createfamilySMService, familyRelationsFA, fetchNameWS, fetchProfileFromWS} from './Service'

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
    //const id = 'tonyze@latinlover.com';
    fetchProfileFromWS((res) => dispatch(fetchProfileSuccess(res)), (err) => dispatch(fetchProfileFailure(err.message)));
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
            data: profile.data
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

export const FETCH_FAMILYRELATIONS_STARTED = 'FETCH_FAMILYRELATIONS_STARTED';
export const FETCH_FAMILYRELATIONS_SUCCESS = 'FETCH_FAMILYRELATIONS_SUCCESS';
export const FETCH_FAMILYRELATIONS_FAILURE = 'FETCH_FAMILYRELATIONS_FAILURE';

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

export function fetchFamilyRelationsSuccess(familyRelations) {
    return {
        type: FETCH_FAMILYRELATIONS_SUCCESS,
        payload: {
            data: familyRelations
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

export function changeUser(email, role) {
    return {
        type: CHANGE_USER,
        payload: {
            id: email,
            role: role,
        },
    }
}

//TODO: Usar como types nas funções abaixo.
export const CREATE_FAMILY_STARTED = 'CREATE_FAMILY_STARTED';
export const CREATE_FAMILY_SUCCESS = 'CREATE_FAMILY_SUCCESS';
export const CREATE_FAMILY_FAILURE = 'CREATE_FAMILY_FAILURE';

export function createFamilySM(dispatch) {
    dispatch(createFamilySMStarted());
    createfamilySMService((res) => dispatch(createFamilySMSuccess(res)), (err) => dispatch(createFamilySMFailure(err.message())));

}

//TODO: Fazer cenas
export function createFamilySMStarted() {
    return doNothing()
}

//TODO: Fazer cenas
export function createFamilySMSuccess() {
    return doNothing()
}

//TODO: Fazer cenas
export function createFamilySMFailure() {
    return doNothing()
}

/**
 * LandingPage
 */

export const FETCH_USER_NAME_START = "FETCH_USER_NAME_START";
export const FETCH_USER_NAME_SUCCESS = "FETCH_USER_NAME_SUCCESS";
export const FETCH_USER_NAME_FAILURE = "FETCH_USER_NAME_FAILURE";

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
        payload: wsData.data.name

    }
}

export function fetchNameFailure(error) {
    return {
        type: FETCH_USER_NAME_FAILURE,
        payload: error
    }
}

