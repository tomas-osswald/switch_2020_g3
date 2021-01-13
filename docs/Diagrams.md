##System Overview Diagrams

**Hypothesis I: Each actor has a dedicated UI**

```puml
component "Family Finance Management System" {
}
() "System \nManager UI" as smUI
() "Family \nAdministrator UI" as faUI
() "Family \nMember UI" as fmUI

smUI -up- "Family Finance Management System"
faUI -up- "Family Finance Management System"
fmUI -up- "Family Finance Management System"
```

**Hypothesis II: All actors share the same UI**

```puml
component "Family Finance Management System" {
}
() "UI" as UI

UI -up- "Family Finance Management System"
```

**Hypothesis III: System Manager has a dedicated UI and Family Administrator and Members share the same UI**

```puml
component "Family Finance Management System" {
}
() "System Manager UI" as smUI
() "Family UI" as fUI

smUI -up- "Family Finance Management System"
fUI -up- "Family Finance Management System"
```

##Logic View

**System - Logic View**

```puml
component "Family Finance Management System" {
   component "FFM_UI" {
   }
   component "FFM_BusinessLogic" {
   }
}
() "UI" as UI

rectangle a [
Not yet being developed
]
rectangle b [
Being developed in SP01
]

note left of UI : Assuming the simplest \nhypothesis (H.II) in System Overview
UI - "FFM_UI"
"FFM_UI" -(0- "FFM_BusinessLogic" : BL_API
"FFM_UI" -[dashed] a
"FFM_BusinessLogic" -[dashed] b
```

**Business Logic - Logic View**
#!!!!

```puml
component "FFM_BusinessLogic" {
   component "Controllers" {
   }
   component "Model" {
   }
   component "Services" {
   }
}
() "BL_API" as BL_API


BL_API - Controllers
Controllers -(0- Model : Model_API

Controllers -(0- Services : SRV_API

```

## Implementation View

**General Implementation View**

```puml
rectangle a [
Correlated with "Family \nFinance Management System" \ncomponent of System Overview
]
package FFMSystem {
package ui
package controllers
package domain
}
rectangle b [
Correlates with "FFM_UI" \ncomponent of LogicView
]
rectangle c [
Correlates with "FFM_BusinessLogic" \ncomponent of LogicView
]

a -. FFMSystem
ui -> controllers
controllers -> domain
ui -. b
controllers -. c
domain -. c
```

**Business Logic - Implementation View**

```puml
package controllers
package domain {
package services
package model
}
rectangle a [
Correlates with "Controllers" \ncomponent of LogicView
]
rectangle b [
Correlates with "Services" \ncomponent of LogicView
]
rectangle c [
Correlates with "Model" \ncomponent of LogicView
]


controllers -. a
controllers -> domain
services -> model
services -. b
model -. c
```

## Deployment View

```puml
node "User Personal Computer" {
    node "Java Virtual Machine" {
        component "Family Finance Management System" {
        }
    }
}
```

## Use Case Diagram

```puml
left to right direction

actor "Family Member" as fm
actor "Family Administrator" as fa
actor "System Manager" as sm
usecase "UC001 - to create a standard category" as uc001
usecase "UC002 - to get the standard categories \ntree" as uc002
usecase "UC010 - to create a family" as uc010
usecase "UC011 - to add a family administrator" as uc011
usecase "UC101 - to add family members" as uc101
usecase "UC104 - to get the list of family members \nand their relations" as uc104
usecase "UC105 - to create a relation between two \nfamily members" as uc105
usecase "UC110 - to get the list of the categories \non the family’s category tree" as uc110
usecase "UC120 - to create a family cash account" as uc120
usecase "UC150 - to get my profile’s information" as uc150
usecase "UC151 - to add an email account to my \nprofile" as uc151

sm -- uc001
sm -- uc002
sm -- uc010
sm -- uc011
fa -- uc101
fa -- uc104
fa -- uc105
fa -- uc110
fa -- uc120
fm -- uc150
fm -- uc151
```