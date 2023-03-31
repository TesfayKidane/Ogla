package blind75.heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElement {

    // construct MaxHeap;
    // add element to the MaxHeap;
    // pop() / poll() K times from MaxHeap.
    // The element which popoed at K times is the Kth Largest element.
    public static int getKthLargestElementMaxHeap(int[] a, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0 ; i < a.length; i++)
        {
            maxHeap.add(a[i]);
        }
        int answer = maxHeap.peek();

       for(int i = 1; i <= k; i++) {
           answer = maxHeap.peek();
           maxHeap.poll();
       }

       return answer;
    }

    public static int getKthLargestElementMinHeap(int[] a, int k) {
        // construct blind75.heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // heapify
        for( int n : a) {
            minHeap.add(n);

            // remove the n - k smallest elements. (this will make sure k largest elements are kept.
            if(minHeap.size() > k)
                minHeap.poll();
        }

        return minHeap.peek();
    }

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
        System.out.println("Ascending : " + Arrays.toString(dscSort(new int[] {2, 3, 1, 6, 4, 2})));
        System.out.println("Ascending : " + getKthLargestElementMaxHeap(new int[] {2, 3, 1, 6, 4, 2}, 3));
        System.out.println("Ascending : " + getKthLargestElementMinHeap(new int[] {2, 3, 1, 6, 4, 2}, 3));
    }
}
