#Logic View

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

# ===== !!! ===== 

```puml
component "FFM_BusinessLogic" {
   component "Controllers" {
   }
   component "Model" {
   }
   component "Services" {
   }
   component "Utils" {
   }
}
() "BL_API" as BL_API


BL_API - Controllers
Controllers -(0- Model : Model_API

Controllers -(0- Services : SRV_API

Controllers -(0- Utils : Utils_API

```