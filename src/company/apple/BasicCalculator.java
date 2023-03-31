package company.apple;

import java.util.Stack;

/**
 * Evaluate infix expression : https://leetcode.com/problems/basic-calculator/
 */
public class BasicCalculator {
    public int calculate(String s) {
        Stack<Character> all = new Stack<>();
        char openBrace = '(';
        char closeBrace = ')';

        for(char c : s.toCharArray()) {
            if(c != closeBrace) {
                all.push(c);
            } else {
                while (true) {
                    char pop1 = all.pop();
                    char pop2 = all.pop();
                    char pop3 = all.pop();

                    char r = eval(pop1, pop2, pop3);
                }
            }
        }
        return 1;
    }

    private Character eval(char firstPop,  char sign, char secondPop) {

        if(sign == '+') {
            return (char)(Integer.parseInt(Character.toString(firstPop))
                    + Integer.parseInt(Character.toString(secondPop)));
        } else if (sign == '*') {
            return (char)(Integer.parseInt(Character.toString(firstPop))
                    * Integer.parseInt(Character.toString(secondPop)));
        } else if (sign == '-') {
            return (char)(Integer.parseInt(Character.toString(secondPop))
                    - Integer.parseInt(Character.toString(firstPop)));
        } else if (sign == '/') {
            return (char)(Integer.parseInt(Character.toString(secondPop)) /
                     Integer.parseInt(Character.toString(firstPop)));
        } else {
            return null;
        }
    }
}
