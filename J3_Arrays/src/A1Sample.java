package J3_Arrays.src;

import java.util.Arrays;
import java.util.Scanner;

public class A1Sample {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int[] arr;//array declaration
        arr=new int[6];//array initialization
        //int arr=new int[5]; both declaration and initialization

        //taking input using loop
        //if u dont know array length use arr.length
        System.out.println("Enter "+arr.length+" array elements:");
        for(int i=0;i<arr.length;i++){
            arr[i]=in.nextInt();
        }

        //printing array elements
        System.out.println("Array elements are :");
        //simple for loop
//        for(int j=0;j<arr.length;j++){
//            System.out.println(arr[j]);
//        }
        //enhanced for loop
        for (int j : arr) {
            System.out.print(j+" ");
        }

        //if u want to print whole array with square brackets
        System.out.println("\n"+Arrays.toString(arr));



        //array of strings
        String[] arrObj=new String[5];
        System.out.println("Enter "+arrObj.length+" array elements(strings):");
        for(int i=0;i<arrObj.length;i++){
            arrObj[i]=in.next();
        }

        System.out.println("Array elements are :");
        for (String s : arrObj) {
            System.out.println(s + " ");
        }
    }
}
