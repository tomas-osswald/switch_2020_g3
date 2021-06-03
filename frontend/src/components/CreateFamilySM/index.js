import React, {useContext, useState, useEffect} from 'react';
import {CreateFamilyDiv} from "./CreateFamilyElements";
import AppContext from "../../context/AppContext";


export default function CreateFamilySM() {
    const {state, dispatch} = useContext(AppContext);
    const {createfamily} = state;
    const {loading, error, data} = createfamily;
    //Como é um POST vamos apenas ter um Estado Local do Component sem englobar o estado global da App neste pedido. Não é preciso
    //guardar no estado da App algo que vai ser enviado para o Backend.
    const [emailID, setEmailID] = useState('');
    const [name, setName] = useState('');
    const [birthdate, setBirthdate] = useState('');
    const [vatNumber, setVatNumber] = useState('');
    const [phone, setPhoneNumber] = useState('');
    const [street, setStreet] = useState('');
    const [city, setCity] = useState('');
    const [houseNumber, setHouseNumber] = useState('');
    const [zipCode, setZipCode] = useState('');
    const [familyName, setFamilyName] = useState('');
    const [registrationDate, setRegistrationDate] = useState('');

    useEffect(() => {
        console.log(emailID, name, birthdate)

    }, [emailID])
    // [] -> Vazio, quando o componente é montado (1ª vez)
    // sem o [] -> sempre que há um Update qualquer ao próprio componente
    // [aqui dentro definir o que vai fazer com que seja feito update] -> no caso de apenas querer modificar estado quando um campo específico é mudado.
    // Com return incluído depois da arrow function, é aplicado o que lá estiver quando o component é "unmounted"

   function handleSubmit(variable) {
          /*  variable.preventDefault();
            dispatch({type: Actions.CREATE_FAMILY, payload: {emailID : emailID}})
            const [emailID, setEmailID] = dispatch;

           */
    }



    //target.value -> permite que cada valor introduzido seja acrescentado ao valor anterior. Se for apagado algum dos valores, altera também o estado atual da variável.
    // Consultar Manuel Almeida
        return (
            <form onSubmit={handleSubmit}>
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
                <input type="text" id="house number" onChange={houseNumber => setHouseNumber(houseNumber.target.value)}/>
                <label>Zip Code:</label>
                <input type="text" id="zip code" onChange={zipCode => setZipCode(zipCode.target.value)}/>
                <label>Family Name:</label>
                <input type="text" id="family name" onChange={familyName => setFamilyName(familyName.target.value)}/>
                <label>Registration Date:</label>
                <input type="text" id="registration date" onChange={registrationDate => setRegistrationDate(registrationDate.target.value)}/>
            </form>);
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