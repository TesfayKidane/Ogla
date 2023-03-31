package blind75.arrayAndHashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NestedAnagram {

    public boolean nestedAnagram(String s1, String s2) {
        // base case
        if( s1.length() != s2.length() || s1.isEmpty() || s2.isEmpty()) return false;

        String[] ss1 = s1.split(" ");

        if(ss1.length > 1 || ss1.length > 100) return false;

        Map<String, Integer> hashStore = new HashMap<>();
        for(String s : ss1) {
            String hash1 = generateHash(s);
            hashStore.put(hash1, 0);
        }

        String[] ss2 = s2.split(" ");
        for(String s : ss2) {
            String hash2 = generateHash(s);
            if(!hashStore.containsKey(hash2))
                return false;
        }

        return true;
    }

    private String generateHash(String s) {
        int[] count = new int[26];
        Arrays.fill(count, 0);

        for (char c : s.toCharArray()) {
            int index = c - 'a';
            count[index]++;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < count.length; i++) {
            sb.append("#");
            sb.append(count[i]);
        }

        return sb.toString();
    }
}
