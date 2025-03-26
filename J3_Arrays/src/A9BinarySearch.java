package J3_Arrays.src;

//for binary search array must be sorted..
public class A9BinarySearch {
    public static void main(String[] args) {
        int[] arr={2,9,11,18,28,35,56,89,100};
        int target=80;
        if(binary_search(arr,target)){
            System.out.println("Element found..");
        }
        else
            System.out.println("Element not found..");

    }

    static boolean binary_search(int[] arr,int target){
        int start=0;
        int end=arr.length-1;

        //check whether array sorted in ascending order of descending
        boolean isAsc=arr[start]<arr[end];

        while(start<=end){//if the condition is start<end then last elt (exaclty one elt left to check) would miss..
            //when start==end the mid is start(or end) and you need to check that elt against target

            //int mid=(start+end)/2; (start+end) might go beyond int_max
            int mid=start+(end-start)/2;


            if(target==arr[mid]) {
                return true;
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
        return false;
    }
}
