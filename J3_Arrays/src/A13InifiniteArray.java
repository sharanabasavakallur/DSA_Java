package J3_Arrays.src;

//https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
public class A13InifiniteArray {
    public static void main(String[] args) {
        int[] arr={1,3,5,9,11,18,22,26,30,36,45,58,60,67,79,81,99,120};
        int target=81;
        System.out.println("index of target : "+ans(arr,target));
    }
    //if infinite array is given then we cant use arr.length variable
    static int ans(int[] arr,int target){
        //initially lets take first two elements indices as start and end
        int start=0,end=1;

        while(arr[end]<target){//to have search space i.e target should be between start and end
            int newStart=end+1;
            //end will pushed as to double search space as compared to previous
            //so end=previous_end + size_of_previous_search_space*2; //search space can be found by (end-start).
            //we double the search space each time as to keep time complexity log(n) same as binary_search
            end=end+(end-start)*2;
            start=newStart; //bcz newStart cant be used outside of loop
        }
        //if we came out of loop means target is found <=arr[end] i.e target is in the range of (newStart,end)
        //so now we can apply binary search
        return binary_search(arr,target,start,end);
    }

    static int binary_search(int[] arr,int target,int start,int end){
        //just copy paste binary_search code

        while(start<=end){
            //int mid=(start+end)/2; (start+end) might go beyond int_max
            int mid=start+(end-start)/2;

            if(target==arr[mid]) {
                return mid;
            }

            else if (target < arr[mid]) //then search in left half
                end = mid - 1;

            else
                start = mid + 1;
        }
        return -1;
    }
}



