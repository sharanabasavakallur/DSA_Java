package J6_BitWiseOperators.src;

public class B5GCD_LCM {
    public static void main(String[] args) {
        System.out.println(gcd(98,56));
    }

    //naive approach
    //The basic idea is to find the minimum of the two numbers and
    // find its highest factor which is also a factor of the other number.
/*    static int gcd(int a,int b){
        int result=Math.min(a,b);
        while(result>0){
            if(a%result==0 && b%result==0)
                break;
            result--;
        }
        return result;
    }
*/
    //euclidean approach
    static int gcd(int a, int b)
    {
        // Everything divides 0
        if (a == 0)
            return b;
        if (b == 0)
            return a;

        // Base case
        if (a == b)
            return a;

        // a is greater
        if (a > b) {
            if (a % b == 0)
                return b;
            return gcd(a - b, b);
        }
        if (b % a == 0)
            return a;
        return gcd(a, b - a);
    }
    //optimized approach
    /*static int gcd(int a,int b){
        return b==0 ? a : gcd(b,a%b);
    }*/
}
//lcm=a*b/gcd(a,b)
