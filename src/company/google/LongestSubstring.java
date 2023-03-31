package company.google;
// a a b c d a e
public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int[] ch = new int[128];
        int l = 0;
        int result = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            ch[c]++;

            // if character is duplicated then slid the window by removing the characters from the left
            while (ch[c] > 1) {
                char cl = s.charAt(l);
                ch[cl]--;
                l++;
            }
            result = Math.max(result, r - l + 1);
        }
        return result;
    }


    public static void main(String[] args) {
        LongestSubstring ls = new LongestSubstring();
        System.out.println(ls.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(ls.lengthOfLongestSubstring("bbbbb"));
        System.out.println(ls.lengthOfLongestSubstring("pwwkew"));
    }
}
