package blind75.oneDdp;

import java.util.Arrays;

/**
 213. House Robber II - Medium

 You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed.
 All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one.
 Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two
 adjacent houses were broken into on the same night.

 Given an integer array nums representing the amount of money of each house, return the maximum amount of money you
 can rob tonight without alerting the police.

 Example 1:

 Input: nums = [2,3,2]
 Output: 3
 Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
 Example 2:

 Input: nums = [1,2,3,1]
 Output: 4
 Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 Total amount you can rob = 1 + 3 = 4.
 Example 3:

 Input: nums = [1,2,3]
 Output: 3
 */
public class HouseRobberII {

    // Optimal Solution using swap and max.
    //input [1,2,3,4,5] = Max.max([1,2,3,4], [2,3,4,5]);
    public int rob(int[] nums) {
        return Math.max(nums[0],
                        Math.max(
                        houseRobberI(Arrays.copyOfRange(nums, 0, nums.length-1)),
                        houseRobberI(Arrays.copyOfRange(nums, 1, nums.length))));
    }

    public int houseRobberI(int[] nums) {
        int rob1 = 0;
        int rob2 = 0;

        for(int n : nums) {
            int newRob = Math.max(rob1 + n, rob2);
            rob1 = rob2;
            rob2 = newRob;
        }

        return rob2;
    }

    // Using dp results with better speed on leetcode although both approachs are o(n)
    public int houseRobberIDP(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }

        return dp[nums.length -1];
    }
}
