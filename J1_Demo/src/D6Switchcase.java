package J1_Demo.src;

import java.util.Scanner;

public class D6Switchcase {
    public static void main(String[] args) {
        System.out.println("Enter a player name");
        Scanner in=new Scanner(System.in);
        String s=in.next();

/*        switch (s){
            case "Sachin":
                System.out.println("God of Cricket.");
                break;
            case "Virat":
                System.out.println("King of Cricket.");
                break;
            case "Rohit":
                System.out.println("Hitman of Cricket.");
                break;
            case "Siraj":
                System.out.println("Miyan Magic.");
                break;
            default:
                System.out.println("Enter valid choice.");
        }
*/
        //same block using if else block
/*
        if (s.equals("Sachin")) {
            System.out.println("God of Cricket.");
        } else if (s.equals("Virat")) {
            System.out.println("King of Cricket.");
        } else if (s.equals("Rohit")) {
            System.out.println("Hitman of Cricket.");
        } else if (s.equals("Siraj")) {
            System.out.println("Miyan Magic.");
        } else {
            System.out.println("Enter valid choice.");
        }

 */

        //same blick using enhanced switch statement(shift+rightclick)
        switch (s) {
            case "Sachin" -> System.out.println("God of Cricket.");
            case "Virat" -> System.out.println("King of Cricket.");
            case "Rohit" -> System.out.println("Hitman of Cricket.");
            case "Siraj" -> System.out.println("Miyan Magic.");
            default -> System.out.println("Enter valid choice.");
        }
    }
}
