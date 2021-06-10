import React, {useContext, useState} from 'react';
import {CreateFamilyDiv} from "./CreateFamilyElements";
import AppContext from "../../context/AppContext";
import {createFamilySM} from "../../context/Actions";
import {FormControl, FormGroup, FormLabel} from "react-bootstrap";
/*import CreateFamilyForm, {
    emailID,
    name,
    birthDate,
    vatNumber,
    phone,
    street,
    city,
    houseNumber,
    zipCode,
    familyName,
    registrationDate
} from "./CreateFamilyForm";*/

export default function CreateFamilySM() {
    const {state, dispatch} = useContext(AppContext);
    const {createdfamily} = state;
    const {loading, error, data} = createdfamily;
    //Como é um POST vamos apenas ter um Estado Local do Component sem englobar o estado global da App neste pedido. Não é preciso
    //guardar no estado da App algo que vai ser enviado para o Backend.
    const [emailID, setEmailID] = useState('');
    const [name, setName] = useState('');
    const [birthDate, setBirthdate] = useState('');
    const [vatNumber, setVatNumber] = useState('');
    const [phone, setPhoneNumber] = useState('');
    const [street, setStreet] = useState('');
    const [city, setCity] = useState('');
    const [houseNumber, setHouseNumber] = useState('');
    const [zipCode, setZipCode] = useState('');
    const [familyName, setFamilyName] = useState('');
    const [registrationDate, setRegistrationDate] = useState('');


    const [display, setDisplay] = useState(true);

    // [] -> Vazio, quando o componente é montado (1ª vez)
    // sem o [] -> sempre que há um Update qualquer ao próprio componente
    // [aqui dentro definir o que vai fazer com que seja feito update] -> no caso de apenas querer modificar estado quando um campo específico é mudado.
    // Com return incluído depois da arrow function, é aplicado o que lá estiver quando o component é "unmounted"


    async function handleSubmit() {
        //TODO: Verificar type e dispatch. O que leva aqui??
        const createFamily = {
            emailID: emailID,
            name: name,
            birthDate: birthDate, vatNumber: vatNumber, phone: phone, street: street,
            city: city, houseNumber: houseNumber, zipCode: zipCode, familyName: familyName,
            registrationDate: registrationDate
        }
        createFamilySM(dispatch, createFamily)

    }

    function changeDisplay() {
        setDisplay(!display)
    }

    function submitAndChangeDisplay() {
        handleSubmit().then(changeDisplay());
    }

    function cleanStateAndChangeDisplay(){
        cleanState()
        changeDisplay();
    }

    function cleanState(){
        setEmailID('');
        setName('');
        setBirthdate('');
        setVatNumber('');
        setPhoneNumber('');
        setStreet('');
        setCity('');
        setHouseNumber('');
        setZipCode('');
        setFamilyName('');
        setRegistrationDate('');
    }

    //target.value -> permite que cada valor introduzido seja acrescentado ao valor anterior. Se for apagado algum dos valores, altera também o estado atual da variável.
    // Consultar Manuel Almeida

    if (display) {
        return (
            <div>
                <form>
                    <FormGroup controlId="emailID">
                        <FormLabel>Email: </FormLabel>
                        <FormControl type="text" placeholder="Insert email here"
                                     onChange={emailID => setEmailID(emailID.target.value)}/>
                    </FormGroup>

                    <FormGroup controlId="adminName">
                        <FormLabel>Administrator Name: </FormLabel>
                        <FormControl type="text" placeholder="Insert Admin name"
                                     onChange={name => setName(name.target.value)}/>
                    </FormGroup>

                    <FormGroup controlId="birthdate">
                        <FormLabel>Birthdate: </FormLabel>
                        <FormControl type="text" placeholder="Insert birthdate here"
                                     onChange={birthdate => setBirthdate(birthdate.target.value)}/>
                    </FormGroup>

                    <FormGroup controlId="vatnumber">
                        <FormLabel>Vat Number: </FormLabel>
                        <FormControl type="text" placeholder="Insert Vat Number here"
                                     onChange={vatNumber => setVatNumber(vatNumber.target.value)}/>
                    </FormGroup>

                    <FormGroup controlId="phone">
                        <FormLabel>Phone Number: </FormLabel>
                        <FormControl type="text" placeholder="Insert Phone number here"
                                     onChange={phone => setPhoneNumber(phone.target.value)}/>
                    </FormGroup>

                    <FormGroup controlId="street">
                        <FormLabel>Street: </FormLabel>
                        <FormControl type="text" placeholder="Insert street here"
                                     onChange={street => setStreet(street.target.value)}/>
                    </FormGroup>

                    <FormGroup controlId="city">
                        <FormLabel>City: </FormLabel>
                        <FormControl type="text" placeholder="Insert city here"
                                     onChange={city => setCity(city.target.value)}/>
                    </FormGroup>

                    <FormGroup controlId="houseNumber">
                        <FormLabel>House Number: </FormLabel>
                        <FormControl type="text" placeholder="Insert house number here"
                                     onChange={houseNumber => setHouseNumber(houseNumber.target.value)}/>
                    </FormGroup>

                    <FormGroup controlId="zipCode">
                        <FormLabel>Zip Code: </FormLabel>
                        <FormControl type="text" placeholder="Insert zip code here"
                                     onChange={zipCode => setZipCode(zipCode.target.value)}/>
                    </FormGroup>

                    <FormGroup controlId="familyName">
                        <FormLabel>Family Name: </FormLabel>
                        <FormControl type="text" placeholder="Insert Family Name"
                                     onChange={familyName => setFamilyName(familyName.target.value)}/>
                    </FormGroup>

                    <FormGroup controlId="registrationDate">
                        <FormLabel>Registration Date: </FormLabel>
                        <FormControl type="text" placeholder="Insert registration date here"
                                     onChange={registrationDate => setRegistrationDate(registrationDate.target.value)}/>
                    </FormGroup>
                </form>
                <br></br>
                <button onClick={submitAndChangeDisplay}>Register Family</button>
            </div>
        )
        //TODO: Add Loading Screen
    } else if (!display && loading === true) {
        return (
            <div>
                Loading...............
            </div>
        )
    } else if (!display && error !== null) {
        return (
            <div>
                <p>{createdfamily.error}</p>
                <button onClick={cleanStateAndChangeDisplay}>Try again</button>
            </div>
        )
    } else {
        return (
            <>
                <p>{data.familyName}</p>
                <p>{data.familyID}</p>
                <p>{data.adminID}</p>
                <p>{data.registrationDate}</p>
                <button onClick={cleanStateAndChangeDisplay}>Create another family</button>
            </>
        )
    }


}


/*
Alternativa aos passos "singulares"
const [createfamilystate, setfamilystate] = useState({
    emailID: '',
    name: '',
    birthdate: '',
    vatNumber: '',
    phone: '',
    street: '',
    city: '',
    houseNumber: '',
    zipCode: '',
    familyName: '',
    registrationDate: ''
})

 */