## Robot research and development prototype project

### Objective

1. Extensible – easily adaptable to future enhancements
 - **Strategy Design Pattern** is used to define a family of algorithms, encapsulate each one, and make them interchangeable for example ScanBehaviour, MoveBehaviour, CarryBehaviour etc.
 - **Decorator Design Pattern** is used to attach additional responsibilities to an object dynamically for example Robot consumes extra power for carrying an item than moving alone
 - **Interfaces** are used to achieve **polymorphism** 
 
2. Highly cohesive and loosely coupled
 - Well focused and **single responsible** classes are created
 - **Interfaces** are used to expose the dependencies only through their contracts for loose coupling
 - **Command Design Pattern** is used to encapsulate a request as an object or command, thereby letting you parameterize clients with different requests, queue or log requests for example Robot performs sequence of commands and logs each request
 
3. Good use of OOPS concepts
 - **Polymorphism** is achieved by using **Abstract** classes and **Interfaces**
 - **Abstraction** is used to hide the complexity of any functionality from outside world
 - **Encapsulation** is used to bind together the data and functions that manipulate the data and that keeps both safe from outside interference and misuse
 
4. Make use of design pattern wherever possible
 - **Abstract Factory Design Pattern** is used to provide an interface for creating families of related or dependent objects without specifying their concrete classes for example components creation for Robot
 - **Template Method Design Pattern** is used to redefine certain steps of an algorithm by subclass without changing the algorithm's structure for example Robot command performs pre and post processing to calculate the power consumed in each request 
 - **Singleton Design Pattern** is used to ensure a class has only one instance and encapsulate "just-in-time initialization" or "initialization on first use" for example Robot controller is lazy loaded using static instance holder on demand 
 - **Builder Design Pattern** is used to separate the construction of a complex object from its representation for example attaching components for creating a Robot

5. Code should be clean. Avoid code smells.
 - **Design principles**
    * encapsulate what varies
    * favor composition over inheritance
    * program to interfaces, not implementations
    * depend on abstraction, not on concrete classes
    * a class should have **one reason to change**
    
6. Can easily be unit test. If possible, write unit tests.
 - Following scenarios are unit tests using **TestNG** and **EasyMock** frameworks
    * Robot walks for 3.5 KM
    * Robot walks for 2 Km carrying 3 Kg weight
    * Robot carries 12 Kg weight