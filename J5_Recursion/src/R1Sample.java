package J5_Recursion.src;

public class R1Sample {
    public static void main(String[] args) {
        //recursion: a function calling itself
        printing(1);
        int n=5;
        System.out.println(n+"th fibonacci number : "+fibo(n));
    }

    static void printing(int n){
        //base condition
        if(n==5){
            return;
        }

        //task done by function
        System.out.println(n);

        //recursive condition
        printing(n+1);
    }

    static int fibo(int n){

        System.out.println("calculating for n="+n);
        //base condition
        if(n<2){//fib(0)=0
            return n;
        }

        //recursive condition
        return fibo(n-1)+fibo(n-2);
    }
}