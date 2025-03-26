package J2_Methods.src;

import java.util.Arrays;

public class VarArgs {
    public static void main(String[] args) {
        fun(1,2,3,4,5,6,9);
        func(1,2,"abc","def","efg","ghi","Sha");
    }
    static void fun(int ...v){
        System.out.println(Arrays.toString(v));

    }
    static void func(int a,int b,String ...v){//we cant keep varargs in middle becoz no. of args is not defined..
        System.out.println(Arrays.toString(v));
    }
}
