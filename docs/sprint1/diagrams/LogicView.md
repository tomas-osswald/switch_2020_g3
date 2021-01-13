#Logic View

**General Logic View**

```puml
left to right direction
component "Family Finance Management System" as FFMS <<component>> {
   component "FFM_UI" <<component>> {
   }
   component "FFM_BusinessLogic" <<component>>  {
   }
}
() "UI" as UI

note "Not yet being developed" as a
note "Being developed in SP01" as b
note "Assuming the simplest \nhypothesis (H.II) in System Overview" as c

c .right. UI
UI --# FFMS
FFMS -- "FFM_UI"
"FFM_UI" -(0- "FFM_BusinessLogic" : BL_API
"FFM_UI" .left. a
"FFM_BusinessLogic" .left. b
```

**Business Logic - Logic View**

```puml

circle "BL_API" as BL_API

component FFM_BusinessLogic as FFM_BL <<component>> {
   component Controllers <<component>> {
   }
   circle Model_API
   circle Service_API
   circle Utils_API
   component Model <<component>> {
   }
   component Services <<component>> {
   }
   component Utils <<component>> {
   }
}

BL_API -# FFM_BL

FFM_BL - Controllers
Controllers -( Model_API
Controllers -up-( Service_API
Controllers -down-( Utils_API
Service_API )-right- Services
Model_API -right- Model
Utils_API )-right- Utils
Services -( Model_API
Utils -up-( Model_API
```