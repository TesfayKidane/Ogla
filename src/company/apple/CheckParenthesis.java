package company.apple;

public class CheckParenthesis {
    boolean checkParenthesis(String s) {
        int count1 = 0;
        for(int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                count1++;
            } else if (s.charAt(i) == ')') {
                if (count1 > 0) {
                    count1--;
                } else return false;
            }
        }
        return count1 == 0;
    }
}
