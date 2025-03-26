package J2_Methods.src;

import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        System.out.println("Iteration 1");
//        sum();//a function to use in static function should be static

        System.out.println("sum of 10 and 20 : "+sum(10,20));
        System.out.println("Iteration 2");
        System.out.println("sum of 34 and 98 : "+sum(34,98));
//        sum();
    }

/*    static void sum(){
        Scanner in=new Scanner(System.in);
        int n1,n2,sum;
        System.out.print("Enter first number: ");
        n1=in.nextInt();
        System.out.print("Enter second number: ");
        n2=in.nextInt();

        sum=n1+n2;
        System.out.println("Sum : "+sum);
    }*/
    static int sum(int a,int b){
        return(a+b);
    }
}
