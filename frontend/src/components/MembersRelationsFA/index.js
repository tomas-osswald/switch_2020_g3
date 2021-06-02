import React, {useContext, useState, useReducer, useEffect} from 'react';
import {render} from "@testing-library/react";
import AppContext from "../../context/AppContext";
import { fetchFamilyRelationsFA} from "../../context/Actions";


function MembersRelationsFA() {

    const {state, dispatch} = useContext(AppContext);
    const {loggeduserTest, family} = state;
    const {email, familyId} = loggeduserTest;
    const {loading, error, data} = family
    const {familyMemberAndRelationsDTO} = data
    

    useEffect( ()=> {

        fetchFamilyRelationsFA(dispatch, familyId);
    }, [])

    if (loading === true){
        return (
            <div>
                Loading...
            </div>
        )
    } else {
        if (error !== null){
            return(
                <div>
                    Error...
                </div>
            )
        } else {
            return(
                <div>
                    <h3>xpto</h3>
                    <h3>{email}</h3>
                    <h3>{familyId}</h3>
                    <button >
                        Clica aqui!!
                    </button>

                    <p>{familyMemberAndRelationsDTO[0].name}</p>

                </div>
            )
        }
    }
}

export default MembersRelationsFA;