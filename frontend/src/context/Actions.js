import { fetchProfileFromWS } from './Service'

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
export const UPDATE_NAME = 'UPDATE_NAME'

export function doNothing(){
    return {
        type: DO_NOTHING,
        payload: {
        }
    }
}

export function updateName(variable){
    return {
        type: UPDATE_NAME,
        payload: {
            data: variable
        }
    }
}

export function fetchProfile(dispatch){
    dispatch(fetchProfileStarted());
    fetchProfileFromWS((res) => dispatch(fetchProfileSuccess(res)), (err) =>dispatch(fetchProfileFailure(err.message)));
}

export function fetchProfileStarted () {
    return {
        type: FETCH_PROFILE_STARTED,
    }
}

export function fetchProfileSuccess(profile) {
    return {
        type: FETCH_PROFILE_SUCCESS,
        payload:{
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