package J1_Demo.src;

import java.util.Scanner;

public class D10Countnums {
    public static void main(String[] args) {
        System.out.println("Enter a number");
        Scanner in=new Scanner(System.in);
        long n= in.nextLong();
        System.out.println("Enter a digit of given number");
        short s=in.nextShort();
        short count=0;
        long temp=n;
        while(n>0){
            int rem = (int)n % 10 ; //typecasting
            if(rem == s)
                count++;
            n = n / 10 ;
        }
        System.out.println("no_of occurrence of "+s+" in "+temp+" :"+count);
    }
}
