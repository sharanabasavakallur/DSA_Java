package J6_BitWiseOperators.src;

public class B2CheckPrime {
    public static void main(String[] args) {
        int n=30;
/*        for(int i=0;i<n;i++){
            System.out.println(i+" : "+" "+prime_1(i));
        }*/
        sieve(n);
    }

    //1_brute-force approach (running loop 2 to n-1)
/*    static String prime_1(int n){
        //base case
        if(n<=1)
            return("Not Prime");

        for(int i=2;i<n;i++){
            if(n%i==0)
                return("Not Prime");
        }
        return("Prime");
    }*/

    //better approach (running loop <=n/2 times)
    //wkt all divisors of a number N occurs in pairs of(a,b) such that a*b=N
    //for ex.12 has following-divisors
    //pairs are : (1,12),(2,6),(3,4) is same as
    //            (12,1),(6,2),(4,3) so run loop up-to n/2

/*    static String prime_1(int n){
        //base case
        if(n<=1)
            return("Not Prime");

        for(int i=2;i<=n/2;i++){
            if(n%i==0)
                return("Not Prime");
        }
        return("Prime");
    }*/

    //optimized approach (running loop <=sqrt(N) times)
    //for a divisor pair(a,b) one of them lies below sqrt(N) and other lies above sqrt(N)
    //Proof:there would be 3 possible cases
    //case 1:both a and b are below sqrt(N)
    //case 2:both a and b are above sqrt(N)
    //case 3:one is below sqrt(N), and other is above sqrt(N)
    //so we have to prove that first 2 cases are incorrect

    //case 1:Let's assume that this statement is true, hence
    //a<sqrt(N)   b<sqrt(N)
    //but then a*b<N   (multiply lhs and rhs)
    //which contradicts the fact that a*b=N
    //hence ,case 1 is not true

    //case 2:can be proved not true in same way as that of case 1

    //case 3:wkt if a pair (a,b) then a*b=N i.,e a=N/b i.,e a=sqrt(N)*sqrt(N)/b ---eq1
    //      sub-case 1: b < sqrt(N) =>  1 < sqrt(N)/b
    //      so eq1 becomes a=sqrt(N)*(1+x)    ,since sqrt(N)/b is greater than 1
    //Hence a > sqrt(N)
    //      sub-case 2: b > sqrt(N) => 1 > sqrt(N)/b
    //      so eq1 becomes a=sqrt(N)*(1-x)    ,since sqrt(N)/b is less than 1
    //Hence a < sqrt(N)
/*    static String prime_1(int n){
        //base case
        if(n<=1)
            return("Not Prime");

        for(int i=2;i*i<=n;i++){
            if(n%i==0)
                return("Not Prime");
        }
        return("Prime");
    }*/

    //sieve of eratosthenes

    static void sieve(int n){
        boolean[] notPrimes=new boolean[n+1];
        //by default all values of array : false
        for(int i=2;i*i<=n;i++){
            if(!notPrimes[i]){
                for(int j=i*2;j<=n;j=j+i){
                    notPrimes[j]=true;//mark them as non-prime
                }
            }
        }

        for(int i=2;i<=n;i++){
            if(!notPrimes[i])
                System.out.print(i+" ");
        }
    }
    
}
