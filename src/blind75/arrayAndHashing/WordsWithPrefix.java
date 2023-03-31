package blind75.arrayAndHashing;

public class WordsWithPrefix {
    public int prefixCount(String[] words, String pref) {
        int count = 0 ;
        for(String s : words) {
            if(s.startsWith(pref)) {
                count++;
            }
        }
        return count;
    }
}
