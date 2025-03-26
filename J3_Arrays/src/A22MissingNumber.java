package J3_Arrays.src;

//https://leetcode.com/problems/missing-number/
public class A22MissingNumber {
    public static void main(String[] args) {
        int[] arr={3,0,1};
        System.out.println("the missing elt of array : "+missingNumber(arr));

    }

    static int missingNumber(int[] arr) {
        //just copy pasting cyclic sort
        int i=0;

        while(i<arr.length){
            //initialise correctIndex for arr[i] that is arr[i]
            //for ex: correct index of 3 would be 3 and 0 would be 0.
            int correctIndex=arr[i];
            if(arr[i]<arr.length && arr[i]!=arr[correctIndex]){ //if some other elt is there in place of arr[i] then swap
                swap(arr,i,correctIndex);
            }
            else //else means elt arr[i] is at correct index so simply check for next elt
                i++;
        }

        //after above loop all elts sorted from 0 to n
        //so we search the elt missing return its index
        //case1 (for elts less than arr.length
        for(int index=0;index<arr.length;index++){
            if(arr[index]!=index)
                return index;
        }

        //if we're out of above loop them all elt <arr.length are sorted so return arr.length
        //case2

        return arr.length;
    }

    static void swap(int[] arr,int first,int second){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
}
