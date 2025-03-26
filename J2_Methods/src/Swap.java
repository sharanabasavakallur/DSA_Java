package J2_Methods.src;

import java.util.Scanner;

import static java.util.Collections.swap;

public class Swap {
    public static void main(String[] args) {
        int a,b;
        System.out.print("Enter values of a and b : ");
        Scanner in=new Scanner(System.in);
        a=in.nextInt();
        b=in.nextInt();

        System.out.println("Before swapping a="+a+" ,b="+b);
        swap(a,b);
    }

    static void swap(int a,int b){
/*
 int temp=a;
 a=b;
 b=temp;
*/
        //without using temp variable
        a=a+b;
        b=a-b;
        a=a-b;
        System.out.println("After swapping a="+a+" ,b="+b);
    }
}
