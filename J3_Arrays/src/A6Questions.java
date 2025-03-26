package J3_Arrays.src;

import java.util.Arrays;
import java.util.Scanner;

public class A6Questions {
    public static void main(String[] args) {
        int[] arr=new int[7];
        Scanner in=new Scanner(System.in);
        System.out.println("Enter 7 elements of array:");
        for(int i=0;i<arr.length;i++){
            arr[i]=in.nextInt();
        }

        System.out.println("swapping elts at index 3 and 5");
        swap(arr,3,5);
        System.out.println(Arrays.toString(arr));

        System.out.println("Maximum elt of array : "+Maxelt(arr));
        System.out.println("Minimum elt of array : "+Minelt(arr));

        System.out.println("After reversing...");
        revArr(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void swap(int[] arr ,int index1 ,int index2){
        int temp=arr[index1];
        arr[index1]=arr[index2];
        arr[index2]=temp;
    }

    static int Maxelt(int[] arr){
        int max=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>max)
                max=arr[i];
        }
        return max;
    }

    static int Minelt(int[] arr){
        int min=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]<min)
                min=arr[i];
        }
        return min;
    }

    static void revArr(int[] arr){
        int start=0,last=arr.length-1;
        //System.out.println(start+" "+last);
        while(start<last){//2 pointer approach ..loop ends when start==last when size of array is odd(loop stops at middle
            //element to which swapping is no needed) and when start>last when size of array is even
            swap(arr,start,last);
            start++;
            last--;
        }
    }
}
