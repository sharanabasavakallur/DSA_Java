package J5_Recursion.src;

import java.util.Arrays;

public class R4Sorts {
    public static void main(String[] args) {
        int[] arr1={8,3,7,-4,0,15,2,9};
        bubblesort(arr1,arr1.length);
        System.out.println("After sorting :"+ Arrays.toString(arr1));

        int[] arr2={8,3,7,-4,0,15,12,99,21};
        SelectionSort(arr2,arr2.length,0);
        System.out.println("After sorting :"+ Arrays.toString(arr2));
    }

    static void bubblesort(int[] arr,int size){
        if(size==0){
            return;
        }

        boolean isSwapped=false;

        for(int i=1;i<size;i++) {
            if (arr[i] < arr[i - 1]) {
                int temp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = temp;
                isSwapped=true;
            }
        }

        if(!isSwapped)//if swapping is not done through the loop means array is already sorted
            return;

        bubblesort(arr,size-1);
    }

    // Recursive selection sort. n is size of a[] and index
    // is index of starting element.
    static void SelectionSort(int a[], int n, int index)
    {

        // Return when starting and size are same
        if (index == n)
            return;

        // calling minimum index function for minimum index
        int k = minIndex(a, index, n-1);

        // Swapping when index and minimum index are not same
        if (k != index){
            // swap
            int temp = a[k];
            a[k] = a[index];
            a[index] = temp;
        }
        // Recursively calling selection sort function
        SelectionSort(a, n, index + 1);
    }

    // Return minimum index
    static int minIndex(int a[], int i, int j)
    {
        if (i == j)
            return i;

        // Find minimum of remaining elements
        int k = minIndex(a, i + 1, j);

        // Return minimum of current and remaining.
        return (a[i] < a[k])? i : k;
    }
}
