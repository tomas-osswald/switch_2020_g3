
### Vista de Processos
```puml
autonumber
title Vista de Processos

actor " Actor" as actor
participant ": Component" as component
participant ": Action" as action
participant ": Service" as service
participant ": Reducer" as reducer
participant ": Store" as store


component -> store : subscribe state
activate store

activate actor
actor -> component : request data
activate component
component -> action : function(dispatch(action, requestData))
activate action
action -> service : fetchData(success, failure, requestData)
activate service

ref over service
	service requests data from backend 
end
alt failure
	service -> action : failure(error.message)
else success
	service -> action : success(reponseData)
end

deactivate service
action -> reducer : dispatch(success(reponseData))
deactivate action
deactivate action
activate reducer
reducer -> store : update state
deactivate reducer
store -> component : update component
deactivate store
component -> actor : visualize changes in UI
deactivate component
deactivate actor

```


### Vista de Processos V2

```puml
autonumber
title Vista de Processos

actor " Actor" as actor
participant ": Component" as component
participant ": Action" as action
participant ": Service" as service
participant ": Reducer" as reducer
participant ": Store" as store


component -> store : subscribe Context
activate store

activate actor
actor -> component : request data
deactivate actor
activate component
component -> action : function(dispatch(action, requestData))
deactivate component
activate action

action -> service : fetchData(success, failure, requestData)
deactivate action
activate service

ref over service
	service requests data from backend 
end

service -> action : success(reponseData)
activate action
deactivate service
action -> reducer : dispatch(success(reponseData))
deactivate action
deactivate action
activate reducer
reducer -> store : update state
deactivate reducer
store -> component : update component
activate component
deactivate store
component -> actor : show changes in UI
activate actor
deactivate component
deactivate actor

```