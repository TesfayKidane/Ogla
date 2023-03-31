package blind75.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElement2 {
    public int[] topKFrequent(int[] nums, int k) {
        // base case
        if(k == nums.length) {
            return nums;
        }

        // create frequency map
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0)  + 1);
        }

        // create heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>( (n1, n2) -> freqMap.get(n1) - freqMap.get(n2));

        for(int n : freqMap.keySet()) {
            minHeap.add(n);

            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }

        //create return array
        int[] result = new int[k];
        for(int i = k - 1; i >=0 ; i--) {
            result[i] = minHeap.poll();
        }

        return result;
    }
}
