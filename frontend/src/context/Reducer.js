import {
    CHANGE_USER,
    CHANGE_VIEW,
    FETCH_FAMILY_ID_START,
    FETCH_FAMILYRELATIONS_FAILURE,
    FETCH_FAMILYRELATIONS_STARTED,
    FETCH_FAMILYRELATIONS_SUCCESS,
    FETCH_PROFILE_FAILURE,
    FETCH_PROFILE_STARTED,
    FETCH_PROFILE_SUCCESS,
    FETCH_USER_NAME_FAILURE,
    FETCH_USER_NAME_START,
    FETCH_USER_NAME_SUCCESS,
    LOGOUT,
    UPDATE_NAME
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
                mainView: '',

                loggedUser: {
                    id: '',
                    role: '',
                    name: '',
                },

                landingPage:{
                    loading: true,
                    error: null,
                    name: ''
                },

                name: {
                    loading: true,
                    error: null,
                    data: [],
                },

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

                createdfamily: {
                    loading: true,
                    error: null,
                    data: [
                        {
                            familyName: '',
                            familyID :'',
                            adminID: '',
                            registrationDate: ''
                        }
                    ]
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
                landingPage: {
                    loading: true,
                    error: null,
                    name: '',
                },
            }

        case FETCH_USER_NAME_SUCCESS:
            return {
                ...state,
                landingPage: {
                    loading: false,
                    error: null,
                    name: action.payload,
                }
            }

        case FETCH_USER_NAME_FAILURE:
            return {
                ...state,
                landingPage: {
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