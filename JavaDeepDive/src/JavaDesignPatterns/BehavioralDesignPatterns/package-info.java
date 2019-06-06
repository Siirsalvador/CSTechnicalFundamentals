package JavaDesignPatterns.BehavioralDesignPatterns;

/*
   Strategy Design Pattern

   Used in situations where there is more than one algorithm that a method can execute. The client can select which algorithm will execute
   at runtime
   Example: Collections.sort() and ArrayList.sort()

   My Example: Suppose a bank has an application that can onboard merchants via QR, WEB or POS (depending on which is selected at runtime),
   implement a simple system that can handle all three dynamically.
 */

/*
   State Design Pattern

   Used in situations where there are different behaviors depending on the state of an object. Prevents multiple if-else statements

   My Example: Sending emails to Customers who make complaints via an online platform. Sending customized emails depending on if there's a
   holiday or not.

 */

/*
    Template Method Design Pattern

    Defines the order of the set of steps to execute a task. The set of steps themselves can be overridden by subclasses,
    but the method that defines the order cannot be overridden.

    Furthermore, the template method design pattern implements the "Hollywood Design Principle" (maybe also called IoC). This means that
    the superclass calls the the subclasses and not the other way around.

    Example: Creating a Computer System - can be Macbook or Windows, but it follows a general procedure
 */

/*
   Mediator Design Pattern

   Mediator pattern focuses on providing a mediator between objects for communication, implementing loose-coupling between objects.
   The system objects that communicate each other are called Colleagues.

   Air traffic controller is a great example of mediator pattern where the airport control room works as a
   mediator for communication between different flights [www.journaldev.com]
 */

/*
   Observer Design Pattern

   Observer design pattern is useful when you are interested in the state of an object and want to get notified whenever there is any
   change.

   In observer pattern, the object that listens on the state of another object is called an Observer
   and the object that is being watched is called Subject.

   Model-View-Controller (MVC) frameworks also use Observer pattern where Model is the Subject and Views are observers
   that can register to get notified of any change to the model.

   Observer design pattern is also called as publish-subscribe pattern.
 */