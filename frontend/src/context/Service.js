//const [data, setData] = useState([]);
import axios from "axios";
import {doNothing} from "./Actions";
import {config} from './Constants'

export const URL_API = config.url.API_URL;


export function authenticateWS(success, failure, userDetails) {

    axios.post(`${URL_API}/authenticate`, JSON.stringify(userDetails), {
        headers: {
            'Access-Control-Allow-Origin': '*',
            'Content-Type': 'application/json',
        }
    })
        .then((response) => {
            success(response)
        })
        .catch((err) => {
            failure(err.message)
            console.log(err.message)
        });
}

export function fetchProfileFromLogin(success, failure, id, jwt) {
    const authorizationHeader = `Bearer ${jwt}`;
    fetch(`${URL_API}/people/${id}`, {
        headers: {
            //'Access-Control-Allow-Origin': '*',
            Authorization: authorizationHeader
        }
    })
        .then((res) => {
            console.log(res);
            return res.json()
        })
        .then((res) => {
            //console.log(res);
            return success(res)
        })
}

export function fetchProfileFromWS(success, failure, id, jwt) {
    //  let authorizationHeader = "'Bearer " + jwt + "'";
    let authorizationHeader = "Bearer " + jwt;
    axios.get(`${URL_API}/people/${id}`, {
        headers: {
            'Access-Control-Allow-Origin': '*',
            'Authorization': authorizationHeader
        }
    })
        .then((response) => {
            success(response)
            //console.log(response);

        })
        .catch((err) => {
            //console.log(err.message);
            failure(err.message)
        })
    ;
}

export function familyNameGlobal(success, failure, familyId, jwt) {
    let authorizationHeader = "Bearer " + jwt;
    const requestOptions = {
        headers: {
            'Access-Control-Allow-Origin': '*',
            'Content-Type': 'application/json',
            'Authorization': authorizationHeader
        },
    }
    fetch(`${URL_API}/families/${familyId}`, requestOptions)
        .then((res) => {
            console.log(res);
            return res.json()
        })
        .then((res) => {
            console.log(res);
            return success(res)
        })
        .catch((err) => {
            return failure(err.message)
        })
    ;
}
export function changeRelation(success,failure,newRelation, link,jwt){
    let authorizationHeader = "Bearer " + jwt;
    axios.patch(link, JSON.stringify(newRelation),{
        headers: {
            'Access-Control-Allow-Origin': '*',
            'Content-Type': 'application/json',
            'Authorization': authorizationHeader
        }
    })
        .then((response) => {
            success(response)
        })
        .catch((err) => {
            failure(err.message)
            console.log(err.message)
        });
}
export function addRelation(success, failure, createRelationDTO, familyID, jwt) {
    let authorizationHeader = "Bearer " + jwt;
    axios.post(`${URL_API}/families/${familyID}/relations`, JSON.stringify(createRelationDTO), {
        headers: {
            'Access-Control-Allow-Origin': '*',
            'Content-Type': 'application/json',
            'Authorization': authorizationHeader
        }
    })
        .then((response) => {
            success(response)
        })
        .catch((err) => {
            failure(err.message)
            console.log(err.message)
        });

}

export function familyRelationsFA(success, failure, familyId, jwt) {
    let authorizationHeader = "Bearer " + jwt;
    const requestOptions = {
        headers: {
            'Access-Control-Allow-Origin': '*',
            'Content-Type': 'application/json',
            'Authorization': authorizationHeader
        },
    }
    fetch(`${URL_API}/families/${familyId}/relations`, requestOptions)
        .then((res) => {
            console.log(res);
            return res.json()
        })
        .then((res) => {
            console.log(res);
            return success(res)
        })
        .catch((err) => {
            console.log(err.message);
            return failure(err.message)
        })
    ;
}

export function createFamilySMService(success, failure, createFamily, jwt) {
    let authorizationHeader = "Bearer " + jwt;
    axios.post(`${URL_API}/families`, JSON.stringify(createFamily), {
        headers: {
            'Access-Control-Allow-Origin': '*',
            'Content-Type': 'application/json',
            'Authorization': authorizationHeader
        }
    })
        .then((response) => {
            success(response)
        })
        .catch((err) => {
            failure(err.message)
            console.log(err.message)
        });
}

/**
 * Landing Page
 */
export function fetchNameWS(success, failure, id, jwt) {
    //const authorizationHeader = `Bearer ${jwt};
    axios.get(`${URL_API}/people/${id}`, {
        headers: {
            //'Access-Control-Allow-Origin': '*',
            'Content-Type': 'application/json',
            "Authorization": "Bearer " + jwt
        }
    })
        .then((response) => {
            success(response)
        })
        .catch((err) => {
            failure(err.message)
        });
}

export function addInputedEmailToFamilyMember(success, failure, id, email, jwt) {
    let authorizationHeader = "Bearer " + jwt;
    const requestOptions = {
        method: 'POST',
        headers: {
            'Access-Control-Allow-Origin': '*',
            'Content-Type': 'application/json',
            'Authorization': authorizationHeader
        },
        body: JSON.stringify({email: email})
    }

    fetch(`${URL_API}/people/${id}/emails`, requestOptions)
        .then(response => response.json())
        .then(response => success(response))
        .catch(error => failure(error.message))
    ;
}

/**
 * Add New Member
 * **/

export function postNewMember(success, failure, addNewMember, jwt) {
    let authorizationHeader = "Bearer " + jwt;
    axios.post(`${URL_API}/people`, JSON.stringify(addNewMember), {
        headers: {
            'Access-Control-Allow-Origin': '*',
            'Content-Type': 'application/json',
            'Authorization': authorizationHeader
        }
    })
        .then((response) => {
            success(response)
            console.log(response)
        })
        .catch((err) => {
            failure(err.message)
            console.log(err.message)
        });
}

export function deleteEmailFMService(success, failure, email, id, jwt){
    let authorizationHeader = "Bearer " + jwt;
    axios.delete(`${URL_API}/people/${id}/emails/${email}`, {
        headers: {
            'Access-Control-Allow-Origin': '*',
            'Content-Type': 'application/json',
            'Authorization': authorizationHeader
        }
    })
        .then((response) => {
            console.log(response)
            success(response)
        })
        .catch((err) => {
            console.log(err.message)
            failure(err.message)
        });
}