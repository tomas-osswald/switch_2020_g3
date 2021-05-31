//import {personID} from '../components/Table';  ${personID}

export const URL_API = 'http://localhost:8080'


export function fetchProfileFromWS(success,failure){
    fetch(`${URL_API}/people/tonyze@latinlover.com`)
        .then (res => res.json())
        .then (res => success(res))
        .catch (err=> failure(err.message))
    ;
}