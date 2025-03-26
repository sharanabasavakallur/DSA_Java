package J3_Arrays.src;

public class A17Search2DArray {
    public static void main(String[] args) {
        //for unsorted matrix
/*        int[][] arr={{1,2,3,5},
                {3,2,5,9,11},
                        {3,6,3},
                {2,0}};
        int target=10;
        if(normalSearch(arr,target)[0]!=-1){
            System.out.println("target found at row:"+normalSearch(arr,target)[0]+" col:"+normalSearch(arr,target)[1]);
        }
        else
            System.out.println("target not found");*/

        //for sorted matrix
        int[][] matrix={{10,20,30,40},
                {11,21,32,43},
                {13,23,34,45},
                {15,25,36,48}};
        int target=100;

        int[] found=sortedSearch(matrix,target);
        if(found[0]!=-1){
            System.out.println("target found at - [row:"+found[0]+" ,col:"+found[1]+"]");
        }
        else
            System.out.println("target not found");

        System.out.println("no. of iterations : "+found[2]);
    }


//for unsorted matrix (bruteforce approach)
/*    static int[] normalSearch(int[][] arr,int target){
        for(int row=0;row<arr.length;row++){
            for(int col=0;col<arr[row].length;col++){
                if(arr[row][col]==target)
                    return new int[]{row,col};
            }
        }
        return new int[]{-1,-1};
    }*/

    //for sorted matrix
    static int[] sortedSearch(int[][] matrix,int target){
        int rowIndex=0;//first row
        int colIndex=matrix.length-1; //last column,matrix[rowIndex][colIndex]=40 (in given matrix)
        int i=0;//to track no of iterations

        while(rowIndex<matrix.length && colIndex>=0){
            //case1
            if(target==matrix[rowIndex][colIndex]){
                return new int[]{rowIndex,colIndex,i};
            }
            //case2
            else if(target>matrix[rowIndex][colIndex]){
                rowIndex++;
            }
            //case3:if(target<matrix[rowIndex][colIndex]
            else{
                colIndex--;
            }
            i++;
        }

        return new int[]{-1,-1,i};
    }
}
