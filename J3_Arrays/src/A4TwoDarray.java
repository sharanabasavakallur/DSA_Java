package J3_Arrays.src;

import java.util.Arrays;
import java.util.Scanner;

public class A4TwoDarray {
    public static void main(String[] args) {
        int[][] arr2D=new int[4][];//column size isn't necessary coz each row can have any size
        //2d array is basically array of arrays as we declare size in 1d array it's same as row-size in 2d array
        Scanner in=new Scanner(System.in);
        //static initialization
        int[][] arr2={
                {2,3}, //0th index
                {4,5,7}, //1st index
                {5,3,1,2}, //2nd index
                {5,6,4,8,9} //3rd index
              };

        //printing
        for(int i=0;i<arr2.length;i++){
            for(int j=0;j<arr2[i].length;j++){
                System.out.print(arr2[i][j]+" ");
            }
            System.out.println();
        }

        //working with fixed column size i.e every sub array has equal length
        int[][] arr=new int[3][2];
        System.out.println("No. of rows : "+arr.length);//no. of rows

        //taking input

        for(int row=0;row<arr.length;row++){

            //for each column in every row
            for(int col=0;col<arr[row].length;col++){
                arr[row][col]=in.nextInt();
            }
        }

        //printing

        //simple for loop
/*        for(int row=0;row<arr.length;row++){

            //for each column in every row
            for(int col=0;col<arr[row].length;col++){
                System.out.println(arr[row][col]+" ");
            }
            System.out.println();//new line after each row
        }*/

        //enhanced for loop
        for (int[] ints : arr) {

            //for each column in every row
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();//new line after each row
        }

        //printing using Arrays.toString() method
        //simple loop
/*        for(int row=0;row<arr.length;row++) {
            System.out.println(Arrays.toString(arr[row]));
        }*/
        //enhanced loop
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }

    }
}
