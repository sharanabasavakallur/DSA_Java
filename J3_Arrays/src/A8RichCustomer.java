package J3_Arrays.src;

//https://leetcode.com/problems/richest-customer-wealth/
public class A8RichCustomer {
    public static void main(String[] args) {
        int[][] accounts={
                {2,8,7},
                {7,1,3},
                {1,9,5}};

        System.out.println(maxWealth(accounts));
    }

    static int maxWealth(int[][] accounts){
        //here person=row , account=col
        int maxSum=0;
        for(int person=0;person<accounts.length;person++){

            int rowSum=0;
            for(int account=0;account<accounts[person].length;account++){
                rowSum=rowSum+accounts[person][account];
            }

            if(rowSum>maxSum)
                maxSum=rowSum;

        }
        return maxSum;
    }
}
