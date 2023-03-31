package blind75.arrayAndHashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> diffMap = new HashMap<>();
        for(int i = 0 ; i < nums.length; i++) {
            int diff = target - nums[i];
            if (diffMap.containsKey(diff)) {
                return new int[]{i, diffMap.get(diff)};
            }
            diffMap.put(nums[i], i);
        }
        return new int[2];
    }
}
