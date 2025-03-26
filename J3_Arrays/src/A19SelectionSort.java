package J3_Arrays.src;

import java.util.Arrays;

///the selection sort sorts out the smallest elements left side unlike bubble sort which sorts the biggest elements right side
public class A19SelectionSort {
    public static void main(String[] args) {
        int[] arr1={1,10,6};
        int[] arr2={0,-3,5,-8,22};
        selection_max(arr2);
        System.out.println("After sorting : "+ Arrays.toString(arr2));
        selection_min(arr1);
        System.out.println("After sorting : "+ Arrays.toString(arr1));
    }

    static void selection_max(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            //running n-1 times coz last elt get sorted itself
            int lastIndex=arr.length-1-i;//to run loop until lastIndex
            ///we could have written above condition in for loop itself.. if so it would check the condition for each iteration
            int maxIndex=lastIndex;
            for(int j=0;j<lastIndex;j++){
                if(arr[j]>arr[maxIndex])
                    maxIndex=j;
            }
            //place max_elt at lastIndex
            if(maxIndex!=lastIndex)//if maxIndex is not changed then max_elt is at correct place so no need to swap
                swap(arr,maxIndex,lastIndex);
        }
    }

    static void selection_min(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            //run n-1 times coz last elt gets sorted itself,and also we're doing j=i+1 so when i reaches
            //arr.length-1 then j=arr.length which will raise error of array-out-of-bounds
            int minIndex=i;
            for(int j=i+1;j<arr.length;j++){
                //running loop to find minimum elt and assign its index to minIndex
                if(arr[j]<arr[minIndex])
                    minIndex=j;
            }

            //to optimise we can add a condition for swapping
            //if inner for loops if condition is not at all executed then no need to swap i.,e the min_elt
            // is at correct place so no need to swap
            if(minIndex!=i) //if minIndex not actually changed by if condition of inner loop
                swap(arr,i,minIndex);
        }
    }

    static void swap(int[] arr,int first,int second){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
}
