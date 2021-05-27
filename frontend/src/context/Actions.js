import { /* Methods from Service */ } from './Service'

/**
 * Insert functions for Service:
 * - Success function
 * - Error function
 *
 * Both functions should have as ARG the dispatcher
 */



export const DO_NOTHING = 'DO_NOTHING';

export function doNothing(){
    return {
        type: DO_NOTHING,
        payload: {

        }
    }
}