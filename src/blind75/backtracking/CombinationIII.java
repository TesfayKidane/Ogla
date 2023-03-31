package blind75.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationIII {

    public List<List<Integer>> combinationSum3(int k, int target) {
       LinkedList<Integer> comb = new LinkedList<>();
       List<List<Integer>> result = new ArrayList<>();
       if(k > target) return result;
       int[] candidates = new int[target];
       for(int i = 1; i <= target; i++) {
           candidates[i] = i;
       }
       dfs(candidates, target, 0, comb, result);
       return result;
    }

    private void dfs(int[] candidates, int remain, int start, LinkedList<Integer> comb, List<List<Integer>> results) {
        if(remain == 0) {
            results.add(new ArrayList<>(comb));
            return;
        }

        for(int i = start; i < candidates.length; i++) {
            if(candidates[i] < 0 || candidates[i] > 9 ||  (i > start && candidates[i] == candidates[i - 1])) {
                continue;
            }
            if(remain - candidates[i] < 0) {
                break;
            }

            comb.add(candidates[i]);
            dfs(candidates, remain - candidates[i], i + 1, comb, results);
            comb.removeLast();
        }
    }
}
