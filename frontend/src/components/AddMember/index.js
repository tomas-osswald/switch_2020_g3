import React, {useContext, useEffect, useState} from 'react';
import {AddMemberDiv} from "./AddMemberElements";
import {Form, Button, FormControl} from 'react-bootstrap';
import AppContext from "../../context/AppContext";
import {addNewMember} from "../../context/Actions";

function AddMember() {

    const {state, dispatch} = useContext(AppContext);
    const {addMember, landingPage} = state;
    const { loading, error, addMemberData} = addMember;
    const { name } = landingPage;
    const [emailID, setEmailID] = useState('');
    const [userName, setName] = useState('');
    const [birthDate, setBirthdate] = useState('');
    const [vatNumber, setVatNumber] = useState('');
    const [phone, setPhoneNumber] = useState('');
    const [street, setStreet] = useState('');
    const [city, setCity] = useState('');
    const [houseNumber, setHouseNumber] = useState('');
    const [zipCode, setZipCode] = useState('');

    useEffect( () => {

    })

    function handleClick(){
        const addNewMember = {
            adminID: {name},
            emailID: emailID,
            name: userName,
            birthDate: birthDate,
            vatNumber: vatNumber,
            phone: phone,
            street: street,
            city: city,
            houseNumber: houseNumber,
            zipCode: zipCode,
        }
        addNewMember(dispatch, addNewMember);
    }


    return(
        <AddMemberDiv>
            PAGINA ADD FAMILY MEMBER
            <Form>
                <Form.Group controlId="emailID">
                    <Form.Label>Email address</Form.Label>
                    <Form.Control type="email" placeholder="Enter email" onChange={emailID => setEmailID(emailID.target.value)} />
                </Form.Group>

                <Form.Group controlId="name">
                    <Form.Label>Name</Form.Label>
                    <Form.Control type="password" placeholder="Name" onChange={userName => setName(userName.target.value)}/>
                </Form.Group>

                <Form.Group controlId="birthDate">
                    <Form.Label>BirthDate</Form.Label>
                    <Form.Control type="calendar" placeholder="BirthDate" onChange={birthDate => setBirthdate(birthDate.target.value)} />
                </Form.Group>

                <Form.Group controlId="vatNumber">
                    <Form.Label>VatNumber</Form.Label>
                    <Form.Control type="text" placeholder="VatNumber" onChange={vatNumber => setVatNumber(vatNumber.target.value)}/>
                </Form.Group>

                <Form.Group controlId="phone">
                    <Form.Label>Phone</Form.Label>
                    <Form.Control type="text" placeholder="Phone" onChange={phone => setPhoneNumber(phone.target.value)}/>
                </Form.Group>

                <Form.Group controlId="street">
                    <Form.Label>Street</Form.Label>
                    <Form.Control type="text" placeholder="Street" onChange={street => setStreet(street.target.value)}/>
                </Form.Group>

                <Form.Group controlId="city">
                    <Form.Label>City</Form.Label>
                    <Form.Control type="text" placeholder="City" onChange={city => setCity(city.target.value)}/>
                </Form.Group>

                <Form.Group controlId="houseNumber">
                    <Form.Label>HouseNumber</Form.Label>
                    <Form.Control type="text" placeholder="HouseNumber" onChange={houseNumber => setHouseNumber(houseNumber.target.value)}/>
                </Form.Group>

                <Form.Group controlId="zipCode">
                    <Form.Label>ZipCode</Form.Label>
                    <Form.Control type="text" placeholder="ZipCode" onChange={zipCode => setZipCode(zipCode.target.value)}/>
                </Form.Group>

                <Button variant="primary" type="submit" onClick={handleClick}>
                    Submit
                </Button>
            </Form>
        </AddMemberDiv>
    )
}

/*
adminID;
emailID;
name;
birthDate;
vatNumber;
phone;
street;
city;
houseNumber;
zipCode;
*/

export default AddMember;