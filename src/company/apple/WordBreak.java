package company.apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WordBreak {

    public List<String> breakMessage(String message) {
        if(message.isEmpty() || message == null) {
            return null;
        }

        if(message.length() <= 160) {
            return new ArrayList<>(Arrays.asList(message));
        }

        // Split by sentence delimiter (space)
        String words[] = message.split(" ");

        List<String> answer = new ArrayList<>();
        String c_m = "";
        int c_m_num = 1;

        for(String w : words) {
            String n = c_m + " " + w;
            if(n.length() > 154) {
                answer.add(c_m);
                c_m = w;
            } else {
                c_m += w;
            }
        }

        for(int i = 0 ; i < answer.size(); i++) {
            answer.set(i, answer.get(i) + " (" + i + " /" + answer.size() + ")");
        }

        return answer;
    }
}
