package J4_Strings.src;

import java.util.Arrays;

public class S2Sample {
    public static void main(String[] args) {

        String name="Sharan Kallur Hello Hii";
        System.out.println(Arrays.toString(name.toCharArray()));//prints as char-array
        System.out.println(name.toLowerCase());//converts string to lowercase

        System.out.println(name.toUpperCase());//converts string to uppercase

        System.out.println(name.indexOf('K'));//returns index-of 'K;

        //to remove part of string
        System.out.println("  Kallur ".strip());
        System.out.println(Arrays.toString(name.split(" ")));

        //formatted printing
        float a=464.2456235f;
        System.out.printf("rounding of upto 2 digits after decimal point:%.2f \n",a);
        System.out.println(Math.PI);
        System.out.printf("Value of pi:%.3f \n",Math.PI);
        System.out.printf("My first_name is %s and \n second name is %s \n","Sharan","Kallur");


        //'+' operator

        System.out.println('a'+'b');//here a & b are characters and here '+'
        //operator acts as addition operator which adds integer values of a & b
        System.out.println("a"+"b");//here a & b are strings so '+' operator
        //acts as concatenation operator which concatenates a & b i.,e ab
        System.out.println("a"+'z');//coz a is string so concatenation would happen
        System.out.println((char)('a'+3));//firstly 'a'+3 will results in 97+3=100
        //and type casting of char so 100's equivalent character is 'd'
        System.out.println("s"+1);//will results in s1 (concatenation)

//        System.out.println("Sharan" + new Integer(18));
    }
}
