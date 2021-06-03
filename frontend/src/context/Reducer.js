import {
    // Insert action's names you want to import
    // ACTION_X
    // ACTION_Y
    FETCH_PROFILE_STARTED,
    FETCH_PROFILE_SUCCESS,
    FETCH_PROFILE_FAILURE,
    UPDATE_NAME,
    CHANGE_USER,
    FETCH_FAMILYRELATIONS_SUCCESS,
    FETCH_FAMILYRELATIONS_STARTED,
    FETCH_FAMILYRELATIONS_FAILURE,
    LOGOUT, CHANGE_VIEW,
    FETCH_USER_NAME_START,
    FETCH_USER_NAME_SUCCESS,
    FETCH_USER_NAME_FAILURE
} from './Actions'

function reducer(state, action) {
    switch (action.type) {
        /*
        case ACTION_HERE:
            return {
                ...state,
                {data object from AppProvider}: {
                    {variable 1}: x,
                    {variable 2}: y,
                }
            }

         */
        case FETCH_PROFILE_STARTED:
            return {
                ...state,
                profile: {
                    loading: true,
                    error: null,
                    data: null,
                }
            }
        case FETCH_PROFILE_SUCCESS:
            return {
                ...state,
                profile: {
                    loading: false,
                    error: null,
                    data: action.payload.data
                }
            }
        case FETCH_PROFILE_FAILURE:
            return {
                ...state,
                profile: {
                    loading: false,
                    error: action.payload.error,
                    data: null,
                }
            }

        case UPDATE_NAME:
            let teste = action.payload.data;
            if (teste === '3') {
                teste = 'vai po crlh';
            }
            return {
                ...state,
                name: {
                    loading: false,
                    error: null,
                    data: teste,
                }
            }

        case CHANGE_USER:
            return {
                ...state,
                loggedUser: {
                    id: action.payload.id,
                    role: action.payload.role,
                }
            }

        case FETCH_FAMILYRELATIONS_STARTED:
            return {
                ...state,
                family: {
                    loading: true,
                    error: null,
                    data: []
                }
            }

        case FETCH_FAMILYRELATIONS_SUCCESS:
            return {
                ...state,
                family: {
                    loading: false,
                    error: null,
                    data: action.payload.data
                }
            }

        case FETCH_FAMILYRELATIONS_FAILURE:
            return {
                ...state,
                family: {
                    loading: false,
                    error: action.payload.error,
                    data: [],
                }
            }

        case LOGOUT:
            return {
                ...state,
                loggedUser: {
                    id: '',
                    role: '',
                }
            }

        case CHANGE_VIEW:
            return {
                ...state,
                mainView: action.payload.mainView,
            }

        case FETCH_USER_NAME_START:
            return {
            ...state,
            landingPage:{
                    loading: true,
                    error: null,
                    name: '',
                },
            }

        case FETCH_USER_NAME_SUCCESS:
            return {
            ...state,
            landingPage:{
                loading: false,
                error: null,
                name: action.payload,
                }
            }

        case FETCH_USER_NAME_FAILURE:
            return {
                ...state,
                landingPage : {
                    loading: false,
                    error: action.payload.error,
                    name: '',
                }
            }

        default:
            return state;
    }
}

export default reducer;