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