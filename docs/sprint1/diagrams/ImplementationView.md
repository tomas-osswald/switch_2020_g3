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
package utils
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
rectangle d [
Correlates with "Utils" \ncomponent of LogicView
]

controllers -. a
controllers -> domain
services -> model
services -. b
model -> utils
model -. c
utils -. d
```
