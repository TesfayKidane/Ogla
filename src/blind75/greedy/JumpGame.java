package blind75.greedy;

public class JumpGame {
    // Solution 1: DP (Recursion and Memo)
    // Time : O(n^2)
    // Space : O(n)
    Index[] memo;
    public boolean canJump(int[] nums) {
        memo = new Index[nums.length];
        for(int i = 0; i < nums.length; i++) {
            memo[i] = Index.UNKNOWN;
        }
        memo[memo.length - 1] = Index.GOOD;
        return canJumpRecursion(nums, 0);
    }

    public boolean canJumpRecursion(int[] nums, int startAtI) {
        if(memo[startAtI] != Index.UNKNOWN) {
            return memo[startAtI] == Index.GOOD ? true : false;
        }

        for(int steps = 1; steps <= nums[startAtI]; steps++) {
            if (canJumpRecursion(nums, steps + startAtI)) {
                memo[startAtI] = Index.GOOD;
                return true;
            }
        }

        memo[startAtI] = Index.BAD;
        return false;
    }


    // Solution 2: Greedy
    // Time : O(n)
    // Space: O(1)
    public boolean canJumpGreedy(int[] nums) {
        int goal = nums.length - 1;

        for(int p = goal - 1; p >= 0; p--) {
            if(nums[p] + p == goal) {
                goal--;
            }
        }

        return goal == 0 ? true : false;
    }

}

enum Index {
    GOOD,
    BAD,
    UNKNOWN
}
