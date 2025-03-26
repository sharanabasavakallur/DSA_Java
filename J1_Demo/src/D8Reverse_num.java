package J1_Demo.src;

import java.util.Scanner;

public class D8Reverse_num {
    public static void main(String[] args) {
        System.out.println("Enter a number");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int ans=0;
        int temp=n;
        byte count_digits=0;
        while(n>0){
            int last_digit = n % 10;
            n = n / 10;
            ans = ans * 10 + last_digit;
            count_digits++;
        }
        System.out.println("Number of digits :"+count_digits);
        System.out.println("Reverse of "+temp+" :"+ans);

        //checking palindrome or not
        System.out.println("Do you want to check whether the entered number is palindrome or not?(type y or n)");
        char c=in.next().trim().charAt(0);
        if(c == 'y'){
            if(temp == ans)
                System.out.println(temp+" is palindrome!");
            else
                System.out.println(temp+" is not palindrome!");
        }
    }
}
