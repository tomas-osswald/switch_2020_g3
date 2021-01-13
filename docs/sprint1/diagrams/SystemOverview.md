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