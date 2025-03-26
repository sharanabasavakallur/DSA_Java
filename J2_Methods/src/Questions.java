package J2_Methods.src;

public class Questions {
    //Checking whether given number is prime of not
/*    public static void main(String[] args) {
        System.out.print("Enter a number : ");
        Scanner in=new Scanner(System.in);
        int num=in.nextInt();
        System.out.println(isPrime(num));
    }*/

    //bruteforce approach
/*    static boolean isPrime(int num){
        for(int i=2;i<num;i++){
            if(num%i==0)//if any number between 2 and num divides num then its not prime
                return false;
        }
        //if we're out of loop then num must be prime
        return true;
    }
}*/

    //optimized approach
/*    static boolean isPrime(int num) {
    if(num<=1)
        return false;

    int c=2;
    while(c*c<=num){
        if(num%c==0)
            return false;
        c++;
    }
    return true;
    }
 */


    //Printing all 3 digit armstrong numbers
    public static void main(String[] args) {
        System.out.println("All three digit armstrong numbers : ");
        for(int i=100;i<1000;i++){
            if(isArmstrong(i))
                System.out.print(i+" ");
        }
    }

    static boolean isArmstrong(int num){
        int temp=num,sum=0;
        while(num>0){
            int digit=num%10;
            sum=sum+(digit*digit*digit);
            num=num/10;
        }
    /*  if(sum==temp)
            return true;
        else
            return false;
    */
        //or
        return sum == temp;
    }
}


