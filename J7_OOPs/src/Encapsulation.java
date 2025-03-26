package J7_OOPs.src;

/*
Encapsulation is one of the fundamental principles of Object-Oriented Programming (OOP).
It is the process of wrapping data (variables) and methods (functions) that operate on the data into a single unit (class). Encapsulation helps to protect the data from unauthorized access and modification by controlling access through access modifiers.

Key Features of Encapsulation
Data Hiding:
Class variables (fields) are declared as private to restrict direct access from outside the class.
Controlled Access:
Public getter and setter methods are provided to access and update the private fields.
Improved Maintainability:
By hiding the implementation details, the code becomes easier to maintain and modify without affecting other parts of the program.
Improved Security:
Encapsulation prevents unauthorized access and ensures data integrity.
How to Achieve Encapsulation in Java?
Declare the fields of the class as private.
Provide public getter and setter methods to allow controlled access to the fields.

Example:
*/

class BankAccount {
    private String accountNumber;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Getter for balance
    public double getBalance() {
        return balance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }
}

public class Encapsulation {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("123456789", 1000);

        // Deposit and Withdraw operations
        account.deposit(500);  // Deposited: 500
        System.out.println("Balance: " + account.getBalance()); // Balance: 1500

        account.withdraw(300); // Withdrawn: 300
        System.out.println("Balance: " + account.getBalance()); // Balance: 1200

        account.withdraw(2000); // Invalid withdrawal amount.
    }
}

/*
Access Modifiers in Java
Access modifiers in Java are keywords used to define the visibility and scope of variables, methods, constructors, and classes.
They determine what parts of your program can access certain elements.

Explanation of Each Access Modifier
1. private
Scope: The member is accessible only within the same class.
It is the most restrictive access level.
Use Case: Protect sensitive data or internal logic from being accessed directly.
Example:
class Example {
    private int value = 42;

    private void displayValue() {
        System.out.println("Value: " + value);
    }
}

public class Main {
    public static void main(String[] args) {
        Example ex = new Example();
        // System.out.println(ex.value); // Error: value has private access
        // ex.displayValue();            // Error: displayValue() has private access
    }
}

2. Default (No Modifier)
Scope: Accessible only within the same package.
It is also called package-private access.
Use Case: Useful when related classes in the same package need to share information.
Example:
class Example {
    int value = 42; // Default access

    void displayValue() {
        System.out.println("Value: " + value);
    }
}

class Main {
    public static void main(String[] args) {
        Example ex = new Example();
        System.out.println(ex.value); // Accessible as Main and Example are in the same package
        ex.displayValue();            // Accessible
    }
}

3. protected
Scope: Accessible within the same package and by subclasses, even if they are in different packages.
Use Case: Useful in inheritance when subclasses need to access certain members of the parent class.
Example:
class Parent {
    protected String message = "Hello from Parent";

    protected void displayMessage() {
        System.out.println(message);
    }
}

class Child extends Parent {
    void show() {
        System.out.println(message); // Accessible because of protected
    }
}

public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        child.show(); // Output: Hello from Parent
    }
}

4. public
Scope: Accessible from anywhere in the program.
It is the least restrictive access level.
Use Case: Use for methods or variables that must be accessible across the application.
Example:
class Example {
    public String message = "This is public";

    public void displayMessage() {
        System.out.println(message);
    }
}

public class Main {
    public static void main(String[] args) {
        Example ex = new Example();
        System.out.println(ex.message); // Accessible anywhere
        ex.displayMessage();            // Accessible anywhere
    }
}
________________________________________________________________
Modifier |	Class |	Package	| Subclass |  World(Outside Package)|
----------------------------------------------------------------|
private	 |   ✔️	  |  ❌	    | ❌	   |     ❌                 |
default	 |   ✔️	  |  ✔️	    | ❌	   |     ❌                 |
protected|	 ✔️	  |  ✔️	    | ✔️	   |     ❌                 |
public	 |   ✔️	  |  ✔️	    | ✔️	   |     ✔️                 |
----------------------------------------------------------------|
*/