package J1_Demo.src;

import java.util.Scanner;

public class D4Conditional {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a letter");
        char ch=sc.next().trim().charAt(0);
        //checking if character is capial or small
        if(ch>='A' && ch<='Z'){
            System.out.println("capital.");
        }
        else
            System.out.println("small.");

    }

}
