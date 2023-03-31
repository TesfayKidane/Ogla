package blind75.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
    // Use max heap for the first half of the input array
    PriorityQueue<Integer> firstPart_maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    // Use min heap for the second half of the input array
    PriorityQueue<Integer> secondPart_minHeap = new PriorityQueue<>();

    public void addNum(int n) {
        firstPart_maxHeap.add(n);
        secondPart_minHeap.add(firstPart_maxHeap.poll());
        if(secondPart_minHeap.size() > firstPart_maxHeap.size()) {
            firstPart_maxHeap.add(secondPart_minHeap.poll());
        }
    }

    public double findMedian() {
        if(secondPart_minHeap.size() == firstPart_maxHeap.size())
            return (double)(secondPart_minHeap.peek() + firstPart_maxHeap.peek()) * 0.5;
        else
            return (double) firstPart_maxHeap.peek();
    }

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(4);
        mf.addNum(2);
        mf.addNum(7);
        mf.addNum(3);
        mf.addNum(5);
        mf.findMedian();
    }
}
