package blind75.backtracking;

import java.lang.reflect.Array;
import java.util.*;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        LinkedList<Integer> comb = new LinkedList<>();
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < candidates.length; i++) {
            if(!list.contains(candidates[i])) {
                list.add(candidates[i]);
            }
        }

        int[] filteredC = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            filteredC[i] = list.get(i);
        }

        dfs(filteredC, target, 0, comb, results);
        return results;
    }

    private void dfs(int[] candidates, int remain, int start, LinkedList<Integer> comb, List<List<Integer>> results) {
        if(remain == 0) {
            // keep a deep compy of comb, and add it to the final list
            results.add(new ArrayList<>(comb));
            return;
        }
        if(remain < 0) {
            // sum has exceeded the target;
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (!comb.contains(candidates[i])) {
                comb.add(candidates[i]);
                dfs(candidates, remain - candidates[i], i, comb, results);
                comb.removeLast();
            }
        }
    }

}
