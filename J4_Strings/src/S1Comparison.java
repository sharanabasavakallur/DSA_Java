package J4_Strings.src;

public class S1Comparison {
    public static void main(String[] args) {
        String a="Sharan";
        String b="Sharan";
        //after above lines
        //two variables pointing to same object(no 2 different objects)
        //in string pool of heap memory
        System.out.println(a==b);//will give you 'true' coz both a & b are pointing to same object
        //if you want to check similarity of values of a and b then use (.equals()) method
        System.out.println(a.equals(b));//will also give 'true'

        //what if one wants to create 2 different objects with same value
        //use new keyword but the objects created in heap memory but not in
        //string pool of heap memory
        String x=new String("Kallur");
        String y=new String("Kallur");
        System.out.println(x==y);//will give you 'false' both x and y
        //pointing to 2 different objects
        System.out.println(x.equals(y));//will give you 'true' coz both
        //objects pointed by x & y have same value


    }
}