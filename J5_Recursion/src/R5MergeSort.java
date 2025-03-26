package J5_Recursion.src;

import java.util.Arrays;

public class R5MergeSort {
    public static void main(String[] args) {
        int[] arr={5,4,2,6,3,1,9,0};
        arr=mergesort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static int[] mergesort(int[] arr){
        //edge case (if the array having 1 element)
        if(arr.length==1){
            return arr;
        }

        int mid=arr.length/2;

        int[] left=mergesort(Arrays.copyOfRange(arr,0,mid));
        int[] right=mergesort(Arrays.copyOfRange(arr,mid,arr.length));

        return merge(left,right);
    }

    static int[] merge(int[] first,int[] second){
        int[] mix=new int[first.length+second.length];
        int i=0,j=0,k=0;

        while(i<first.length && j<second.length){
            if(first[i]<second[j]){
                mix[k++]=first[i++];
            }
            else{
                mix[k++]=second[j++];
            }
        }
        //also copy remaining elements
        while(i<first.length){
            mix[k++]=first[i++];
        }
        while(j<second.length){
            mix[k++]=second[j++];
        }

        return mix;
    }
}
