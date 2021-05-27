import {
    // Insert action's names you want to import
    // ACTION_X
    // ACTION_Y
} from './Actions'

function reducer(state, action) {
    switch (action.type){
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
        default:
            return state;
    }
}

export default reducer;