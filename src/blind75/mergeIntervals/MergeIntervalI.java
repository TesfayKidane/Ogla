package blind75.mergeIntervals;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MergeIntervalI {
    class Interval {
        int start;
        int end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public boolean canAttendMeetings(List<Interval> intervalList) {
        if(intervalList.size() <= 1) return true;

        Collections.sort(intervalList, (a, b) -> a.start - b.start);

        for(int i = 1; i < intervalList.size(); i++) {
            if(intervalList.get(i - 1).end > intervalList.get(i).start) {
                return false;
            }
        }
        return true;
    }

}
