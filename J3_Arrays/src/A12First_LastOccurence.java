package J3_Arrays.src;

//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
public class A12First_LastOccurence {
    public static void main(String[] args) {
        int[] arr={2,5,7,7,7,9,11,20};
        int target=7;

        int first=searchRange(arr,target,true);
        int last=searchRange(arr,target,false);
        System.out.println("first occurrence at index: "+first);
        System.out.println("last occurrence at index: "+last);
    }

    //brute force approach for this can be
    //run two loops for first & last occurrence
    //for first occurrence start from left(0th index of array) and if target found return it as first_occurrence
    //for last occurrence start from right of array (from last index) and if target found return it as last_occurrence
    static int searchRange(int[] arr,int target,boolean firstOccurrence){
        //just copy paste binary_search code
        int start=0;
        int end=arr.length-1;
        int ans=-1; //if target not found then return -1 i.e ans

        while(start<=end){
            //int mid=(start+end)/2; (start+end) might go beyond int_max
            int mid=start+(end-start)/2;

            if(target==arr[mid]) {
                ans=mid;//store mid in ans and..
                if(firstOccurrence){//if u're searching for first occurrence then look for it
                    end=mid-1; //in left part of array else..
                }
                else{
                    start=mid+1;//look for it in right part of array
                }
            }

            else if (target < arr[mid]) //then search in left half
                end = mid - 1;

            else
                start = mid + 1;
        }
        return ans;
    }
}
