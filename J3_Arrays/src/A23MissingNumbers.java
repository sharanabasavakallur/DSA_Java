package J3_Arrays.src;

import java.util.ArrayList;

//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
public class A23MissingNumbers {
    public static void main(String[] args) {
        int[] arr={4,3,2,7,8,2,3,1};//basically the array should contain repeated elts instead of distinct ones coz arr.length shoudn't be disturbed
        ArrayList<Integer> ans=missingNumbers(arr);
        System.out.println(ans);
    }

    static ArrayList<Integer> missingNumbers(int[] arr) {
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
            if(arr[index]!=index+1)//index+1 bcz we're starting from index=0 but arrays has 1...n elts
                ans.add(index+1);
        }

        return ans;
    }

    static void swap(int[] arr,int first,int second){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
}


