# Employee Management System

 Java console application illustrating the principles of object-oriented programming (OOP) — inheritance and polymorphism — through an employee management system. 

## Description
This project allows you to manage different types of employees (Developer, Manager, Intern, Tester) through an interactive console interface. Each type of employee inherits from a base `Employee` class and implements its own behavior (`work()` and `calculateBonus()` methods).

##  Features
- **View all employees**: full list with details and bonus calculation
- **Search for an employee** by ID
- **Add an employee**: choose the type (Developer, Manager, Intern, Tester), automatic generation of a unique ID
- **Update an employee**: change the name, salary, or department
- **Exit** the application properly

## Project Structure

```
Employee_Management/
├── src/
│ ├── Employee/ # Base class (abstract)
│ ├── Developer/ # Inherits from Employee
│ ├── Manager/ # Inherits from Employee
│ ├── Intern/ # Inherits from Employee
│ ├── Tester/ # Inherits from Employee
│ └── EmployeeManagement/ # Main class (main)
├── bin/ # Compiled files (.class) — generated, ignored by Git
├── .gitignore
└── README.md
```

## OOP Concepts Illustrated
- **Inheritance**: `Developer`, `Manager`, `Intern`, and `Tester` all inherit from `Employee`
- **Polymorphism**: each subclass overrides `work()` and `calculateBonus()` according to its own behavior
- **Encapsulation**: getters/setters to access and modify employee attributes

### Manual Compilation From the root of the project: ```bash javac -d bin srcDeveloper*.java srcEmployee*.java srcEmployeeManagement*.java srcIntern*.java srcManager*.java srcTester*.java ``` 

### Execution ```bash java -cp bin EmployeeManagement ``` 

## Usage When launched, an interactive menu appears: ``` 
======= EMPLOYEE MANAGEMENT SYSTEM ======= 1. Display all employees 2. Search employee 3. Add employee 4. Update employee 5. Exit ``` Just enter the number corresponding to the action you want and follow the on-screen instructions. 

## Technologies used - **Java** (standard JDK, no external dependencies) - `java.util.ArrayList` to store employees - `java.util.Scanner` for user input - `java.util.Random` for generating unique IDs


Project done as part of learning object-oriented programming concepts in Java.