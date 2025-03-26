package J3_Arrays.src;

//https://leetcode.com/problems/peak-index-in-a-mountain-array/
//https://leetcode.com/problems/find-peak-element/
public class A14PeakOfMountain {
    public static void main(String[] args) {
        int[] arr={2,4,5,9,4,2,1,0};
        int peakIndex=peakIndex(arr);
        System.out.println("peak element of given array : "+arr[peakIndex]);
        int target=1;
        int targetIndex=searchMountain(arr,target,peakIndex);
        if(targetIndex!=-1){
            System.out.println("Index of target in given mountain array : "+targetIndex);
        }
        else
            System.out.println("Element not found");
    }

    static int peakIndex(int[] arr){
        int start=0;
        int end=arr.length-1;

        while(start<end){
            int mid=start+(end-start)/2;

            if(arr[mid]>arr[mid+1]){
                //we're in decreasing part(where the elts are in decreasing order) of array i.,e right part of peak index of mountain array
                //so mid could be the index of peak element therefore we should not do end=mid-1
                //by doing so could result in skipping that 'mid' index
                end=mid;
            }
            else{
                //we're in increasing partin(where the elts are increasing order) of array i.,e left part of peak index of mountain array
                //so we should check for further elements for peak index
                start=mid+1;
            }
        }
        //we're out of loop ,after each iteration we are getting close to peak index
        //loop ends when start==end i.,e when both of them are pointing to peak index of array
        //so return either of them
        return start;
    }

    //https://leetcode.com/problems/find-in-mountain-array/description/
    static int searchMountain(int[] arr,int target,int peakIndex){
        //if target is smaller than peakElt then search in left part of peakElt
        int first_try=binary_search(arr,target,0,peakIndex-1);
        if(first_try!=-1){
            return first_try;
        }

        //if not found on first_try check for other half which is right part
        //if target is greater than peakElt then search in right part of peakElt
        return binary_search(arr,target,peakIndex+1,arr.length-1);
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
