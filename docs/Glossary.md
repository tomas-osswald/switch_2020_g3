| Term/Class Name    | Description | Type
|------------|----------|---------|
| Address | Address object|Class|
| CashAccount| CashAccount object |Class|
| CategoryTreeDTO|Object to transfer Standard and Custom categories|Class|
| CustomCategories | Attribute of the Family class |List|
| CustomCategory| Custom financial transaction category, may have children | Class|
| FamilyMemberRelationDTO|Object to transfer Relation Designations|Class|
| FamilyMember|FamilyMember/User object | Class |
| FamilyService| FamilyService object | Class|
| FamilyWithoutAdministratorDTO|Object to transfer FamilyName and FamilyID of families without Admin|Class|
| Family| Family object | Class|
| MemberProfileDTO|Object to transfer Member Profile Info|Class|
| PhoneNumber| PhoneNumber object |Class|
| Relation  | Relation between family members object|Class|
| StandardCategories | Attribute of the categoryService class |List|
| StandardCategoryDTO|Object to transfer StandardCategory names|Class|
| StandardCategory| Built-in financial transaction category, cannot be deleted and may have children | Class|
| VatNumber | VatNumber object|Class|
| administrator | Attribute of FamilyMember Class |Boolean|
| balance |Attribute of CashAccount class | Double|
| birthdate|Attribute of FamilyMember class  |Date|
| cashAccountID| Attribute of CashAccount class | Integer|
| categoryID | Attribute of Category class | Integer|
| categoryName | Attribute of Category class | String|
| categoryService | categoryService object | Class|
| ccNumber| Attribute of FamilyMember class, unique ID relative to the CC Number  |String|
| city|Attribute of Street class |String|
| emails| Attribute of FamilyMember class |ArrayList|
| families | Attribute of the FamilyService class |ArrayList|
| familyCashAccount | Attribute of Family class| CashAccount|
| familyMembers| Attribute of the family class  |ArrayList|
| local|Attribute of Street class |String|
| parentCategory| Attribute of Standard/CustomCategory class | Standard/Custom category|
| phoneNumber|Attribute of the PhoneNumber class |Integer|
| postalCode|Attribute of Street class |String|
| relationDesignation| Attribute of Relation Class |String|
| street|Attribute of Street class |String|
| vatNumber|Attribute of the VatNumber class |Integer|

