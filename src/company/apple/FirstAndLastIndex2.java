package company.apple;

import java.sql.PreparedStatement;

// using binary search
public class FirstAndLastIndex2 {
    public static int first(int arr[], int x) {
        int low = 0, high = arr.length - 1, res = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (x > arr[mid]) {
                low = mid + 1;
            } else if (x < arr[mid]) {
                high = mid - 1;
            } else { // if x == arr[mid]
                res = mid;
                high = mid - 1;
            }
        }
        return res;
    }

    public static int last(int[] arr, int x) {
        int low = 0, high = arr.length - 1, res = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if(x > arr[mid]) {
                low = mid + 1;
            } else if (x < arr[mid]) {
                high = mid - 1;
            } else { // if x == arr[mid]
                res = mid;
                low = mid + 1;
            }
        }
        return res;
    }
}
