package J5_Recursion.src;

import java.util.Arrays;

public class R7QuickSort {
    public static void main(String[] args) {
        int[] arr={5,4,3,2,1,0};
        System.out.println(Arrays.toString(arr));
        Qsort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    static void Qsort(int[] arr,int low,int high){
        //base case
        if(low>=high){
            return;
        }

        int s=low;
        int e=high;
        int mid=s+(e-s)/2;
        int pivot=arr[mid];

        while(s<=e){
            //if elt at left of pivot should be <pivot
            //and elt at right of pivot should be >pivot
            //if so just increment pointers at either side
            while(arr[s]<pivot){//as needed
                s++;
            }
            while(arr[e]>pivot){//as needed
                e--;
            }
            //if not, then swap and check for next elt i.,e increment pointers
            if(s<=e){//just check condition before swapping
                int temp=arr[s];
                arr[s]=arr[e];
                arr[e]=temp;
                s++;
                e--;
            }
        }

        //so pivot would have got correct position and now sort left and right part of pivot
        Qsort(arr,low,e);//coz e would have reached before pivot
        Qsort(arr,s,high);//coz s would have reached after pivot
    }
}
