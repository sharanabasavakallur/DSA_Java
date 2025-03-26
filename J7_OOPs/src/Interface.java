package J7_OOPs.src;
/*
An interface in Java is a blueprint for a class. It specifies a contract that a class must adhere to by defining a set
of abstract methods (methods without a body) that implementing classes must provide.
Starting with Java 8, interfaces can also contain default methods and static methods,
and Java 9 introduced private methods in interfaces.

Key Features of Interfaces
Abstract by Default:
Before Java 8, all methods in an interface were implicitly abstract (i.e., they had no body).
From Java 8 onward, interfaces can have default and static methods with implementations.
Multiple Inheritance:
A class can implement multiple interfaces, allowing Java to support multiple inheritance indirectly.
Constants Only:
All fields in an interface are implicitly public static final (constants).
No Constructors:
Interfaces cannot have constructors, as they cannot be instantiated.

Defining an Interface

interface Animal {
    void eat(); // Abstract method
    void sleep(); // Abstract method
}
Implementing an Interface
A class that implements an interface must provide implementations for all its abstract methods:


class Dog implements Animal {
    public void eat() {
        System.out.println("Dog is eating");
    }

    public void sleep() {
        System.out.println("Dog is sleeping");
    }
}


Example with multiple interfaces
interface Flyable {
    void fly();
}

interface Walkable {
    void walk();
}

class Bird implements Flyable, Walkable {
    public void fly() {
        System.out.println("Bird is flying");
    }

    public void walk() {
        System.out.println("Bird is walking");
    }
}

*/
// Interface
interface Animall {
    public void animalSound(); // interface method (does not have a body)
    public void sleep(); // interface method (does not have a body)
}

// Pig "implements" the Animal interface
class Pigg implements Animall {
    public void animalSound() {
        // The body of animalSound() is provided here
        System.out.println("The pig says: wee wee");
    }
    public void sleep() {
        // The body of sleep() is provided here
        System.out.println("Zzz");
    }
}
public class Interface {
    public static void main(String[] args) {
        Pigg myPig = new Pigg();  // Create a Pig object
        myPig.animalSound();
        myPig.sleep();
    }
}

/*
Features Added in Java 8, 9, and Beyond
1. Default Methods (Java 8)
Default methods allow interfaces to have method implementations.
They are defined using the default keyword.
Subclasses can override default methods if needed.
Example:
interface Animal {
    void sound();

    default void info() {
        System.out.println("This is an animal.");
    }
}

class Dog implements Animal {
    @Override
    public void sound() {
        System.out.println("Dog barks");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.sound(); // Output: Dog barks
        dog.info();  // Output: This is an animal.
    }
}

2. Static Methods (Java 8)
Interfaces can have static methods with implementations.
These methods belong to the interface itself and cannot be overridden by implementing classes.
Example:
interface Animal {
    static void showInfo() {
        System.out.println("Animals are living beings.");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal.showInfo(); // Output: Animals are living beings.
    }
}

3. Private Methods (Java 9)
Interfaces can have private methods to share code between default and static methods.
These methods are not accessible by implementing classes.
Example:
interface Animal {
    default void showInfo() {
        log("Default method is being used.");
    }

    static void showStaticInfo() {
        log("Static method is being used.");
    }

    private static void log(String message) {
        System.out.println("Log: " + message);
    }
}


Differences Between Abstract Classes and Interfaces:
----------------------------------------------------------------------------------------------------------------|
Feature	            |    Abstract Class	                          |  Interface                                  |
----------------------------------------------------------------------------------------------------------------|
Methods	            |    Can have abstract and concrete methods	  |  Abstract, default, and static methods      |
Fields	            |    Can have instance variables	          |  Only public static final constants         |
Constructors	    |    Can have constructors	                  |  Cannot have constructors                   |
Multiple Inheritance|	Does not support multiple inheritance	  |  Supports multiple inheritance              |
Default Behavior	|    Good for partial abstraction	          |  Best for defining a contract or blueprint  |
Access Modifiers	|    Can have private, protected, or public	  |  All methods are implicitly public          |
----------------------------------------------------------------------------------------------------------------|
*/