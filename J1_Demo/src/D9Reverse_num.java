package J1_Demo.src;

import java.util.Scanner;

public class D9Reverse_num {
    public static void main(String[] args) {
        System.out.println("Enter a number");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int ans=0;
        int temp1=n;
        byte count_digits1=0;//declaring as byte coz digits would be generally less
        while(n>0){
            int last_digit = n % 10;
            n = n / 10;
            ans = ans * 10 + last_digit;
            count_digits1++;
        }
        System.out.println("Number of digits :"+count_digits1);
        System.out.println("Reverse of "+temp1+" :"+ans);

        //if we stop here and input a number 100 the reversed number'll be 1 but we want 001

        //we get know the number of 0's preceding a non-zero number by doing (number of digits of original number - number of digits of reversed number)
        //for ex: original number is 100 (no_digits=3) and reversed number is 1 (no_digits=1) so no. of zeroes preceding non-zero digit in orignal number is 3-1=2
        //and we will append those zeroes to the reversed number
        int temp2=ans;
        byte count_digits2=0;
        while(ans>0){
            ans=ans/10;
            count_digits2++;
        }
        System.out.println("Number of digits of reversed number :"+count_digits2);

        if(count_digits2>0){//coz count_digits2==0 means there are no zeros preceding non-zero digits of original number
            byte zeroes_to_append= (byte) (count_digits1 - count_digits2);
            String reverse=Integer.toString(temp2);//converting the reversed number to string coz we append required 0's as characters

            while(zeroes_to_append>0){
             reverse="0" + reverse;
             zeroes_to_append--;
            }

            System.out.println("Reversed number : "+reverse);
        }

    }
}
