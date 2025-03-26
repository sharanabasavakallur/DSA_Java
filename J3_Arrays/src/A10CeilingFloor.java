package J3_Arrays.src;

import java.util.Arrays;

//this concept arises when target is not found but we want nearby elts of the target
//when target found in the array then no need of ceiling and floor in that case floor==ceiling==target
public class A10CeilingFloor {
    public static void main(String[] args) {
        int[] arr={2,9,11,18,28,35,56,89,100};
        int target=23;
        System.out.println("Given array is : "+ Arrays.toString(arr));

        int ceiling=ceiling(arr,target);//ceiling is smallest elt which is >=target
        //ceiling elt comes just after target(>=target) (if target itselft is last elt of array then it is ceiling elt)
        if(ceiling!=-1)
            System.out.println("Ceiling of "+target+" : "+arr[ceiling]);

        int floor=floor(arr,target);//floor elt comes just before target(<=target) (if target itself is on 0th index then it is floor elt)
        if(floor!=-1)
            System.out.println("Floor of "+target+" : "+arr[floor]);
    }
    static int ceiling(int[] arr,int target){
        int start=0;
        int end=arr.length-1;

        //if target itself is greatest elt of array then return no ceiling found
        if(target>arr[end]){
            System.out.println("The given target itself is greater than the greatest elt of array so no ceiling found");
            return -1;
        }

        while(start<=end){
            //int mid=(start+end)/2; (start+end) might go beyond int_max
            int mid=start+(end-start)/2;

            if(target==arr[mid]) {
                return mid;
            }
            //assuming array is sorted in increasing order
            else if (target < arr[mid]) //then search in left half
                    end = mid - 1;

            else
                    start = mid + 1;
        }
        //after coming out of while loop start would have just crossed end i.e, start>end so start is nearest to target which is >target
        return start;
    }

    static int floor(int[] arr,int target){
        int start=0;
        int end=arr.length-1;

        //if target itself is smallest then return no floor found
        if(target<arr[start]){
            System.out.println("The target elt itself is smaller than the smallest elt of array so no floor found");
            return -1;
        }

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
        //after coming out of while loop start would have just crossed end i.e, start>end so end is nearest to target which is <target
        return end;
    }
}
