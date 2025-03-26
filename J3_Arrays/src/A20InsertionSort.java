package J3_Arrays.src;

import java.util.Arrays;

public class A20InsertionSort {
    public static void main(String[] args) {
        int[] arr={8,2,1,9,13,0,-5};
        insertion(arr);
        System.out.println("Array after sorting : "+ Arrays.toString(arr));

    }

    //in this sorting technique we start selecting from second elt(elt of index:1) of array and go on comparing it with all its
    //left elements and place it accordingly
    static void insertion(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            //i can go upto last second elt of array because next loop is having j=i+1 so
            //if we run i upto last elt then j would go out-of-index
            for(int j=i+1;j>0;j--){
                if(arr[j]<arr[j-1])
                    swap(arr,j,j-1);
                else
                    break;//bcz it would have got placed correctly already by previous iterations
            }
        }
    }

    static void swap(int[] arr,int first,int second){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
}
