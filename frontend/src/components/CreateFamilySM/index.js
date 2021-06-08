import React, {useContext, useState} from 'react';
import {CreateFamilyDiv} from "./CreateFamilyElements";
import AppContext from "../../context/AppContext";
import {createFamilySM} from "../../context/Actions";
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


    function handleSubmit() {
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

    function submitAndChangeDisplay(){
        handleSubmit();
        changeDisplay();
    }

    //target.value -> permite que cada valor introduzido seja acrescentado ao valor anterior. Se for apagado algum dos valores, altera também o estado atual da variável.
    // Consultar Manuel Almeida

    if (display) {
        return (
            <div>
                <form>
                    <label>email:</label>
                    <input type="text" id="emailID" onChange={emailID => setEmailID(emailID.target.value)}/>
                    <label>admin name:</label>
                    <input type="text" id="name" onChange={name => setName(name.target.value)}/>
                    <label>birthdate:</label>
                    <input type="text" id="birthdate" onChange={birthdate => setBirthdate(birthdate.target.value)}/>
                    <label>Vat Number:</label>
                    <input type="text" id="vatnumber" onChange={vatNumber => setVatNumber(vatNumber.target.value)}/>
                    <label>phone:</label>
                    <input type="text" id="phone" onChange={phone => setPhoneNumber(phone.target.value)}/>
                    <label>street:</label>
                    <input type="text" id="street" onChange={street => setStreet(street.target.value)}/>
                    <label>city:</label>
                    <input type="text" id="city" onChange={city => setCity(city.target.value)}/>
                    <label>house number:</label>
                    <input type="text" id="house number"
                           onChange={houseNumber => setHouseNumber(houseNumber.target.value)}/>
                    <label>Zip Code:</label>
                    <input type="text" id="zip code" onChange={zipCode => setZipCode(zipCode.target.value)}/>
                    <label>Family Name:</label>
                    <input type="text" id="family name"
                           onChange={familyName => setFamilyName(familyName.target.value)}/>
                    <label>Registration Date:</label>
                    <input type="text" id="registration date"
                           onChange={registrationDate => setRegistrationDate(registrationDate.target.value)}/>
                </form>
                <button onClick={submitAndChangeDisplay}>Register Family</button>
            </div>
        )
    } else if (!display && loading === true) {
        return (
            <div>
                Loading...............
            </div>
        )
    }
    else if (!display && error !== null) {
        return (
            <div>
                Error...............
            </div>
        )
    }
    else {
        return (
            <>
                <div>{data.familyName}</div>
                <p>{data.familyID}</p>
                <p>{data.adminID}</p>
                <p>{data.registrationDate}</p>
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