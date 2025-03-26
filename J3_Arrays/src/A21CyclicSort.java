package J3_Arrays.src;

import java.util.Arrays;

//this sort is purely for the arrays which contain sequential from 1 to n
public class A21CyclicSort {
    public static void main(String[] args) {
        int[] arr={5,4,3,2,1};
        cyclic(arr);
        System.out.println("After sorting : "+ Arrays.toString(arr));
    }

    static void cyclic(int[] arr){
        int i=0;

        while(i<arr.length){
            //initialise correctIndex for current elt i.e, arr[i] that is arr[i]-1
            //for ex: correct index of 3 would be 2 i.e, if arr[i]=3 then it should be at index:2(arr[i]-1) coz indexing starts from 0 but array starts from 1
            int correctIndex=arr[i]-1;//array contains numbers from 0 to n then correctIndex=arr[i];
            if(arr[i]!=arr[correctIndex]){ //if some other elt is there in place of arr[i] then swap
                swap(arr,i,correctIndex);
            }
            else //else means elt arr[i] is at correct index so simply check for next elt
                i++;
        }
    }


    static void swap(int[] arr,int first,int second){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
}
