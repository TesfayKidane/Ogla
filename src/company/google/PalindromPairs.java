package company.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromPairs {

    public List<List<Integer>> palindromePairsBruteForce(String[] words) {

        List<List<Integer>> pairs = new ArrayList<>();

        for(int i = 0; i < words.length; i++) {
            for(int j = 0; j < words.length; j++) {
                if(i == j) continue;
                String combined = words[i].concat(words[j]);
                String reversed = new StringBuilder(combined).reverse().toString();
                if(combined.equals(reversed)) {
                    pairs.add(Arrays.asList(i,j));
                }
            }
        }
        return pairs;
    }
}
