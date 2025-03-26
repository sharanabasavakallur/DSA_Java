package J10_ExceptionHandling;

public class TryCatchExample {
    public static void main(String[] args) {
        try {
            int num = 10;
            int denom = 0;
            int result = num / denom; // Will throw ArithmeticException
            System.out.println("Result: " + result); // This line won't execute
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero!"); // Handles the exception
        }
        System.out.println("Program continues...");
    }
}
