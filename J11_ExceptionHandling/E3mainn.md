## Java throw keyword
The Java throw keyword is used to throw an exception explicitly.

We specify the exception object which is to be thrown. The Exception has some message with it that provides the error description. These exceptions may be related to user inputs, server, etc.

We can throw either checked or unchecked exceptions in Java by throw keyword. It is mainly used to throw a custom exception. 

## custom exceptions
A custom exception is a user-defined exception created by extending the Exception or RuntimeException class. It allows developers to define application-specific error conditions and provide meaningful messages for better debugging.
Steps to Create a Custom Exception
Extend the Exception or RuntimeException class.
Create constructors for the exception to handle custom error messages or pass error details.
```Example: Custom Exception

class InvalidAgeException extends Exception {<br>
public InvalidAgeException(String message) { <br>
super(message); // Call the parent class's constructor <br> 
} <br>
}

**Using Custom Exceptions**<br>
Custom exceptions are typically thrown using the throw keyword when a specific condition is violated.
    public class CustomExceptionExample {<br>
        public static void checkAge(int age) throws InvalidAgeException {<br>
        if (age < 18) {<br>
        throw new InvalidAgeException("Age must be 18 or older.");<br>
        } else {<br>
        System.out.println("Valid age!");<br>
    }<br>
}<br>
public static void main(String[] args) {<br>
        try {<br>
            checkAge(16); // This will throw InvalidAgeException<br>
        } catch (InvalidAgeException e) {<br>
            System.out.println("Exception caught: " + e.getMessage());<br>
        }<br>
    }<br>
}<br>
o/p:
Exception caught: Age must be 18 or older.

## throws Keyword
The throws keyword is used in a method declaration to specify that the method might throw one or more exceptions. It tells the caller of the method to handle or declare the exceptions.
syntax:
returnType methodName(parameters) throws ExceptionType1, ExceptionType2 {<br>
// method body<br>
}<br>