package blind75.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumI {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<Integer> comb = new LinkedList<>();
        List<List<Integer>> results = new ArrayList<>();
        dfs(candidates, target, 0, comb, results);
        return results;
    }

    private void dfs(int[] candidates, int remain, int start, LinkedList<Integer> comb, List<List<Integer>> results) {
        if(remain == 0) {
            // make a deep copy of comb and add it to final list
            results.add(new ArrayList<>(comb));
            return;
        }
        if (remain < 0 || start >= candidates.length) {
            // sum exceeded the target || index out of bound
            return;
        }

        for(int i =  start; i < candidates.length; i++ ) {
            comb.add(candidates[i]);
            dfs(candidates, remain - candidates[i], i, comb, results);
            comb.removeLast();
        }
    }
}
