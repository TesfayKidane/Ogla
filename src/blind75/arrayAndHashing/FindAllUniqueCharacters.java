package blind75.arrayAndHashing;

import java.lang.reflect.Array;
import java.util.Arrays;

public class FindAllUniqueCharacters {
    // Assume s is only lower case english letters
    private static String findAllUniqueCharacters(String s) {
        if(s == null || s.length() == 0) {

        }

        int[] count = new int[128];
        Arrays.fill(count, 0);

        // count char frequency
        for(char c : s.toCharArray()) {
            count[c]++;
        }

        //prepare result
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            if(count[c] == 1) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s1 = "leet[code]";
        System.out.println(s1 + " --- " + findAllUniqueCharacters(s1));

        s1 = "book_exam!";
        System.out.println(s1 + " --- " + findAllUniqueCharacters(s1));

        s1 = "tesfayaregay";
        System.out.println(s1 + " --- " + findAllUniqueCharacters(s1));
    }
}
