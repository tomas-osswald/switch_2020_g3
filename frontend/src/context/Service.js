//const [data, setData] = useState([]);
import {NodePath as Axios} from "@babel/traverse";
import axios from "axios";
import {doNothing} from "./Actions";

export const URL_API = 'http://localhost:8080';

export function fetchProfileFromLogin(success, failure, id) {
    fetch(`http://localhost:8080/people/tonyze@latinlover.com`)
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
            failure(err.message)
        })
    ;
}


export function familyRelationsFA(success, failure, familyId) {
    fetch(`${URL_API}/families/${familyId}/relations`)
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
            failure(err.message)
        })
    ;
}

/*
    const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ title: 'React POST Request Example' })
    };
    fetch('https://reqres.in/api/posts', requestOptions)
        .then(response => response.json())
        .then(data => this.setState({ postId: data.id }));
}
 */

/*export function familyOptions(success,failure){
    const requestOptions ={
        method: 'OPTIONS',
    }

    fetch(`${URL_API}/family`, requestOptions)
        .then (res => res.json())
        .then (res => {
            const allowedTypes = res.headers.get('Allow');
            success(allowedTypes)
        })
        .catch(err =>failure(err.message))
}*/


//TODO: Fazer cenas
export function createfamilySMService(success, failure) {
    return doNothing();
}

/**
 * Landing Page
 */
export function fetchNameWS(success, failure, id) {
    let url = URL_API+"/people/"+id;
    axios.get(`${URL_API}/people/${id}`)
        .then((response) => {
            success(response)
        })
        .catch((err) => {
            failure(err)
        });
}