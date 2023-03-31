package blind75.oneDdp;

public class PalindromicSubstrings {

    // Brut force: O(n^2) to produce all substrings and O(n) to check a substring is palindromic.
    public int countSubstrings(String s) {
        if(s.length() < 2) s.length();
        int palindromicCounter = 0 ;
        for(int i = 0 ; i < s.length(); i++){
            // odd length
            palindromicCounter += expandFromCenter(s, i, i) +
                    expandFromCenter(s, i, i + 1);
        }
        return palindromicCounter;
    }

    public int expandFromCenter(String s, int l, int r) {
        int counter = 0;
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            counter++;
            l--;
            r++;
        }
        return counter;
    }
}
