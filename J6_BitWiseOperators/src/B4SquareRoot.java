package J6_BitWiseOperators.src;

public class B4SquareRoot {
    //using binary_search
    public static void main(String[] args) {
        System.out.println(Root(89));
    }

    static double Root(int n){
        int s=0,e=n;
        double root=0.0;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(mid*mid==n)
                return mid;
            else if(mid*mid>n)
                e=mid-1;
            else {
                root=mid;//storing mid thinking if loop ends after this then return mid at this position
                s = mid + 1;
            }
        }

        //if n is a perfect square then it'd not reach this line
        //then mid is returned at line 15
        //if n is not perfect square then root will have value of floor(real root of n)
        //then we add more precision to it
        int prec=2;
        double incr_factor=1;
        for(int i=0;i<prec;i++){
            incr_factor=incr_factor/10;
            while(root*root<=n){
                root=root+incr_factor;
            }

        }
        return root;
    }
}
