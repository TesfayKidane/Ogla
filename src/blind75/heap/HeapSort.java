package blind75.heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class HeapSort {

    public static int[] ascSort(int[] a) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        //heapify
        for(int i = 0 ; i < a.length; i++) minHeap.add(a[i]);

        for(int i = 0; i < a.length; i++) {
            int n = minHeap.peek();
            a[i] = n;
            minHeap.poll();
        }
        return a;
    }

    public static int[] dscSort(int[] a) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < a.length; i++) maxHeap.add(a[i]);

        for(int i = 0 ; i < a.length; i++) {
            int n = maxHeap.peek();
            a[i] = n;
            maxHeap.poll();
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println("Ascending : " + Arrays.toString(ascSort(new int[] {2, 3, 1, 6, 4, 2})));
        System.out.println("Ascending : " + Arrays.toString(dscSort(new int[] {2, 3, 1, 6, 4, 2})));
    }
}
