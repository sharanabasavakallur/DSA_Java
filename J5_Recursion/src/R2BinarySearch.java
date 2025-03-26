package J5_Recursion.src;

public class R2BinarySearch {
    public static void main(String[] args) {
        int[] arr={1,2,5,6,33,53,67,79};
        int target=89;
        System.out.println(search(arr,target,0,arr.length-1));
    }

    static int search(int[] arr,int target,int start,int end){
        //base conditon
        if(start>end){
            return -1;
        }

        int mid=start+(end-start)/2;

        if(arr[mid]==target){//if target found
            return mid;
        }

        //recursive calling
        if(target<arr[mid])//if target lies in left of mid
            return search(arr,target,start,mid-1);//return keyword is necessary coz
                                                        //the parent function has return type of int
        else//if target lies in right of mid
            return search(arr,target,mid+1,end);
    }
}
