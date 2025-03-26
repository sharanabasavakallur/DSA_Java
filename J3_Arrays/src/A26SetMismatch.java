package J3_Arrays.src;

import java.util.ArrayList;
import java.util.Arrays;

//https://leetcode.com/problems/set-mismatch/
public class A26SetMismatch {
    public static void main(String[] args) {
        int[] arr={1,2,2,4}; //the o/p should be [2,3] [repeated,missing-elt]
        System.out.println("missing set : "+Arrays.toString(missing(arr)));
    }

    //complete copy paste of A23MissingNumbers just returning elts which is duplicate and missing elt
    static int[] missing(int[] arr) {
        //just copy pasting cyclic sort
        int i=0;

        while(i<arr.length){
            //initialise correctIndex for arr[i] that is arr[i]-1
            //for ex: correct index of 3 would be 2 and .(array should contain [1...n]
            int correctIndex=arr[i]-1;
            if(arr[i]!=arr[correctIndex]){ //if some other elt is there in place of arr[i] then swap
                swap(arr,i,correctIndex);
            }
            else //else means elt arr[i] is at correct index so simply check for next elt
                i++;
        }

        //find missing numbers
        ArrayList<Integer> ans=new ArrayList<>();
        for(int index=0;index<arr.length;index++){
            if(arr[index]!=index+1)//index+1 bcz we're starting from index=0 at index 0 value should be 1 but arrays has 1...n elts
                return new int[]{arr[index],index+1};
        }

        return new int[]{-1,-1};//if array is sorted 1...n
    }

    static void swap(int[] arr,int first,int second){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
}
