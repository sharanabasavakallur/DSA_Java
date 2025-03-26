package J3_Arrays.src;

import java.util.ArrayList;
import java.util.Scanner;

public class A2ArrayListExamples {
    public static void main(String[] args) {
        //syntax of arraylist
        ArrayList<Integer> list=new ArrayList<>(10);

        //we can add as many elements as we want into list
        list.add(10);
        list.add(20);
        list.add(18);
        list.add(200);
        list.add(14);

        System.out.println("printing list: "+list);//printing whole list
        System.out.println("whether the list contains 200 :"+list.contains(200));//checks whether list contains 200 or not
        list.set(0,11);//11 is set as 0th index elt
        System.out.println("after setting 0th index as 11: "+list);
        list.remove(2);//elt at 2nd index is removed
        System.out.println("after removing elt at index 2: "+list);

        //taking input using loop
        Scanner in=new Scanner(System.in);
        System.out.println("Enter five more elements");
        for(int i=4;i<9;i++){
            list.add(in.nextInt());//list[i] will not work
        }

        for(int i=0;i<9;i++){
            System.out.print(list.get(i)+" ");//list[i] will not work
        }
        System.out.println();


        //2d arraylist
        ArrayList<ArrayList<Integer>> list2=new ArrayList<>();

        //initialization
        for(int i=0;i<3;i++){
            list2.add(new ArrayList<>());
        }

        //add elements
        System.out.println("Enter 9 elements");
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                list2.get(i).add(in.nextInt());
            }
        }
        //printing
        System.out.println(list2);
    }

}
