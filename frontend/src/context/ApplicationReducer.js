import {
    ADD_NEW_MEMBER_FAILURE,
    ADD_NEW_MEMBER_START,
    ADD_NEW_MEMBER_SUCCESS,
    ADD_RELATION_FAILURE,
    ADD_RELATION_STARTED,
    ADD_RELATION_SUCCESS,
    CHANGE_USER,
    CHANGE_VIEW,
    CREATE_FAMILY_FAILURE,
    CREATE_FAMILY_STARTED,
    CREATE_FAMILY_SUCCESS,
    FETCH_FAMILY_NAME_FAILURE,
    FETCH_FAMILY_NAME_STARTED,
    FETCH_FAMILY_NAME_SUCCESS,
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
    UPDATE_NAME,
    ADD_EMAIL_STARTED,
    ADD_EMAIL_SUCCESS,
    ADD_EMAIL_FAILURE,


    LOADING_LANDING_PAGE_FALSE
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
                    profileData: null,
                }
            }
        case FETCH_PROFILE_SUCCESS:
            return {
                ...state,
                profile: {
                    loading: false,
                    error: null,
                    profileData: action.payload.data
                }
            }
        case FETCH_PROFILE_FAILURE:
            return {
                ...state,
                profile: {
                    loading: false,
                    error: action.payload.error,
                    profileData: null,
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

        case ADD_RELATION_STARTED:
            return {
                ...state,

            }

        case ADD_RELATION_FAILURE:
            return {
                ...state,
                family: {
                    loading: false,
                    error: action.payload.error
                }
            }

        case ADD_RELATION_SUCCESS:
            return {
                ...state,
                addRelationStatus: true,
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

        case FETCH_FAMILY_NAME_STARTED:
            return {
                ...state,
                familyData: {
                    loading: true,
                    error: null,
                    data: []
                }
            }

        case FETCH_FAMILY_NAME_SUCCESS:
            return {
                ...state,
                familyData: {
                    loading: false,
                    error: null,
                    data: action.payload.data
                }
            }

        case FETCH_FAMILY_NAME_FAILURE:
            return {
                ...state,
                familyData: {
                    loading: false,
                    error: action.payload.error,
                    data: [],
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

                landingPage: {
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
                            familyID: '',
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
                    family_id: '',
                },
            }

        case FETCH_USER_NAME_SUCCESS:
            return {
                ...state,
                landingPage: {
                    loading: false,
                    error: null,
                    name: action.payload.name,
                    family_id: action.payload.family_id,
                }
            }

        case FETCH_USER_NAME_FAILURE:
            return {
                ...state,
                landingPage: {
                    loading: false,
                    error: action.payload,
                    name: '',
                }
            }

        case CREATE_FAMILY_STARTED:
            return {
                ...state,
                createdfamily: {
                    loading: true,
                    error: null,
                    data: []
                }
            }

        case CREATE_FAMILY_SUCCESS:
            console.log(action)
            return {
                ...state,
                createdfamily: {
                    loading: false,
                    error: null,
                    data: {
                        familyName: action.payload.familyName,
                        familyID: action.payload.familyID,
                        adminID: action.payload.adminID,
                        registrationDate: action.payload.registrationDate
                    }
                }
            }

        case CREATE_FAMILY_FAILURE:
            return {
                ...state,
                createdfamily: {
                    loading: false,
                    error: "The family could not be created. Apes not strong",
                    data: []
                }
            }

        case ADD_EMAIL_STARTED:
            return {
                ...state,
                profile: {
                    loading: true,
                    error: null,
                    profileData: null,
                }
            }

        case ADD_EMAIL_SUCCESS:
            return {
                ...state,
                profile: {
                    loading: false,
                    error: null,
                    profileData: action.payload
                }
            }

        case ADD_EMAIL_FAILURE:
            return {
                ...state,
                landingPage: {
                    loading: false,
                    error: action.payload.error,
                    name: '',
                }
            }


        case ADD_NEW_MEMBER_START:
            return {
                ...state,
                newMember: {
                    loading: false,
                    error: null,
                    newMemberData: [],
                }
            }

        case ADD_NEW_MEMBER_FAILURE:
            return {
                ...state,
                newMember: {
                    loading: false,
                    error: "New Member was not created. Apes not strong",
                    newMemberData: [],
                }
            }

        case ADD_NEW_MEMBER_SUCCESS:
            return {
                ...state,
                newMember: {
                    loading: true,
                    error: null,
                    newMemberData: {
                        adminID: action.payload.adminID,
                        emailID: action.payload.emailID,
                        name: action.payload.name,
                        birthDate: action.payload.birthDate,
                        vatNumber: action.payload.vatNumber,
                        phone: action.payload.phone,
                        street: action.payload.street,
                        city: action.payload.city,
                        houseNumber: action.payload.houseNumber,
                        zipCode: action.payload.zipCode,
                    },
                }
            }
        case LOADING_LANDING_PAGE_FALSE:
            return {
                ...state,
                landingPage: {
                        loading: false,
                        }
            }

        default:
            return state;
    }
}

export default reducer;