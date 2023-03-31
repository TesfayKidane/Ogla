package blind75.binarysearch;

public class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        int leftIndex = 0;
        int rightIndex = nums.length;
        int minIndex = 0;

        while (leftIndex <= rightIndex) {
            int midIndex = (leftIndex + rightIndex) / 2;

            if (nums[midIndex] == target) return midIndex;

            // if left is sorted
            if (nums[leftIndex] <= nums[midIndex]) {
                if (target < nums[leftIndex] || target > nums[midIndex]) {
                    leftIndex = midIndex + 1;
                } else {
                    rightIndex = midIndex - 1;
                }
            } else {
                if (target < nums[midIndex + 1] || target > nums[rightIndex]) {
                    rightIndex = midIndex - 1;
                } else {
                    leftIndex = midIndex + 1;
                }
            }
        }
        return -1;
    }
}
