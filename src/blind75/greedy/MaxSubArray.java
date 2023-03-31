package blind75.greedy;

public class MaxSubArray {

    // Solution 1: Brute Force
    // Time : O(n^2)
    // Space: O(1)
    public int maxSumOfSubArray(int[] nums) {
        int result = nums[0];
        for(int i = 0 ; i < nums.length; i++) {
            int sum = 0;
            for(int j = i; j < nums.length; j++) {
                sum += nums[j];
                result = Math.max(sum, result);
            }
        }
        return result;
    }

    // Solution 2: Kadane's Algorithm
    // Time : O(n)
    // Space: O(1)

    public int maxSumOfSubArray2(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

        int max_so_far = nums[0];
        int min_so_far = nums[0];
        int result = max_so_far;

        for(int i = 1 ; i < nums.length; i++) {
            int curr = nums[i];
            int temp_max = Math.max(curr, Math.max(max_so_far+curr, min_so_far+curr));
            min_so_far = Math.min(curr, Math.max(max_so_far+curr, min_so_far+curr ));
            max_so_far = temp_max;
            result = Math.max(max_so_far, result);
        }
        return result;
    }
}
