package J6_BitWiseOperators.src;

import java.util.ArrayList;

public class B3Factors {
    public static void main(String[] args) {
        printFactors(50);
    }
    static void printFactors(int n){
        ArrayList<Integer> list=new ArrayList<>();//to store factors >sqrt(n)
        for(int i=1;i<=Math.sqrt(n);i++){

            //why sqrt(n):coz factor pair (a,b) of n then one among a & b must be <=sqrt(n) and other >sqrt(n)
            //explained in B2CheckPrime.java
            if(n%i==0){
                if(n/i==i)//coz if n is perfect square for ex:n=16 and i=4
                          //then we need not print i and n/i i.e 4 twice
                    System.out.println(i);
                else{
                    System.out.println(i);
                    list.add(n/i);//just to print factors orderly
                }
            }

        }
        for(int i=list.size()-1;i>=0;i--){
            System.out.println(list.get(i));
        }
    }
}
