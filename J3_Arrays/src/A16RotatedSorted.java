package J3_Arrays.src;

//https://leetcode.com/problems/search-in-rotated-sorted-array/
//https://www.geeksforgeeks.org/find-rotation-count-rotated-sorted-array/
public class A16RotatedSorted {
    public static void main(String[] args) {
        int[] arr={4,5,6,8,11,0,2,3};
        System.out.println("pivot at index : "+findPivot(arr));
        int target=2;
        System.out.println("no. of rotations : "+(findPivot(arr)+1));
        if(findPivot(arr)==-1){
            //then array is not rotated so appy simple binarysearch
            System.out.println("Target is at index : "+binary_search(arr,target,0,arr.length-1));
        }
        System.out.println("Target is at index : "+search(arr,findPivot(arr),target));
     }

     static int search(int[] arr,int pivotIndex,int target){
        if(target==arr[pivotIndex]){
            return pivotIndex;
        }
        //case2
         else if(target>=arr[0]){//then target is left part of pivot
             return binary_search(arr,target,0,pivotIndex-1);
        }
         //case3
         else
             return binary_search(arr,target,pivotIndex+1,arr.length-1);
     }
     static int findPivot(int[] arr){
        //pivot is that elt from which largest of array
        int start=0;
        int end=arr.length-1;

        while(start<=end){
            int mid=start+(end-start)/2;

            //case1
            if(mid<end && arr[mid]>arr[mid+1]){///mid<end bcz if mid=end then mid+1 would be IndexOut_ofBound error
                return mid;
            }
            else if(mid>start && arr[mid]<arr[mid-1]){//if mid=0 then mid-1 will raise error
                return mid-1;
            }
            else if(arr[mid]<=arr[start]){//then left part of mid will be less then arr[start]
                //pivot present in the left part of mid
                end=mid-1;
            }
            else //if arr[mid]>arr[start] then pivot present in the right part of mid
                start=mid+1;
        }
        return -1; //if pivot not found
     }

    static int binary_search(int[] arr,int target,int start,int end){

        //check whether array sorted in ascending order of descending
        boolean isAsc=arr[start]<arr[end];

        while(start<=end){

            //int mid=(start+end)/2; (start+end) might go beyond int_max
            int mid=start+(end-start)/2;


            if(target==arr[mid]) {
                return mid;
            }

            if(isAsc) {
                if (target < arr[mid]) //then search in left half
                    end = mid - 1;

                else
                    start = mid + 1;
            }
            else{
                if (target > arr[mid]) //then search in left half
                    end = mid - 1;

                else
                    start = mid + 1;
            }

        }
        return -1;
    }
}
