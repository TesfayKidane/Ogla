package company.apple;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

    PriorityQueue<Integer> fhMaxHeap;
    PriorityQueue<Integer> shMinHeap;
    public MedianFinder() {
        fhMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
        shMinHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        fhMaxHeap.add(num);
        shMinHeap.add(fhMaxHeap.poll());

        if(shMinHeap.size() > fhMaxHeap.size()) {
            fhMaxHeap.add(shMinHeap.poll());
        }

    }

    public double findMedian() {
        if (fhMaxHeap.size() == shMinHeap.size()) {
            return (fhMaxHeap.peek() + shMinHeap.peek()) / 2;
        }
        else {
            return fhMaxHeap.peek();
        }
    }
}
