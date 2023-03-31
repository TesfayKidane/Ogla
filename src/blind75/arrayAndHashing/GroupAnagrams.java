package blind75.arrayAndHashing;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        // base case
        if(strs.length == 0) return new ArrayList<>();
        if(strs == null) return null;

        Map<String, List<String>> hashStore = new HashMap<>();

        for(String s : strs) {
            String hash = generateHash(s);
            if(hashStore.containsKey(hash)) {
                List<String> l = hashStore.get(hash);
                l.add(s);
                hashStore.put(hash, l);
            } else {
                List<String> l1 = new ArrayList<>();
                l1.add(s);
                hashStore.put(hash, l1);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String, List<String>> m : hashStore.entrySet()) {
            result.add(m.getValue());
        }

        return result;
    }

    private String generateHash(String s) {
        int[] count = new int[26];
        Arrays.fill(count, 0);

        for(char c : s.toCharArray())
            count[c - 'a']++;

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < count.length; i++) {
            sb.append("#");
            sb.append(count[i]);
        }
        return sb.toString();
    }
}
