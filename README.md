# School Management System

---

## UML for the school management system

___

![](uml/school_management%20UML.PNG)

___

## Team Members

---

| Number       | Name           | Task |
| ------------- |:-------------:| -----:|
| 216250773      | Ian Louw | Employee & EmployeeAddress |
| 215226348      | Hlumelo Mpotulo      |   Student & StudentAddress |
| 218192215 | Vuyisa Nkangana    |   Name |
| 218193882 | Lihle Njobe | Country |
| 216205999 | Bongisa Mpahleni | Address |
| 218330189 | Felicia Zweni | City|

---

## Question 10

---

### Improvements

Classes such as Name and Address could use identifiers for entities that need to make use of them.
Classes such as Employee and Student could use an additional class for name (e.g. EmployeeName or StudentClass).
Uncouple classes for security reasons.

### Flaws

Classes are tightly coupled, this could lead to security issues down the line. Some classes are required to
retrieve a lot of information which can lead to slow return times. Name and Address being complex value objects
can, at times, lead to the system loading slower. There is no security layer set in place which allows the system
to be exposed easily.