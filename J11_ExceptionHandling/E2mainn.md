## Java try-catch block
The code inside the try block is executed.
If an exception occurs during the execution of the try block:
The control immediately transfers to the corresponding catch block.
The exception object (e) contains information about the error.
If no exception occurs, the catch block is skipped.


```example:

public class TryCatchExample {<br>
    public static void main(String[] args) {<br>
        try {<br>
            int num = 10;<br>
            int denom = 0;<br>
            int result = num / denom; // Will throw ArithmeticException<br>
            System.out.println("Result: " + result); // This line won't execute<br>
            } catch (ArithmeticException e) {<br>
                System.out.println("Cannot divide by zero!"); // Handles the exception<br>
            }<br>
        System.out.println("Program continues...");<br>
    }<br>
}<br>
o/p:
Cannot divide by zero!
Program continues...

Enter try block.
Execute int num = 10; → Successful.
Execute int denom = 0; → Successful.
Execute int result = num / denom; → Exception thrown.
Exit try block immediately (remaining statements skipped).
Enter catch (ArithmeticException e) block.
Print "Cannot divide by zero!".
Exit catch block.

Execute System.out.println("Program continues...");.

## Java Multi-catch block
A try block can be followed by one or more catch blocks. Each catch block must contain a different exception handler. So, if you have to perform different tasks at the occurrence of different exceptions, use java multi-catch block.
Points to remember
At a time only one exception occurs and at a time only one catch block is executed.
All catch blocks must be ordered from most specific to most general, i.e. catch for ArithmeticException must come before catch for Exception.

example:
public class MultipleCatchBlock3 {

    public static void main(String[] args) {  
          
           try{    
                int a[]=new int[5];    
                a[5]=30/0;    
                System.out.println(a[10]);  
               }    
               catch(ArithmeticException e)  
                  {  
                   System.out.println("Arithmetic Exception occurs");  
                  }    
               catch(ArrayIndexOutOfBoundsException e)  
                  {  
                   System.out.println("ArrayIndexOutOfBounds Exception occurs");  
                  }    
               catch(Exception e)  
                  {  
                   System.out.println("Parent Exception occurs");  
                  }             
               System.out.println("rest of the code");    
    }  
}  
Output:
Arithmetic Exception occurs
rest of the code

Let's see an example, to handle the exception without maintaining the order of exceptions (i.e. from most specific to most general).
class MultipleCatchBlock5{    
public static void main(String args[]){    
try{    
int a[]=new int[5];    
a[5]=30/0;    
}    
catch(Exception e){System.out.println("common task completed");}    
catch(ArithmeticException e){System.out.println("task1 is completed");}    
catch(ArrayIndexOutOfBoundsException e){System.out.println("task 2 completed");}    
System.out.println("rest of the code...");    
}    
}   
o/p:
Compile-time error

## Nested Try-Catch Blocks
You can have a try-catch block inside another try-catch block. This is useful when multiple levels of exception handling are required.

example:
public class NestedTryCatchExample {
public static void main(String[] args) {
try {
try {
int num = 10 / 0; // Inner exception
} catch (ArithmeticException e) {
System.out.println("Inner catch: Arithmetic Exception caught!");
}
int[] arr = {1, 2};
System.out.println(arr[5]); // Outer exception
} catch (ArrayIndexOutOfBoundsException e) {
System.out.println("Outer catch: Array Index Out of Bounds Exception caught!");
}
}
}
o/p:
Inner catch: Arithmetic Exception caught!
Outer catch: Array Index Out of Bounds Exception caught!

## Java finally block
Java finally block is always executed whether an exception is handled or not. Therefore, it contains all the necessary statements that need to be printed regardless of the exception occurs or not.
Note: If you don't handle the exception, before terminating the program, JVM executes finally block (if any).
Rule: For each try block there can be zero or more catch blocks, but only one finally block.
Note: The finally block will not be executed if the program exits (either by calling System.exit() or by causing a fatal error that causes the process to abort).

A try block must be followed by either:
One or more catch blocks.
A finally block.
Both catch and finally.
Without a catch or finally, the try block is incomplete and will result in a compilation error.

catch alone: ❌ Invalid

finally alone: ❌ Invalid

catch and finally without try: ❌ Invalid

try without catch or finally: ❌ Invalid

If an exception occurs in the try block and there's no catch, the finally block executes before the termination or exception propagates.