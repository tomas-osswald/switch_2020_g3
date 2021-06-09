//const [data, setData] = useState([]);
import axios from "axios";

export const URL_API = 'http://localhost:8080';

export function fetchProfileFromLogin(success, failure, id) {
    fetch(`${URL_API}/people/${id}`)
        .then((res) => {
            console.log(res);
            return res.json()
        })
        .then((res) => {
            //console.log(res);
            return success(res)
        })
}

export function fetchProfileFromWS(success, failure, id) {

    axios.get(`${URL_API}/people/${id}`)
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

export function familyNameGlobal(success, failure, familyId) {
    fetch(`${URL_API}/families/${familyId}`)
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

export function addRelation(success, failure, createRelationDTO, familyID) {

    /*const requestOptions = {
        method: 'POST',
        mode: 'no-cors',
        headers: {'Access-Control-Allow-Origin': '*', 'Content-Type': 'application/json'},
        body: JSON.stringify(createRelationDTO)
    }

    fetch(`${URL_API}/families/${familyID}/relations`, requestOptions)
        .then(response => response.json())
        .then(response => success(response))
        .catch(error => failure(error.message))
    ;*/

    /* return fetch(`${URL_API}/${familyID}/relations`, {
         method: "POST",
         mode: 'no-cors',
         headers: {
             "Access-Control-Allow-Origin": "*",
             "Content-Type": "application/json"
         },
         body: JSON.stringify(createRelationDTO)
     });*/
    axios.post(`${URL_API}/families/${familyID}/relations`, JSON.stringify(createRelationDTO), {
        headers: {
            'Access-Control-Allow-Origin': '*',
            'Content-Type': 'application/json'
        }
    })
        .then((response) => {
            success(response)
        })
        .catch((err) => {
            failure(err)
            console.log(err)
        });

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
            return failure(err.message)
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

/* export function familyOptions(success,failure){
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
} */


export function createFamilySMService(success, failure, createFamily) {
    let url = URL_API + "/families/";
    axios.post(`${URL_API}/families`, JSON.stringify(createFamily), {headers: {'Content-Type': 'application/json'}})
        .then((response) => {
            success(response)
        })
        .catch((err) => {
            failure(err)
            console.log(err)
        });
}

/**
 * Landing Page
 */
export function fetchNameWS(success, failure, id) {
    let url = URL_API + "/people/" + id;
    axios.get(`${URL_API}/people/${id}`)
        .then((response) => {
            success(response)
        })
        .catch((err) => {
            failure(err)
        });
}

export function addInputedEmailToFamilyMember(success, failure, id, email){
    const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ email: email })
    }

    fetch(`http://localhost:8080/people/${id}/emails`, requestOptions)
        .then(response => response.json())
        .then(response =>success(response))
        .catch(error => failure(error.message))
    ;
}

/**
 * Add New Member
 * **/

export function postNewMember(success, failure, addNewMember){
    //let url = URL_API + "/people/";
    axios.post(`${URL_API}/people`, JSON.stringify(addNewMember), {
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then((response) => {
            success(response)
            console.log(response)
        })
        .catch((err)=>{
            failure(err)
            console.log(err)
        });
}

/*
export const postNewMember = (url, body) => {
    return fetch(url, {
        method: "POST",
        headers: {
            "Access-Control-Allow-Origin": "*",
            "Content-Type": "application/json"
        },
        body: JSON.stringify(body)
    });

 */