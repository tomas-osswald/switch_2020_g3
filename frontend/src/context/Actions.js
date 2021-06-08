import {
    addRelation,
    createFamilySMService,
    familyNameGlobal,
    familyRelationsFA,
    fetchNameWS,
    fetchProfileFromLogin,
    fetchProfileFromWS,
    addInputedEmailToFamilyMember,
    postNewMember
} from './Service'


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
export const LOADING_LANDING_PAGE_FALSE = "LOADING_LANDING_PAGE_FALSE";
export const CREATE_FAMILY_STARTED = "FETCH_USER_NAME_FAILURE";
export const CREATE_FAMILY_SUCCESS = "CREATE_FAMILY_SUCCESS";
export const CREATE_FAMILY_FAILURE = "CREATE_FAMILY_FAILURE";
export const ADD_EMAIL_STARTED = "ADD_EMAIL_STARTED";
export const ADD_EMAIL_SUCCESS = "ADD_EMAIL_SUCCESS";
export const ADD_EMAIL_FAILURE = "ADD_EMAIL_FAILURE";

// export const ADD_EMAIL = 'ADD_EMAIL';

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

export function postNewRelation(dispatch, createRelationDTO, familyID) {
    dispatch(postNewRelationStarted());
    addRelation((res) => dispatch(addRelationSuccess(res)), (err) => dispatch(addRelationFailure(err.message)), createRelationDTO, familyID);
}

export const ADD_RELATION_FAILURE = 'ADD_RELATION_FAILURE';

export function addRelationFailure(message) {
    return {
        type: ADD_RELATION_FAILURE,
        payload: {
            error: message
        }
    }
}

export const ADD_RELATION_SUCCESS = 'ADD_RELATION_SUCCESS';

export function addRelationSuccess(success) {
    return {
        type: ADD_RELATION_SUCCESS,
        payload: {
            data: success
        }
    }
}


export const ADD_RELATION_STARTED = 'ADD_RELATION_STARTED';

export function postNewRelationStarted() {
    return {
        type: ADD_RELATION_STARTED,
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


export function fetchFamilyNameStarted() {
    return {
        type: FETCH_FAMILY_NAME_STARTED
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

export function fetchFamilyNameSuccess(familyRelations) {
    return {
        type: FETCH_FAMILYRELATIONS_SUCCESS,
        payload: {
            data: familyRelations
        }
    }
}

export function fetchFamilyRelationStarted() {
    return {
        type: FETCH_FAMILYRELATIONS_STARTED
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
    fetchNameWS((res) => dispatch(fetchNameSuccess(res)), (err) => dispatch(fetchNameFailure(err.message)), id)
}

export function loadingLandigPageFalse() {
    return {
        type: LOADING_LANDING_PAGE_FALSE,
    }
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

// Add email in Profile ----------------------------------------------------------------

export function addEmailToFamilyMember(dispatch, id) {
    dispatch(addEmailStarted());
    addInputedEmailToFamilyMember((res) => dispatch(addEmailSuccess(res)), (err) => dispatch(addEmailFailure(err.message)), id);

}

export function addEmailStarted() {
    return {
        type: ADD_EMAIL_STARTED,

    }
}

export function addEmailSuccess(profile, email) {
    return {
        type: ADD_EMAIL_SUCCESS,
        payload: {
            email: profile.profileData.emails.push(email)
        }

    }
}

export function addEmailFailure(error) {
    return {
        type: ADD_EMAIL_FAILURE,
        payload: error

    }
}

export const ADD_NEW_MEMBER_START = 'ADD_NEW_MEMBER_START'
export const ADD_NEW_MEMBER_SUCCESS = 'ADD_NEW_MEMBER_SUCCESS';
export const ADD_NEW_MEMBER_FAILURE = 'ADD_NEW_MEMBER_FAILURE';

export function addNewMember(dispatch, newMember) {
    dispatch(addNewMemberStart())
    postNewMember((response) => dispatch(addNewMemberSuccess(response)), (err) => dispatch(addNewMemberFailure(err.message)), newMember)

}

export function addNewMemberStart() {
    return {
        type: ADD_NEW_MEMBER_START,
    }
}

export function addNewMemberSuccess(newMember){
    console.log(newMember)
    return {
        type: ADD_NEW_MEMBER_SUCCESS,
        payload: {
            emailID: newMember.data.id,
            name: newMember.data.name,
            birthDate: newMember.data.birthDate,
            emails: newMember.data.emails,
            phone: newMember.data.phoneNumbers,
            vatNumber: newMember.data.vat,
            street: newMember.data.street,
            city: newMember.data.city,
            zipCode: newMember.data.zipCode,
            houseNumber: newMember.data.doorNumber,
            familyID: newMember.data.familyID
        }
    }
}

export function addNewMemberFailure(error) {
    return {
        type: ADD_NEW_MEMBER_FAILURE,
        payload: error
    }
}