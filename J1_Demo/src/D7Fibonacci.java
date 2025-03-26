package J1_Demo.src;

import java.util.Scanner;

public class D7Fibonacci {
    public static void main(String[] args) {
        System.out.println("Enter value of n");
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int x=0;//0th fibonacci
        int y=1;//1st fibonacci
        int count=2;

//        int z = 0;
//        while(count<=n){
//            z = x + y;
//            x = y;
//            y = z;
//            count = count + 1;
//        }

        while(count<=n){
            int temp = y ;//store y in temp becoz we're gonna be changing y in next line
            y = x + y ;
            x = temp ;
            count++ ;
        }
        System.out.println(n+"th fibonacci number is : "+y);
    }
}
