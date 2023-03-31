package blind75.arrayAndHashing;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        //O(1)
        if(nums.length == k) return nums;

        //O(N) build frequency map
        Map<Integer, Integer> count = new HashMap<>();
        for(int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        //O(1) Create Min Heap (the minimum frequency comes on the top of the heap)
        Queue<Integer> heap = new PriorityQueue<>(
                (n1, n2) -> count.get(n1) - count.get(n2)
        );

        //O(K Log n) heapiffy, and only keep the top K frequent elements on the heap,
        // by polling the less frequent elements everytime heap size goes above k.
        for(int n : nums) {
            heap.add(n);
            if(heap.size() > k) {
                heap.poll();
            }
        }

        // O(K) copy from the heap to num and return;
        int[] result = new int[k];
        for(int i = k - 1;  i >= 0; --i) {
            result[i] = heap.poll();
        }
        return result;
    }
}
