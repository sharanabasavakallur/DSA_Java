package J3_Arrays.src;

//https://leetcode.com/problems/find-the-duplicate-number/
public class A24FindDuplicate {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,2};
        int repeated=duplicate(arr);
        System.out.println("repeated elt of array : "+repeated);

    }

    static int duplicate(int[] arr) {
        //just copy-pasting cyclic sort
        int i=0;

        while(i<arr.length) {

            if (arr[i] != i + 1) { //if arr[2] is not 3 then go for swapping thing else simply go for next elt i., i++
                //initialise correctIndex for arr[i] that is arr[i]-1
                //for ex: correct index of 3 would be 2.
                int correctIndex = arr[i]-1;
                if (arr[i] != arr[correctIndex]) { //if some other elt is there in place of arr[i] then swap
                    swap(arr, i, correctIndex);
                }
                else //arr[i] is a duplicate i.,e it has appeared before
                     //coz if it's not duplicate then we would not have been here in this if condition
                    return arr[i];
            }
            else
                i++;
        }

        //if no duplicates found
        return -1;
    }

    static void swap(int[] arr,int first,int second){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
}


