package blind75.arrayAndHashing;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 0 || nums == null) return false;

        Set<Integer> s = new HashSet<>();

        for (int n : nums) {
            if(s.contains(n)) return true;
            s.add(n);
        }
        return false;
    }
}
