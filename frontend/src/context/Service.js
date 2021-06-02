import {NodePath as Axios} from "@babel/traverse";

export const URL_API = 'http://localhost:8080'

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

/*
export function fetchProfileFromWS(success,failure,id){
    fetch(`${URL_API}/people/${id}`)
        .then (res => res.json())
        .then (res => success(res))
        .catch (err=> failure(err.message))
    ;
}

export function familyOptions(success,failure){
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
}

 */


export function familyRelationsFA(success, failure, familyId){

    fetch(`${URL_API}/families/${familyId}/relations`)
        .then ( (res) => {
            console.log(res);
            return res.json()
        })
        .then ((res) =>{
            console.log(res);
            return success(res)
        })
        .catch ((err) => {
            console.log(err.message);
            failure(err.message)
        })
    ;
}

