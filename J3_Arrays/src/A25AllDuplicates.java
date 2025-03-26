package J3_Arrays.src;

import java.util.ArrayList;

//https://leetcode.com/problems/find-all-duplicates-in-an-array/
public class A25AllDuplicates {
    public static void main(String[] args) {
        int[] arr={4,3,2,7,8,2,3,1}; //contains 1...n with repeated elts
        System.out.println("duplicates are : "+duplicates(arr));
    }

    //complete copy paste of A23MissingNumbers just returning elts which are duplicates
    static ArrayList<Integer> duplicates(int[] arr) {
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
                ans.add(arr[index]);
        }

        return ans;
    }

    static void swap(int[] arr,int first,int second){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
}
