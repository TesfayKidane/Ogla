package blind75.arrayAndHashing;

import java.util.Arrays;

public class                ValidAnagram {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length() || s == null) return false;

        int[] countS = new int[26];
        int[] countT = new int[26];
        Arrays.fill(countS, 0);
        Arrays.fill(countT, 0);

        for(int i = 0 ; i < s.length(); i++) {
            countS[s.charAt(i) - 'a']++;
            countT[t.charAt(i) - 'a']++;
        }

        for(int i = 0 ; i < 26; i++) {
            if(countS[i] != countT[i]) {
                return false;
            }
        }

        return true;
    }
}
