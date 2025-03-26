package J5_Recursion.src;

public class R6NoOfPaths {
    public static void main(String[] args) {
        System.out.println(paths(3,3));
    }
    //refer notes
    static int paths(int row,int col){
        //base case
        if(row==1 || col==1){
            return 1;
        }

        int left=paths(row-1,col);
        int right=paths(row,col-1);

        return left+right;
    }
}
