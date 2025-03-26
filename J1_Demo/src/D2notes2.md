## why a java file cant have more than one public class?
In Java, you cannot have more than one public class in a single file because of the way Java's compilation and file structure work. <br>
Here's why:
When a class is declared as public, Java requires that the filename must match the public class name.<br>
If you try to define more than one public class in the same file, it would require the file to have multiple names, which is not possible.<br>
Java enforces one public class per file to maintain clarity and consistency.<br>
The filename must match the public class name.<br>
You can have multiple classes in one file but only one can be public; others must have default access.<br>
If you need multiple public classes, put them in separate .java files.<br>

## Can Only a public Class Have the main Method in Java?
No, the main method does not necessarily have to be in a public class.
However, putting main in a public class is a good practice for better readability and accessibility.
If you have multiple classes in the same file:
Only one class can be public, and that class's name must match the filename.
Other classes can be non-public and have main.
If a class is public, the file name must match the class name.<br>
✅ If there is no public class, the file can have any name.<br>
✅ You must compile the correct filename (javac FileName.java).<br>
✅ To run the program, use java ClassName (not the file name).<br>
✅ You can have multiple non-public classes in the same file.<br>

## is it necessary that atleast one class must have main method?
Yes!,If you are running a Java program, 
at least one class must have a main method because the JVM (Java Virtual Machine) starts execution from main.
The Java compiler (javac) compiles all classes even if they don’t have a main method.
But when you try to run a Java program using java ClassName, the JVM requires a main method to know where to start execution.

✅ Java runs class names, not file names.<br>
✅ Use java ClassName to run a program.<br>
✅ If multiple classes have main, you must specify which class to run.<br>
✅ If a public class exists, the file name must match the public class.<br>

## What Happens If There Are Multiple main Methods?
You can have multiple classes with main.
You must specify which one to run.

for example:
```
class First {
public static void main(String[] args) {
System.out.println("Hello from First!");
}
}

class Second {
public static void main(String[] args) {
System.out.println("Hello from Second!");
}
}
```
to compile :javac MultiClassFile.java (any name is good coz no public class is present)
This creates First.class and Second.class in the same folder.

to run:(you can run both classes separately)
java First              //output:Hello from First!
java Second             //output:Hello from Second!


What happens if we remove static from the main method?<br>
❌ Error: Java won't be able to call main because it's not tied to any object.<br>
What happens if main is private?<br>
❌ Error! JVM cannot access private main<br>

What is garbage collection in Java?<br>
Garbage Collection (GC) automatically removes unused objects to free memory.<br>
It is done by JVM’s Garbage Collector.<br>

How does String pool work in Java?<br>
✅ Strings in Java are stored in a special memory area called the "String Pool" to save memory.
```
String s1 = "hello";
String s2 = "hello";  // Refers to the same object in the pool
String s3 = new String("hello");  // Creates a new object

System.out.println(s1 == s2);  // true (same pool object)
System.out.println(s1 == s3);  // false (different objects)
```

## naming conventions for class name,method name,and variable name
for class prefer PascalCasing(camelCasing with first letter also capital)<br>
start with a letter (a-z)or(A-Z)or $(dollar sign) or _ (underscore sign) <br>
after first character,it can contain letters,digits(0-9),_,or $     <br>
no special characters other than _ and $      <br>
should not start with a digit                 <br>

## argument type inside if/while 
In C/C++, if(x) :x could be any number would work because nonzero values are treated as true and zero(0) is treated as false.
In Java, if requires an explicit boolean condition or boolean expression or true/false.
for example: if(5) would work in c/c++ 5 is non-zero value considered as true
in java if(5) or while(1) gives an error where as while(1) in c/c++ gives an infinite loop
so if(x>5) while(true) or if(x!=9) are some valid examples

## switch-case statement in java
```
switch (expression) {
case value1:
// Code to execute if expression == value1
break;
case value2:
// Code to execute if expression == value2
break;
default:
// Code to execute if no cases match
}
```
✅ The expression inside switch must be of byte, short, int, char, String, or enum type (Java 7+ supports String).<br>
✅ boolean type is NOT allowed in a switch statement in Java unlike if-else or while statements.because it is optimized for multiple values, while boolean has only two.<br>
✅ Each case represents a possible value.<br>
✅ The break statement prevents fall-through to the next case.<br>
✅ The default case executes if no other case matches (optional).

```
switch Argument Type	Valid case Label Type
byte	                byte, short, int, char (within range)
short	                short, int, char (within range)
char	                char, int (within range) (corrosponding ascii values are compared)
int	                    int, char (corrosponding ascii values are compared)
String (Java 7+)	    String
enum	                enum values
⚠ Note: long, float, double, and boolean are NOT allowed as switch expressions.
```

Java 14 introduced a more concise syntax using -> and yield.
```
public class SwitchExpressionExample {
    public static void main(String[] args) {
        int number = 3;
        
        String result = switch (number) {
            case 1 -> "One";
            case 2 -> "Two";
            case 3 -> "Three";
            default -> "Unknown";
        };

        System.out.println(result);
    }
}
```
No need for break.
More readable and concise.