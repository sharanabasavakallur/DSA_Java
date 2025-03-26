package J7_OOPs.src;/*
Inheritance is an important pillar of OOP(Object-Oriented Programming). It is the mechanism in Java
by which one class is allowed to inherit the features(fields and methods) of another class.

Why Do We Need Java Inheritance?
Code Reusability: The code written in the Superclass is common to all subclasses. Child classes can directly use the parent class code.
Method Overriding: Method Overriding is achievable only through Inheritance. It is one of the ways by which Java achieves Run Time Polymorphism.
Abstraction: The concept of abstract where we do not have to provide all details is achieved through inheritance. Abstraction only shows the functionality to the user.

Important Terminologies Used in Java Inheritance
Class: Class is a set of objects which shares common characteristics/ behavior and common properties/ attributes.
Class is not a real-world entity. It is just a template or blueprint or prototype from which objects are created.
Super Class/Parent Class: The class whose features are inherited is known as a superclass(or a base class or a parent class).
Sub Class/Child Class: The class that inherits the other class is known as a subclass(or a derived class, extended class, or child class).
The subclass can add its own fields and methods in addition to the superclass fields and methods.
Reusability: Inheritance supports the concept of “reusability”, i.e. when we want to create a new class and there is already a class that includes some of the code that we want,
we can derive our new class from the existing class. By doing this, we are reusing the fields and methods of the existing class.


*/

//Single Inheritance
//In single inheritance, subclasses inherit the features of one superclass.


//Multilevel inheritance
//In Multilevel Inheritance, a derived class will be inheriting a base class,
// and as well as the derived class also acts as the base class for other classes.
public class Inheritance {
    public static void main(String[] args) {
        Three t=new Three();
        t.hello();
        t.world();
        t.ex();
    }
}

class One{
    public void hello(){
        System.out.println("Hello");
    }
}
class Two extends One{//first level inheritance
    public void world(){
        System.out.print("World");
    }
}

class Three extends Two{//second level inheritance
    public void ex(){
        System.out.print("!");
    }
}

/*
Hierarchical Inheritance Example
When two or more classes inherits a single class, it is known as hierarchical inheritance. In the example given below,
Dog and Cat classes inherits the Animal class, so there is hierarchical inheritance.
*/

/*
Why multiple inheritance is not supported in Java?
To reduce the complexity and simplify the language, multiple inheritance is not supported in java.

Suppose there are three classes A, B, and C. The C class inherits A and B classes.
If A and B classes have the same method and we call it from child class object,
there will be ambiguity to call the method of A or B class.

Since compile-time errors are better than runtime errors, Java renders compile-time error if you inherit 2 classes.
So whether you have same method or different, there will be compile time error.
*/

/*
How Java Supports Multiple Inheritance Through Interfaces
Java allows a class to implement multiple interfaces, avoiding the diamond problem because interfaces do not have method
implementations (prior to Java 8).

Example of Multiple Inheritance Using Interfaces:

interface Interface1 {
    void method1();
}

interface Interface2 {
    void method2();
}

class Child implements Interface1, Interface2 {
    public void method1() {
        System.out.println("Method1 from Interface1");
    }

    public void method2() {
        System.out.println("Method2 from Interface2");
    }
}

public class Main {
    public static void main(String[] args) {
        Child obj = new Child();
        obj.method1();
        obj.method2();
    }
}

Java 8 and Default Methods in Interfaces
From Java 8 onwards, interfaces can have default methods with implementations. Even with this feature, Java resolves ambiguity by requiring the child class to override conflicting methods.

Example of Resolving Conflicts with Default Methods:

interface Interface1 {
    default void show() {
        System.out.println("Interface1's show");
    }
}

interface Interface2 {
    default void show() {
        System.out.println("Interface2's show");
    }
}

class Child implements Interface1, Interface2 {
    // Resolving conflict by overriding the method
    public void show() {
        System.out.println("Child's show");
    }
}

public class Main {
    public static void main(String[] args) {
        Child obj = new Child();
        obj.show(); // Output: Child's show
    }
}

If the child class does not override the conflicting default methods from multiple interfaces, the Java compiler will throw an ambiguity error. This is because the compiler cannot decide which implementation of the default method to use.

Let’s revisit the second program without the show() method overridden in the Child class:

Example Without Overriding

interface Interface1 {
    default void show() {
        System.out.println("Interface1's show");
    }
}

interface Interface2 {
    default void show() {
        System.out.println("Interface2's show");
    }
}

class Child implements Interface1, Interface2 {
    // No override of the conflicting show() method
}

public class Main {
    public static void main(String[] args) {
        Child obj = new Child();
        obj.show(); // Compiler error!
    }
}
Error Explanation
The Java compiler will throw an error like this:


class Child inherits unrelated defaults for show() from types Interface1 and Interface2
This happens because Java cannot determine which show() method to invoke (from Interface1 or Interface2), resulting in ambiguity.

Solution
You must resolve the conflict by overriding the method in the child class and providing your own implementation.


If the child class does not override the conflicting default methods from multiple interfaces,
the Java compiler will throw an ambiguity error. This is because the compiler cannot decide which implementation of the default method to use.

Let’s revisit the second program without the show() method overridden in the Child class:

Example Without Overriding

interface Interface1 {
    default void show() {
        System.out.println("Interface1's show");
    }
}

interface Interface2 {
    default void show() {
        System.out.println("Interface2's show");
    }
}

class Child implements Interface1, Interface2 {
    // No override of the conflicting show() method
}

public class Main {
    public static void main(String[] args) {
        Child obj = new Child();
        obj.show(); // Compiler error!
    }
}
Error Explanation
The Java compiler will throw an error like this:
class Child inherits unrelated defaults for show() from types Interface1 and Interface2
This happens because Java cannot determine which show() method to invoke (from Interface1 or Interface2), resulting in ambiguity.

Solution
You must resolve the conflict by overriding the method in the child class and providing your own implementation.

Option 1: Explicit Override

class Child implements Interface1, Interface2 {
    @Override
    public void show() {
        System.out.println("Child's own show");
    }
}
Option 2: Explicit Super Call
If you want to invoke one specific interface's method, use the following syntax:


class Child implements Interface1, Interface2 {
    @Override
    public void show() {
        Interface1.super.show(); // Explicitly call Interface1's default method
    }
}
In this case, the output will be:

Interface1's show
Key Takeaways
When a child class implements multiple interfaces with conflicting default methods, the child class must override the method to resolve ambiguity.
You can either provide a custom implementation or explicitly call one of the interface's default methods using InterfaceName.super.methodName().
*/