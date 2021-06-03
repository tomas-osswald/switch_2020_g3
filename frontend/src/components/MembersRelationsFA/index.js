import React, {useContext, useEffect} from 'react';
import AppContext from "../../context/AppContext";
import {fetchFamilyRelationsFA} from "../../context/Actions";
import {func} from "prop-types";


function MembersRelationsFA() {

    const {state, dispatch} = useContext(AppContext);
    const {loggeduserTest, family} = state;
    const {email, familyId} = loggeduserTest;
    const {loading, error, data} = family
    const {familyMemberAndRelationsDTO} = data



    useEffect(() => {

        fetchFamilyRelationsFA(dispatch, familyId);



    }, [])

    function buildText(){
        let text='';
        let i
        for (let i = 0; i < 3; i++) {
            text += {familyMemberAndRelationsDTO}[i].name + "<br>"
            text += {familyMemberAndRelationsDTO}[i].personID + "<br>"
            //text += familyMemberAndRelationsDTO[i].relations

        }
        return text;

    }

    if (loading === true) {
        return (
            <div>
                Loading...
            </div>
        )
    } else {
        if (error !== null) {
            return (
                <div>
                    Error...
                </div>
            )
        } else {
            return (
                <div>
                    <h3>xpto</h3>
                    <h3>{email}</h3>
                    <h3>{familyId}</h3>
                    <button>
                        Clica aqui!!
                    </button>

                    <p>{buildText()}</p>
                    <p>{familyMemberAndRelationsDTO[0].name}</p>

                </div>
            )
        }
    }
}

export default MembersRelationsFA;