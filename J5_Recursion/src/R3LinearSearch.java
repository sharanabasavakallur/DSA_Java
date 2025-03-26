package J5_Recursion.src;

public class R3LinearSearch {
    public static void main(String[] args) {
        int[] arr1={8,2,9,11,15,23,43,20};
        System.out.println("Index of target elt of array:"+search(arr1,0,9));

        int[] arr2={4,5,8,9,10,12,36,29,39};
        System.out.println("Is arr2 sorted? : "+Issorted(arr2,0));
    }
    static int search(int[] arr,int index,int target){
        //base case
        if(index==arr.length){
            return -1;
        }
        if(arr[index]==target){
            return index;
        }

        return search(arr,index+1,target);
    }

    static boolean Issorted(int[] arr,int index){
        //base case
        if(index==arr.length-1){
            return true;
        }

        return arr[index]<=arr[index+1] && Issorted(arr,index+1);
        //using && becoz if first statement is false then there is no checking for second one
        //it is returned as false..
    }
}
