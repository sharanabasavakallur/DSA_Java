package J3_Arrays.src;

public class A3LinearSearch {
    public static void main(String[] args) {
        int[] nums={23,45,12,5,17,-3,-11,20};
        //int[] nums={};//empty array
        int target=20;
        /*
        * if u want to search from index1 to index2
        * then pass those index as parameters of function
        * and run loop from index1 to till index2*/
        int ans=Linear_search(nums,target);
        if(ans!=-1)
            System.out.println("Element found at index : "+ans);

    }

    static int Linear_search(int[] arr,int target){
        if(arr.length==0) {
            System.out.println("Empty array...");
            return -1;
        }

        for(int index=0;index<arr.length;index++){
            if(arr[index]==target) {
                return index;
            }
        }
        //if there is no such element
        System.out.println("Element not found..");
        return -1;
    }
}
