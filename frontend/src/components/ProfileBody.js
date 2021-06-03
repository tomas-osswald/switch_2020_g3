import React, {useContext} from 'react';
import AppContext from '../context/AppContext';

function ProfileBody() {
    const {state} = useContext(AppContext);
    const {profile} = state;
    const {data} = profile;

    return (
        <div className="card">
            <div>
                <div>

                    <img src="https://i.pravatar.cc/300" alt="Tony" width="200px"/>

                </div>
                <div>
                    <h3>{data.name}</h3>
                    <h3>{data.birthdate}</h3>
                    <h3>{data.emails}</h3>
                    <h3>{data.phoneNumbers}</h3>
                    <h3>{data.vat}</h3>
                    <h3>{data.street}</h3>
                    <h3>{data.city}</h3>
                    <h3>{data.doorNumber}</h3>
                </div>
            </div>
        </div>
    )
}

export default ProfileBody;