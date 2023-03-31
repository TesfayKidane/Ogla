package blind75.oneDdp;

public class LongestPalindromSubstring {


    // O(n^2)
    public String longestPalindrome(String s) {

        if(s.length() < 2) return s;

        String result = "";
        int resultLength = 0;

        for (int i = 0; i < s.length(); i++) {
            //odd length [abcdcba]
            int l = i;
            int r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if ((r - l + 1) > resultLength) {
                    result = s.substring(l, r + 1);
                    resultLength = r - l + 1;
                }

                l--;
                r++;
            }

            // even length
            l = i;
            r = i + 1;

            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if((r - l + 1) > resultLength) {
                    result = s.substring(l, r + 1);
                    resultLength = r - l + 1;
                }
                l--;
                r++;
            }
        }
        return result;
    }
}
