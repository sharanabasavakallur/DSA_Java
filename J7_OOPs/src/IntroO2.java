package J7_OOPs.src;

public class IntroO2 {
    public static void main(String[] args) {
        Student me=new Student();
        me.greetings();
        System.out.println(me.name);
        System.out.println(me.roll);
        System.out.println(me.marks);

        Student me1=new Student("Ankur",110,99.99f);
        System.out.println(me1.name);
        System.out.println(me1.roll);
        System.out.println(me1.marks);
    }
}
class Student{
    int roll;
    String name;
    float marks;

    void greetings(){
        System.out.println("Hello, this is "+this.name);
    }

    //constructor
    Student(){
        this.roll=98;
        this.name="Sharan Kallur";
        this.marks=86.83f;
    }

    //same constructor with parameters
    Student(String name,int usn,float mark){
        this.name=name;//using this coz parameter and class variable is same
        roll=usn;
        marks=mark;//not using this coz parameter and class variable is not same
    }
}
