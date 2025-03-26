package J7_OOPs.src;
/*
Method Overloading in Java
Method overloading in Java is a feature that allows a class to have more than one method with the same name, but with different parameters (either in number or type). The method signature (name + parameters) must be different, allowing Java to distinguish between the methods. Overloading is a way to define multiple methods that perform similar tasks but with different types or numbers of inputs.

Key Points About Method Overloading:
Same Method Name: The methods must have the same name.

Different Parameters: The parameters must differ in:

Number of parameters
Type of parameters
Order of parameters (if they are of different types)
Return Type: Method overloading does not depend on the return type. You cannot overload methods if they only differ in return type.

Compile-time Polymorphism: Method overloading is a form of compile-time polymorphism because the method to be invoked is determined at compile time based on the method signature.

Example of Method Overloading
*/
class Calculator {
    // Method to add two integers
    public int add(int a, int b) {
        return a + b;
    }

    // Overloaded method to add three integers
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    // Overloaded method to add two double values
    public double add(double a, double b) {
        return a + b;
    }

    // Overloaded method to add one integer and one double
    public double add(int a, double b) {
        return a + b;
    }
}

public class Overloading {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.add(2, 3)); // Calls add(int, int)
        System.out.println(calc.add(2, 3, 4)); // Calls add(int, int, int)
        System.out.println(calc.add(2.5, 3.5)); // Calls add(double, double)
        System.out.println(calc.add(2, 3.5)); // Calls add(int, double)
    }
}
//Output:
//5
//9
//6.0
//5.5

/*
Rules for Method Overloading

Different Number of Parameters:
You can overload methods if they differ in the number of parameters.
Example:
void display(int a) { }
void display(int a, int b) { }

Different Type of Parameters:
Overload is possible if the parameter types are different.
Example:
void display(int a) { }
void display(String a) { }

Different Order of Parameters:
If the method parameters have different types, you can overload by changing the order.
Example:
void display(int a, String b) { }
void display(String b, int a) { }

Why Use Method Overloading?
Code Clarity/readability: Method overloading allows you to use the same method name for related operations,
making the code more readable and easier to understand.
Simplifies Code: You avoid creating multiple methods with different names for the same purpose.
Flexibility: It provides flexibility in accepting various types and numbers of arguments.

Method Overloading vs Method Overriding
Overloading occurs within the same class, and the method signature (name and parameters) must be different.
Overriding occurs between a superclass and subclass, and the method signature must be the same in both the superclass and subclass.

Limitations of Method Overloading
It is not possible to overload methods based solely on the return type.
// This will cause a compile-time error:
void display() { }
int display() { } // Error: The return type is not sufficient to distinguish these methods.

*/

/*
Method Overloading and Type Promotion
One type is promoted to another implicitly if no matching datatype is found.
byte can be promoted to short, int, long, float or double. The short datatype can be promoted to int, long, float or double.
The char datatype can be promoted to int,long,float or double and so on.

Example of Method Overloading with TypePromotion
class OverloadingCalculation1{
  void sum(int a,long b){System.out.println(a+b);}
  void sum(int a,int b,int c){System.out.println(a+b+c);}

  public static void main(String args[]){
  OverloadingCalculation1 obj=new OverloadingCalculation1();
  obj.sum(20,20);//now second int literal will be promoted to long
  obj.sum(20,20,20);

  }
}
Output:40
60
Example of Method Overloading with Type Promotion if matching found
If there are matching type arguments in the method, type promotion is not performed.

class OverloadingCalculation2{
  void sum(int a,int b){System.out.println("int arg method invoked");}
  void sum(long a,long b){System.out.println("long arg method invoked");}

  public static void main(String args[]){
  OverloadingCalculation2 obj=new OverloadingCalculation2();
  obj.sum(20,20);//now int arg sum() method gets invoked
  }
}
Output:int arg method invoked
Example of Method Overloading with Type Promotion in case of ambiguity
If there are no matching type arguments in the method, and each method promotes similar number of arguments, there will be ambiguity.

class OverloadingCalculation3{
  void sum(int a,long b){System.out.println("a method invoked");}
  void sum(long a,int b){System.out.println("b method invoked");}

  public static void main(String args[]){
  OverloadingCalculation3 obj=new OverloadingCalculation3();
  obj.sum(20,20);//now ambiguity
  }
}
Output:Compile Time Error
*/

/*
final Keyword in Java
The final keyword in Java is a modifier that can be applied to variables, methods, and classes.
It has different meanings and effects depending on its context.(used as restriction)

1. final Variables
When a variable is declared as final, its value cannot be changed once it has been initialized.
Essentially, it becomes a constant.

Key Points:
The variable must be assigned a value either at the time of declaration or in the constructor (if it's an instance variable).
[**instance variables in java
an instance variable is a type of variable that belongs to an instance (object) of a class.
Each object of a class has its own copy of the instance variables defined in the class,
and these variables represent the state or properties of the object.

Key Characteristics of Instance Variables:
Defined in a Class: They are declared inside a class but outside any method, constructor, or block.
Object-Specific: Each object has its own separate copy, so changes made to the variable in one object do not affect others.
Lifetime: They are created when an object is instantiated and destroyed when the object is garbage collected.
Default Values: If not explicitly initialized, they are assigned default values (e.g., 0 for integers, null for objects).
Access Modifiers: They can have access modifiers (private, public, etc.) to control their visibility.
Example:
public class Student {
    // Instance variables
    String name;
    int age;

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.name = "Alice";
        student1.age = 20;

        Student student2 = new Student();
        student2.name = "Bob";
        student2.age = 22;

        student1.displayInfo();
        student2.displayInfo();
    }
}
Output:
Name: Alice
Age: 20
Name: Bob
Age: 22
Here, name and age are instance variables, and each Student object (student1 and student2) has its own copy.
]
final variables Once assigned, the value cannot be modified.
Example:
class Example {
    final int MAX_VALUE = 100; // Constant
    final int AGE;

    Example() {
        AGE = 25; // Final variable can be initialized in the constructor
    }

    void display() {
        // MAX_VALUE = 200; // Compilation Error: Cannot reassign a final variable
        System.out.println("MAX_VALUE: " + MAX_VALUE);
        System.out.println("AGE: " + AGE);
    }
}

public class Main {
    public static void main(String[] args) {
        Example example = new Example();
        example.display();
    }
}
Output:
MAX_VALUE: 100
AGE: 25

2. final Methods
When a method is declared as final, it cannot be overridden by any subclass.
This is used to prevent modification of a method's behavior in derived classes.

Key Points:
The method can still be inherited but not overridden.
Commonly used to lock down critical behavior in a parent class.
Example:
class Parent {
    final void display() {
        System.out.println("This is a final method in Parent class.");
    }
}

class Child extends Parent {
    // void display() { // Compilation Error: Cannot override a final method
    //     System.out.println("Overriding final method.");
    // }
}

public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        child.display();
    }
}
Output:
This is a final method in Parent class.

3. final Classes
When a class is declared as final, it cannot be extended by other classes.
This is used to prevent inheritance and secure the implementation of the class.

Key Points:
Useful when creating immutable classes like String.
No subclass can modify or extend its behavior.
Example:
final class FinalClass {
    void display() {
        System.out.println("This is a final class.");
    }
}

// class SubClass extends FinalClass { // Compilation Error: Cannot inherit from a final class
// }

public class Main {
    public static void main(String[] args) {
        FinalClass obj = new FinalClass();
        obj.display();
    }
}
Output:
This is a final class.

Common Uses of final
Final Variables:
Constants or values that should not change.
Prevent accidental modification.
Final Methods:
Prevent overriding of critical methods.
Used in libraries or APIs to secure behavior.
Final Classes:
To prevent inheritance when the class design should not be extended.
For security and immutability (e.g., String).
Rules and Limitations of final
Final Variables:
Must be initialized once (either at declaration or in the constructor).
For reference variables, the reference cannot be changed, but the object's internal state can be modified (if mutable).
Final Methods:
Can be inherited but not overridden.
Improves performance slightly as the compiler knows they cannot be modified.
Final Classes:
Cannot be subclassed.

Important Notes
The final keyword does not mean "immutable" for objects.
For example:
final ArrayList<String> list = new ArrayList<>();
list.add("Hello"); // Allowed: Modifying the internal state
// list = new ArrayList<>(); // Not Allowed: Changing the reference
A final method cannot also be abstract because abstract implies it must be overridden, which contradicts final.
*/