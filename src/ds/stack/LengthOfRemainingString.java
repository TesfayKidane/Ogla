package ds.stack;

import java.util.Stack;

public class LengthOfRemainingString {

    public int lengthOfString(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c1 : s.toCharArray()) {
            if(stack.isEmpty()) {
                stack.push(c1);
            } else {
                char c2 = stack.peek();
                if((c1 == '0' && c2 == '1') || (c1 == '1' && c2 == '0')) {
                    stack.pop();
                } else {
                    stack.push(c1);
                }
            }
        }
        return stack.size();
    }
}
