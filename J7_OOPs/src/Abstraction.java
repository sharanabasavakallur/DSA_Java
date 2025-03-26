package J7_OOPs.src;
//Abstraction is a process of hiding the implementation details and showing only functionality to the user.
//Data abstraction is the process of hiding certain details and showing only essential information to the user.
//Abstraction focuses on what an object does rather than how it does it.
//Abstraction can be achieved with either abstract classes(0% to 100% abstraction) or interfaces(100% abstraction in Java 7, but from Java 8+, interfaces can have default and static methods)

/*
Abstract Classes in Java
An abstract class in Java is a class that cannot be instantiated (i.e., you cannot create objects of it directly).
It is designed to be extended by subclasses that provide implementations for its abstract methods.
An abstract class is used to define a common blueprint for a group of related classes while allowing the subclasses to define specific behaviors.

Key Features of Abstract Classes
Abstract Methods:
An abstract class can have abstract methods (methods without a body).
Abstract methods must be implemented by the subclasses.
Concrete Methods:
An abstract class can also have concrete methods (methods with a body) that can be used as-is or overridden by subclasses.
Fields and Constructors:
An abstract class can have fields (variables) and constructors.
Constructors in an abstract class are invoked during subclass object creation.
Inheritance:
Abstract classes are meant to be extended by subclasses.
The extends keyword is used for this purpose.
Access Modifiers:
Abstract classes can have public, protected, and even private methods or fields.

Syntax:
abstract class AbstractClass {
    // Abstract method (no implementation)
    abstract void abstractMethod();

    // Concrete method (has implementation)
    void concreteMethod() {
        System.out.println("This is a concrete method.");
    }
}

Example:
*/

abstract class Animal {
    public abstract void animalSound();
    public void sleep() {
        System.out.println("Zzz");
    }
}
// Subclass (inherit from Animal)
class Pig extends Animal {
    public void animalSound() {
        // The body of animalSound() is provided here
        System.out.println("The pig says: wee wee");
    }
}
public class Abstraction {
    public static void main(String[] args) {
        //before inheriting Animal class
       // Animal myObj = new Animal(); // will generate an error

        //after inheriting Animal class
        Pig myPig = new Pig(); // Create a Pig object
        myPig.animalSound();
        myPig.sleep();
    }
}

/*
Key Points About Abstract Classes
Cannot Be Instantiated:
You cannot create an object of an abstract class directly:
Shape shape = new Shape(); // Compilation Error
Must Be Extended:
A subclass must implement all abstract methods of the abstract class unless it is also declared abstract.
Can Have Constructors:
Although you cannot instantiate an abstract class, it can have constructors, which are called during subclass object creation.
abstract class Animal {
    Animal() {
        System.out.println("Animal constructor called.");
    }
}

class Dog extends Animal {
    Dog() {
        System.out.println("Dog constructor called.");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
    }
}
Output:
Animal constructor called.
Dog constructor called.
Partial Abstraction:
An abstract class allows both fully abstract methods and concrete methods, providing a mix of abstraction and implementation.
Fields in Abstract Classes:
Abstract classes can have fields, which can be used in concrete methods or overridden in subclasses.
*/

/*
4. Why Use Abstraction?
Encapsulation of details – Hides implementation and exposes only functionality.
Improves modularity – Each subclass provides its own implementation.
Enhances security – Users only interact with essential features, reducing errors.
Encourages maintainability – Changing internal details does not affect the outer API.
*/