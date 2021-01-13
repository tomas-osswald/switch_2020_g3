```puml
title Domain Model Diagram SP01

class Family {
- Name
- UniqueID
- RegistrationDate
}

class FamilyMember {
- Name
- BirthDate

}

class CCnumber {

}

class PhoneNumber {

}

class EmailAddress {

}

class VatNumber {

}

class Address {
- Street
- Postal Code
- Local
- City

}

Family -down-> FamilyMember : has administrator
Family -down-> FamilyMember : \n has members
FamilyMember --> CCnumber : has
FamilyMember --> PhoneNumber : has
FamilyMember --> EmailAddress : has
FamilyMember --> VatNumber : has
FamilyMember --> Address : has
```