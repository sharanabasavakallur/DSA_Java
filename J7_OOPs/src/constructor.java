package J7_OOPs.src;

/*
*Constructor in java
* In Java, a constructor is a block of codes similar to the method. It is called when an instance of the class is created.
* At the time of calling constructor, memory for the object is allocated in the memory.
* Every time an object is created using the new() keyword, at least one constructor is called.
It calls a default constructor if there is no constructor available in the class. In such case,
* Java compiler provides a default constructor by default.

*Constructor name must be the same as its class name
A Constructor must have no explicit return type not even void(coz if void return type is mentioned then it is treated as a method is the same class name but not as a constructor)
* and unlike constructor it's not invoked/called automatically programmer has to call it like other regular methods
* a method must have return type even your method is not returning you should mention void return type)
* Feature	        $Constructor	        $Method with Class Name
  Return Type	    None	                Must have a return type (e.g., void)
  Invocation	    Automatically called 	Explicitly called using the object reference
                    during object creation
  Purpose	        Initialize the object	Perform specific actions or logic
  Default Provided?	Yes (if no constructor 	No (must be explicitly declared)
                          is defined)

A Java constructor cannot be abstract, static, final, and synchronized
*
* Types of Java constructors
There are two types of constructors in Java:
1.Default constructor (no-arg constructor)
2.Parameterized constructor
*
* Java Default Constructor
A constructor is called "Default Constructor" when it doesn't have any parameter.

Syntax of default constructor:
<class_name>(){}
*The default constructor is used to provide the default values to the object like 0, null, etc., depending on the type.
* Rule: If there is no constructor in a class, compiler automatically creates a default constructor.

*/
//Java Program to create and call a default constructor
class Bike1{
    //creating a default constructor
    Bike1(){System.out.println("Bike is created");}
    //main method
    public static void main(String args[]){
//calling a default constructor
        Bike1 b=new Bike1();
    }
}
//output:Bike is created

/*
Java Parameterized Constructor
A constructor which has a specific number of parameters is called a parameterized constructor.

Why use the parameterized constructor?
The parameterized constructor is used to provide different values to distinct objects. However, you can provide the same values also.
*/
//Java Program to demonstrate the use of the parameterized constructor.
class Student4{
    int id;
    String name;
    //creating a parameterized constructor
    Student4(int i,String n){
        id = i;
        name = n;
    }
    //method to display the values
    void display(){System.out.println(id+" "+name);}

    public static void main(String args[]){
        //creating objects and passing values
        Student4 s1 = new Student4(111,"Karan");
        Student4 s2 = new Student4(222,"Aryan");
        //calling method to display the values of object
        s1.display();
        s2.display();
    }
}

/*
Constructor Overloading in java
Constructor overloading in Java is a technique of having more than one constructor with different parameter lists.
They are arranged in a way that each constructor performs a different task.
They are differentiated by the compiler by the number of parameters in the list and their types and their order too.
:)The signature of the constructor consists of the constructor name (which must match the class name) and its parameter list (types, order, and number).
As long as the parameter list differs, it is considered an overloaded constructor.
*/
//Java program to overload constructors
class Student5{
    int id;
    String name;
    int age;
    //creating two arg constructor
    Student5(int i,String n){
        id = i;
        name = n;
    }
    //creating three arg constructor
    Student5(int i,String n,int a){
        id = i;
        name = n;
        age=a;
    }
    void display(){System.out.println(id+" "+name+" "+age);}

    public static void main(String args[]){
        Student5 s1 = new Student5(111,"Karan");
        Student5 s2 = new Student5(222,"Aryan",25);
        s1.display();
        s2.display();
    }
}

public class constructor {
}

/*
* static keyword::::
* static variable:
* we have created an instance variable named count which is incremented in the constructor. Since instance variable gets the memory at the time of object creation,
* each object will have the copy of the instance variable.It belongs to the class rather than any specific instance, meaning it is initialized once and shared among all objects.
* If it is incremented, it won't reflect other objects. So each object will have the value 1 in the count variable.
* static variable will get the memory only once, if any object changes the value of the static variable, it will retain its value.
* */
//Java Program to illustrate the use of static variable which
//is shared with all objects.
class Counter2{
    static int count=0;//will get memory only once and retain its value

    Counter2(){
        count++;//incrementing the value of static variable
        System.out.println(count);
    }

    public static void main(String args[]){
//creating objects
        Counter2 c1=new Counter2();
        Counter2 c2=new Counter2();
        Counter2 c3=new Counter2();
    }
}
//if count variable wasn't static then o/p would have been 1 1 1 but now 1 2 3

//Static mehod
//A static method belongs to the class rather than the object of a class.
//A static method can be invoked without the need for creating an instance of a class/creating object of class.
//A static method can access static data member and can change the value of it.
/*
There are two main restrictions for the static method. They are:

The static method can not use non static data member or call non-static method directly as it's independent of object of class.
Since static methods are not tied to an instance, you cannot use this (which refers to the current instance) or super (which refers to the superclass).
class A{
 int a=40;//non static

 public static void main(String args[]){
  System.out.println(a);
 }
}
Output:Compile Time Error
*/

/*
Static block:
A static block is used to initialize static variables or execute code that needs to run only once, before any object creation or method execution. Static blocks are executed when the class is loaded.

Key Points:
Runs only once, when the class is first loaded into memory.
Useful for initialization logic.

class Example {
    static int x;

    // Static block
    static {
        x = 10;
        System.out.println("Static block executed");
    }

    public static void main(String[] args) {
        System.out.println("Value of x: " + x);
    }
}
o/p:
Static block executed
Value of x: 10

*/

/*
this keyword in java
In Java, this is a reference variable that refers to the current object.

1) this: to refer current class instance variable
The this keyword can be used to refer current class instance variable.
If there is ambiguity between the instance variables and parameters, this keyword resolves the problem of ambiguity.

class Example {
    int number;

    Example(int number) {
        this.number = number; // Refers to the instance variable 'number', this.number is variable of this class and number is argument passed
        //to the constructor if this keyword isn't used here if you pass some non-zero number also that variable is initialized with 0 only
        //if names of both variables aren't same there is no need of this keyword here

    }
}

2) this: to invoke current class method
You may invoke the method of the current class by using the this keyword. If you don't use the this keyword, compiler automatically adds this keyword while invoking the method. Let's see the example

class A{
void m(){System.out.println("hello m");}
void n(){
System.out.println("hello n");
//m();//same as this.m()
this.m();
}
}
class TestThis4{
public static void main(String args[]){
A a=new A();
a.n();
}}
Output:
hello n
hello m

3. Calling Other Constructors
The this() keyword can be used to call another constructor in the same class. This is called constructor chaining.
class Example {
    int number;
    String name;

    Example(int number) {
        this(number, "Default Name"); // Calls the second constructor
    }

    Example(int number, String name) {
        this.number = number;
        this.name = name;
    }
}

4. this() : to invoke current class constructor
The this() constructor call can be used to invoke the current class constructor. It is used to reuse the constructor. In other words, it is used for constructor chaining.

Calling default constructor from parameterized constructor:

class A{
A(){System.out.println("hello a");}
A(int x){
this();
System.out.println(x);
}
}
class TestThis5{
public static void main(String args[]){
A a=new A(10);
}}
Output:
hello a
10


Real usage of this() constructor call
The this() constructor call should be used to reuse the constructor from the constructor. It maintains the chain between the constructors i.e. it is used for constructor chaining. Let's see the example given below that displays the actual use of this keyword.

class Student{
int rollno;
String name,course;
float fee;
Student(int rollno,String name,String course){
this.rollno=rollno;
this.name=name;
this.course=course;
}
Student(int rollno,String name,String course,float fee){
this(rollno,name,course);//reusing constructor
this.fee=fee;
}
void display(){System.out.println(rollno+" "+name+" "+course+" "+fee);}
}
class TestThis7{
public static void main(String args[]){
Student s1=new Student(111,"ankit","java");
Student s2=new Student(112,"sumit","java",6000f);
s1.display();
s2.display();
}}
Output:

111 ankit java 0.0
112 sumit java 6000.0

5) this: to pass as an argument in the method
The this keyword can also be passed as an argument in the method. It is mainly used in the event handling. Let's see the example:

class S2{
  void m(S2 obj){
  System.out.println("method is invoked");
  }
  void p(){
  m(this);
  }
  public static void main(String args[]){
  S2 s1 = new S2();
  s1.p();
  }
}
Output:
method is invoked

Proving this keyword
Let's prove that this keyword refers to the current class instance variable. In this program, we are printing the reference variable and this, output of both variables are same.

class A5{
void m(){
System.out.println(this);//prints same reference ID
}
public static void main(String args[]){
A5 obj=new A5();
System.out.println(obj);//prints the reference ID
obj.m();
}
}
Output:
A5@22b3ea59
A5@22b3ea59
*/