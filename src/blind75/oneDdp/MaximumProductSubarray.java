package blind75.oneDdp;

public class MaximumProductSubarray {
    // Solution 1:
    // Time : O(n^2)
    // Space: O(1)
    public int maxProduct1(int[] nums) {
        int result = nums[0];
        for(int i = 0 ; i < nums.length; i++) {
            int accumulator = 1;
            for (int j = i ; j < nums.length; j++) {
                accumulator *= nums[j];
                result = Math.max(result, accumulator);
            }
        }
        return result;
    }

    // Solution 2: Kadane's Algorithm
    // Time : O(n);
    // Space : O(1)
    public int maxProduct2(int[] nums) {
        int min_so_far = nums[0];
        int max_so_far = nums[0];
        int result = max_so_far;

        for(int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            int temp_max = Math.max(curr, Math.max(max_so_far*curr, min_so_far*curr));
            min_so_far = Math.min(curr, Math.min(min_so_far*curr, max_so_far*curr));
            max_so_far = temp_max;
            result = Math.max(result, max_so_far);
        }
        return result;
    }
}
