package J7_OOPs.src;
/*
Method overriding is a feature in Java that allows a subclass to provide a specific implementation for a method that is already defined in its superclass. The overridden method in the subclass should have the same name, return type, and parameters as the method in the parent class.

It is a key feature of runtime polymorphism in Java.

Key Points About Method Overriding
Same Signature: The overriding method must have the same method name, parameters, and return type as the method in the parent class.
Inheritance Required: Method overriding requires a parent-child relationship (using extends).
Runtime Polymorphism: The method to be called is decided at runtime based on the object.
Access Modifiers:
The overriding method cannot have a more restrictive access modifier than the method in the parent class.
For example, if the parent class method is protected, the overriding method cannot be private.
Annotations: Use the @Override annotation to ensure the method is correctly overriding a superclass method.
Cannot Override:
final methods cannot be overridden.
static methods cannot be overridden but can be re-declared (this is called method hiding).
private methods cannot be overridden because they are not inherited.

Basic Example of Method Overriding
*/
//Java Program to demonstrate the real scenario of Java Method Overriding
//where three classes are overriding the method of a parent class.
//Creating a parent class.
class Bank{
    int getRateOfInterest(){return 0;}
}
//Creating child classes.
class SBI extends Bank{
    int getRateOfInterest(){return 8;}
}

class ICICI extends Bank{
    int getRateOfInterest(){return 7;}
}
class AXIS extends Bank{
    int getRateOfInterest(){return 9;}
}
//Test class to create objects and call the methods
public class Overriding {
    public static void main(String args[]){
        SBI s=new SBI();
        ICICI i=new ICICI();
        AXIS a=new AXIS();
        System.out.println("SBI Rate of Interest: "+s.getRateOfInterest());
        System.out.println("ICICI Rate of Interest: "+i.getRateOfInterest());
        System.out.println("AXIS Rate of Interest: "+a.getRateOfInterest());
    }
}
//Output:
//SBI Rate of Interest: 8
//ICICI Rate of Interest: 7
//AXIS Rate of Interest: 9

/*
Upcasting in Java refers to casting a subclass object to a superclass type.
It is an implicit or explicit process where the reference of a subclass is treated as if it were a reference of its superclass.
Upcasting is primarily used in inheritance and polymorphism to generalize object behavior.

Example:
class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    void sound() {
        System.out.println("Dog barks");
    }

    void specialFeature() {
        System.out.println("Dog can guard the house");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal animal = new Dog(); // Upcasting
        animal.sound();            // Calls overridden method in Dog class

        // animal.specialFeature(); // Compile-time error: specialFeature() not in Animal class
    }
}
Explanation:
Animal animal = new Dog(); demonstrates upcasting. The reference animal is treated as an Animal, even though it refers to a Dog object.
The overridden sound() method in Dog is called due to runtime polymorphism.
specialFeature() is inaccessible because it is not part of the Animal class.

*/

/*
Rules for Method Overriding

Return Type:
The return type of the overriding method must be the same or a subclass (covariant return type) of the return type of the overridden method.
Example with a covariant return type:

class Parent {
    Number getNumber() {
        return 42;
    }
}

class Child extends Parent {
    @Override
    Integer getNumber() { // Covariant return type
        return 42;
    }
}

Access Modifiers:
The overriding method cannot reduce the visibility of the overridden method.

class Parent {
    protected void display() { }
}

class Child extends Parent {
    // void display() { } // Error: Can't reduce visibility to default(here access modifier is default which is more restrictive than protected)
    public void display() { } // Valid
}
->to prevent a situation where the parent class method is publicly accessible but subclass restricts it, breaking the principle of substitutability in inheritance
->A subclass should always behave like the parent class(or more permissive) when used polymorphically.

Static Methods:
Static methods are not overridden; they are re-declared (method hiding).

class Parent {
    static void display() {
        System.out.println("Static method in Parent");
    }
}

class Child extends Parent {
    static void display() {
        System.out.println("Static method in Child");
    }
}

public class Main {
    public static void main(String[] args) {
        Parent obj = new Child();
        obj.display(); // Output: Static method in Parent
    }
}
->In Java, static methods are not overridden because they are bound to the class, not to the object.
This is a fundamental difference between static and instance methods. Overriding relies on runtime polymorphism,
which involves determining the method to invoke based on the object type. Since static methods are resolved
at compile-time (using static binding) and belong to the class itself, they cannot participate in runtime polymorphism.
->that's why main method cant be overriden (coz it's static)
->Key Reasons Why Static Methods Aren’t Overridden
Static Binding:
Static methods are resolved at compile time using the class name or reference type.
Overriding relies on dynamic binding (runtime resolution), which is only applicable to instance methods.
Belongs to the Class:
Static methods are part of the class definition, not the object. Overriding is a feature of object-oriented programming that depends on the object type.
No Polymorphism:
Runtime polymorphism applies to instance methods. Since static methods are not tied to objects, they cannot support polymorphism.

Final Methods:
A final method in the parent class cannot be overridden.

class Parent {
    final void display() {
        System.out.println("Final method in Parent");
    }
}

class Child extends Parent {
    // void display() { } // Error: Cannot override final method
}

*/

/*
super Keyword in Java
The super keyword in Java is a reference variable used to refer to the immediate parent class of the current object. It provides a way for a subclass to access members (fields, methods, or constructors) of its superclass.

Uses of super Keyword::
Access Parent Class Fields (Variables):
If a subclass has a field with the same name as its parent class, super is used to explicitly refer to the parent class's field.
Call Parent Class Methods:
If a subclass overrides a method of the parent class, super can be used to call the parent class's version of the method.
Call Parent Class Constructor:
super() is used to invoke the parent class constructor. This must be the first statement in a subclass constructor.

1. Accessing Parent Class Fields
If the parent and child classes have a variable with the same name, the super keyword helps in distinguishing between them.

class Parent {
    String name = "Parent Class";
}

class Child extends Parent {
    String name = "Child Class";

    void displayNames() {
        System.out.println(name);       // Refers to Child's name
        System.out.println(super.name); // Refers to Parent's name
    }
}

public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        child.displayNames();
    }
}
Output:
Child Class
Parent Class


super Keyword in Java
The super keyword in Java is a reference variable used to refer to the immediate parent class of the current object. It provides a way for a subclass to access members (fields, methods, or constructors) of its superclass.

Uses of super Keyword
Access Parent Class Fields (Variables):

If a subclass has a field with the same name as its parent class, super is used to explicitly refer to the parent class's field.
Call Parent Class Methods:

If a subclass overrides a method of the parent class, super can be used to call the parent class's version of the method.
Call Parent Class Constructor:

super() is used to invoke the parent class constructor. This must be the first statement in a subclass constructor.
1. Accessing Parent Class Fields
If the parent and child classes have a variable with the same name, the super keyword helps in distinguishing between them.

class Parent {
    String name = "Parent Class";
}

class Child extends Parent {
    String name = "Child Class";

    void displayNames() {
        System.out.println(name);       // Refers to Child's name
        System.out.println(super.name); // Refers to Parent's name
    }
}

public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        child.displayNames();
    }
}
Output:
Child Class
Parent Class

2. Calling Parent Class Methods
If a method in the child class overrides a method in the parent class, the super keyword can call the parent class's version of the method.

class Parent {
    void display() {
        System.out.println("Display method in Parent class");
    }
}

class Child extends Parent {
    @Override
    void display() {
        System.out.println("Display method in Child class");
    }

    void show() {
        super.display(); // Calls Parent's display method
        display();       // Calls Child's display method
    }
}

public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        child.show();
    }
}
Output:
Display method in Parent class
Display method in Child class

3. Calling Parent Class Constructor
The super() keyword is used to invoke the parent class constructor.
This must be the first statement in the subclass constructor.
If no super() call is provided, Java automatically calls the default constructor of the parent class (if it exists).

class Parent {
    Parent() {
        System.out.println("Parent class constructor");
    }

    Parent(String msg) {
        System.out.println("Parent class constructor with message: " + msg);
    }
}

class Child extends Parent {
    Child() {
        super("Hello from Child"); // Calls Parent's parameterized constructor
        System.out.println("Child class constructor");
    }
}

public class Main {
    public static void main(String[] args) {
        Child child = new Child();
    }
}
Output:
Parent class constructor with message: Hello from Child
Child class constructor

Key Points
Automatic super() Call:
If a parent class has constructors, and a child class constructor does not explicitly invoke a parent class constructor
using super(), the compiler automatically inserts a call to the parent's no-argument constructor.

No No-Argument Constructor in Parent:
If the parent class does not have a no-argument constructor (default constructor),
the child class must explicitly call one of the available parent constructors using super(arguments).

If super() is omitted and no default constructor exists in the parent class, a compilation error occurs.
Always ensure that either:
The parent class has a no-argument constructor, or
The child class explicitly calls one of the parent's constructors using super(arguments).
*/