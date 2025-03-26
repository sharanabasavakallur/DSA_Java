package J3_Arrays.src;

public class A15SearchInString {
    public static void main(String[] args) {
        String name="Sharanabasava";
        char target='a';
        if(search(name,target)!=-1)
            System.out.println("target found at index : "+search(name,target));
    }

    static int search(String str,char target){
        if(str.isEmpty()) {//str.length()==0 can also be used
            System.out.println("Empty string..");
            return -1;
        }

/*        for(int i=0;i<str.length();i++){
            if(target==str.charAt(i)){//str[i] will not work
                return i;
            }
        }*/

        //for_each loop
        int i=0;
        for(char ch:str.toCharArray()){
            i++;
            if(ch==target)
                return i;
        }

        //if target not found
        System.out.println("target not found..");
        return -1;
    }
}
