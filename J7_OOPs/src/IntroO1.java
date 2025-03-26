package J7_OOPs.src;

import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class IntroO1 {
    public static void main(String[] args) {
        Student1[] students=new Student1[5];
        //by default(without initializing the object values will be null
        System.out.println(Arrays.toString(students));

        //creating object of class(instantiation)
        Student1 sharan=new Student1();

        //before initialising the value of int variable is 0 ,string is null and float is 0.0
        System.out.println(sharan.roll);
        System.out.println(sharan.name);
        System.out.println(sharan.marks);

        //initialising
        sharan.roll=98;
        sharan.name="Sharanabasava";
        sharan.marks=96.67f;

        System.out.println(sharan.roll);
        System.out.println(sharan.name);
        System.out.println(sharan.marks);




    }
}
class Student1{
    int roll;
    String name;
    float marks;
}