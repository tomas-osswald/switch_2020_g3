import React, { useContext } from 'react';
import AppContext from '../context/AppContext';

function ProfileHeader() {
    const {headers} = useContext(AppContext);

    return(
        <thead>
        <tr>
            <th style={{width:"50px"}}>{headers.id}</th>
            <th style={{width:"100px"}}>{headers.name}</th>
            <th style={{width:"100px"}}>{headers.username}</th>
            <th style={{width:"70px"}}>{headers.vat}</th>
            <th style={{width:"50px"}}>{headers.birthdate}</th>
            <th style={{width:"100px"}}>{headers.city}</th>

        </tr>
        </thead>
    );
}
export default ProfileHeader;