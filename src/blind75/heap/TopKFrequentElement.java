/**
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * k is in the range [1, the number of unique elements in the array].
 * It is guaranteed that the answer is unique.
 */
package blind75.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElement {

    public int[] topKFrequent(int[] nums, int k) {

        // O(n) build frequency hashmap
        HashMap<Integer, Integer> frequency = new HashMap<>();
        for(int i = 0 ; i < nums.length; i++) {
            frequency.put(nums[i], frequency.getOrDefault(nums[i], 0) + 1);
        }

        // construct min blind75.heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(frequency::get));

        //PriorityQueue<Map.Entry<Integer, Integer>> minHeap2 = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        //PriorityQueue<Integer>> minHeap2 = new PriorityQueue<>((n1, n2) -> frequency.get(n1) - frequency.get(n2));

        for(Map.Entry<Integer, Integer> m : frequency.entrySet()) {
            minHeap.add(m.getKey());
            if(minHeap.size() > k)
                minHeap.poll();
        }

        int[] answer = new int[k];
        for(int i = k - 1 ; i >= 0; i--) {
            answer[i] = minHeap.peek();
            minHeap.poll();
        }
        return answer;
    }

    public static void main(String[] args) {

    }
}
