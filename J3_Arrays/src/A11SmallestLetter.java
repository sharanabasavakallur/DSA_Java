package J3_Arrays.src;

//https://leetcode.com/problems/find-smallest-letter-greater-than-target/
public class A11SmallestLetter {
    public static void main(String[] args) {
        char[] letters={'c','f','j'};
        char target='j';
        System.out.println("next smallest letter greater than target : "+nextGreaterLetter(letters,target));
    }

    static char nextGreaterLetter(char[] letters,char target){
        //just copy pasting ceiling function..
        int start=0;
        int end=letters.length-1;


        while(start<=end){
            //int mid=(start+end)/2; (start+end) might go beyond int_max
            int mid=start+(end-start)/2;

        /*  if(target==letters[mid]) {
                return mid;
            }*/
            //commented bcz letter that is strictly greater than target should be returned

            if (target < letters[mid]) //then search in left half
                end = mid - 1;

            else
                start = mid + 1;
        }
        return letters[start % letters.length]; // % bcz condition is given that letters wrap around
        //ex:if letters={'a','c','f'} and target='f' then 'a' should returned as output
        //or instead we can add a condition before start of loop that if(target==letters[end]) then return letters[start].
    }
}
