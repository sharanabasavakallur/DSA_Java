package J3_Arrays.src;

public class A5Search2D {
    public static void main(String[] args) {
        int[][] nums={
                {21,3,5,8},
                {5,2,9,10},
                {6,2,8},
                {12,21,33,87,21}
                };
        int target=21;

        int[] ans1=Linear_search1(nums,target);//for first occurrence only
        if(ans1[0]!=-1)
            System.out.println("Element found at row:"+ans1[0]+",col:"+ans1[1]);

        System.out.println();
        Linear_search2(nums,target);//for multiple occurrences
    }

    static int[] Linear_search1(int[][] arr,int target){
        if(arr.length==0) {
            System.out.println("Empty array...");
            return new int[]{-1,-1};
        }

       for(int row=0;row<arr.length;row++){
           for(int col=0;col<arr[row].length;col++){
               if(target==arr[row][col])
                   return new int[]{row+1,col+1};
           }
       }

        //if there is no such element
        System.out.println("Element not found..");
        return new int[]{-1,-1};
    }

    static void Linear_search2(int[][] arr,int target){
        if(arr.length==0) {
            System.out.println("Empty array...");
        }

        boolean found=false;
        for(int row=0;row<arr.length;row++){
            for(int col=0;col<arr[row].length;col++){
                if(target==arr[row][col]){
                    found=true;
                    System.out.println("Element found at row:"+(row+1)+",col:"+(col+1));
                }
            }
        }

        //if there is no such element
        if(!found)
            System.out.println("Element not found..");
    }
}