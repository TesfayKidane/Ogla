package company.apple;

import java.util.List;

public class FirstAndLastIndex {
    public static int first(List<Integer> list, int x) {
        return list.indexOf(x);
    }

    public static int last(List<Integer> list, int x) {
        return list.lastIndexOf(x);
    }
}
