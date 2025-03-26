package J3_Arrays.src;

import java.util.Arrays;

public class A18BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        bubble(arr);
        System.out.println("After sorting : "+ Arrays.toString(arr));

    }

    static void bubble(int[] arr) {
        boolean isSwapped;//to check if swapping occurred
        for (int counter = 0; counter < arr.length-1; counter++) {//run (n-1) times coz last elt get sorted itself
            isSwapped=false;
            for (int i = 1; i < arr.length - counter; i++) {//each time the highest number is sorted at rightmost end
                if (arr[i] < arr[i - 1]) {
                    //swap
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                    isSwapped=true;
                }
            }
            //for any value of counter if isSwapped remains false then it implies array is sorted already
            if(!isSwapped)//if isSwapped==false
                break;//get out of loop
        }
    }
}
