package J4_Strings.src;

import java.util.Scanner;

public class S3Palindrome {
    //a string is palindrome if it reads same from left end
    //and also from right end
    public static void main(String[] args) {
        String s;
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the string:");
        s=sc.next();
            int i;
            for(i=0;i<=s.length()/2;i++){
                char first=s.charAt(i);
                char last=s.charAt(s.length()-1-i);

                if(first!=last){
                    System.out.println("not palindrome.");
                    break;
                }
            }
            //if we're out of loop then...
            //then i would have reached s.length()+1
            if(i==((s.length()/2)+1))
                System.out.println("palindrome.");
        }

    }

