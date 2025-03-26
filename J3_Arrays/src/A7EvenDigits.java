package J3_Arrays.src;

//https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
public class A7EvenDigits {
    public static void main(String[] args) {
        int[] nums={23,4,142,1298,0,-12,-1234,-45};
        System.out.println("numbers with even number of digits:");
        for(int i=0;i<nums.length;i++){
            if((no_of_digits(nums[i]))%2==0)
                System.out.print(nums[i]+" ");
        }

    }

    static int no_of_digits(int num){
        if(num<0)
            num=num*-1; //converting negative to positive
        if(num==0 || num==-0)
            return 1;
        int count=0;
        while(num>0){
            count++;
            num=num/10;
        }
        return count;
    }
}
