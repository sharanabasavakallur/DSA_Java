package J6_BitWiseOperators.src;
//&(and) operator
//when you &1 with a digit then digit remains same

//~(complement) operator
//~0:1  ~1:0

//^(xor) operator
//high when odd number of high's otherwise low
//ex:0^0:0 0^1:1 1^0:1 1^1:0
//when we do a^1:complement(a) and a^0:a
//a^a:0

/*
Number Systems:->
Decimal=(0,1,2,3,4,5,6,7,8,9)
Binary=(0,1)
Octal=(0,1,2,3,4,5,6,7)
HexaDecimal=(0 to 9,A,B,C,D,E,F)
*/

//<<(left shift) operator
//a<<b : a*2^b

//>>(right shift) operator
//a>>b : a/2^b

public class B1Sample {
    public static void main(String[] args) {
        int n=16;
        System.out.println(isOdd(n));

        System.out.println("the element which isn't repeated is:"+notRepeated(new int[]{1,2,4,1,3,6,3,4,2}));

        System.out.println("binary eqlt of "+n+" is:"+Integer.toBinaryString(n));//predefined function
        System.out.println("binary equivalent of "+n+" is: "+toBinary(n)+"i.e,"+toBinary(n).toString());

        System.out.println("no-of-digits in binary eqlt of "+n+" is:"+no_ofdigits(n));

        System.out.println("Is the number is power of 2:"+is_power2(n));

        int base=-2,power=4;
        System.out.println("power("+base+","+power+")="+apowerb(base,power));
    }

    //checking whether number is odd or even
    //if lsb(least significant bit) of a binary number is 1 then it's odd
    //else it's even
    //reason: 2^x is always even where x>0 and if x=0 it's 1 (2^0 == 1 ) i.,e odd
    //we write lsb in-terms of 2^0 so if it's 1 then (2^0)*1=1 which is odd
    //if it's 0 then (2^0)*0=0 i.,e even
    //and other digits other than lsb will be 2^1,2^2,2^3...
    //sum of 2^a where a>0 will be obviously even
    //1+even=odd  and 0+even=even here 0 and 1 are lsb
    static boolean isOdd(int n){
        return((n&1)==1);//if lsb is 1 then return true else false
    }

    //find the element in the array which is not repeated
    //we can use xor(^) operator coz when we xor same numbers we get 0
    //and 0 xor a is a so that a is not-repeated element of array
    static int notRepeated(int[] arr){
        int that_elt=0;
        for(int i=0;i<arr.length;i++){
            that_elt = that_elt ^ arr[i];
        }
        return(that_elt);
    }

    static int[] toBinary(int n){
        int[] binary=new int[32];
        int i=0;
        while(n>0){
            binary[i]=n%2;
            n=n/2;
            i++;
        }

        //return only non-zero digits
        int[] bin=new int[i];//create new array of length i
        for(int j=i-1,k=0;j>=0;j--,k++){
            bin[k]=binary[j];
        }

        return bin;
    }

    //no_of_digits of a 'binary equivalent of a decimal number N'
    //it is equal to int_part_of(logN-base2)+1
    //this method is applicable for not only binary for any base b
    //change base-2 to base-b
    static int no_ofdigits(int n){
        return((int)(Math.log(n)/Math.log(2))+1);
        //as log-base2 is not available so using log-base10
        //find log_n-base2 i.,e log_n-base10/log_2-base10
    }

    //check a number is power of 2
    //it's binary equivalent has only one set bit
    static boolean is_power2(int n){
        return((n&n-1)==0);
    }

    //find a power b with time complexity:O(b)
    static float apowerb(int base,int power){
        if(base==0)return 0;//0 power anything is 0
        if(power==0)return 1;//anything power 0 is 1

        int a=power;//storing power in var. a coz if power is negative then ans should be 1/base^power

        if(power<0)power=-power;//if power is negative making to positive to calculate base^power

        float ans=1;
        while(power>0){
            ans=ans*base;
            power--;
        }

        if(a>0)return ans;
        else return (1/ans);//if power was negative
    }
}