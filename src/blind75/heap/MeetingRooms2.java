package blind75.heap;

import java.util.*;

public class MeetingRooms2 {

public static int minMeetingRooms(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

    for(int[] interval : intervals) {
        if(!pq.isEmpty() && pq.peek()[1] <= interval[0]) {
            pq.poll();
        }
        pq.add(interval);
    }
    return pq.size();
}

    public static void main(String[] args) {
        int[][] input = {{0,30},{5,10},{15,20}};
        System.out.println(minMeetingRooms(input));
        int[][] input2 = {{7,10},{2,4}};
        System.out.println(minMeetingRooms(input2));
        int[][] input3 = {{5,8},{6,8}};
        System.out.println(minMeetingRooms(input3));
    }
}
