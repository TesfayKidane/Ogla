package company.miu;

import java.util.HashMap;

public class Test1 {
    public static void main(String[] args) {
        System.out.println(isStepped(new int[]{1, 1, 1, 5, 5, 5, 5, 8, 8, 8}));
        System.out.println(isStepped(new int[]{1, 1, 5, 5, 5, 5, 8, 8, 8}));
        System.out.println(isStepped(new int[]{5, 5, 5, 15}));
        System.out.println(isStepped(new int[]{3, 3, 3, 2, 2, 2, 5, 5, 5}));
        System.out.println(isStepped(new int[]{3, 3, 3, 2, 2, 2, 1, 1, 1}));
        System.out.println(isStepped(new int[]{1, 1, 1}));
        System.out.println(isStepped(new int[]{1, 1, 1, 1, 1, 1, 1}));
    }

    static int isStepped2(int[] a) {
        int ans = 1;
        for (int i = 0; i < a.length; ) {
            int j = i;
            int count = 0;
            while (j < a.length) {
                if (a[i] == a[j]) {
                    j++;
                    count++;
                } else if (a[i] > a[j]) {
                    ans = 0;
                    return ans;
                } else {
                    break;
                }
            }
            if (j == i) {
                j++;
            }
            if (count < 3) {
                ans = 0;
                break;
            }
            i = j;
        }
        return ans;
    }

    static int isStepped1(int[] a) {
        int result = 1;
        for (int i = 0; i < a.length; ) {
            int count = 0;
            for (int j = i; j < a.length;) {
                if (a[i] == a[j]) {
                    j++;
                    count++;
                } else if (a[i] > a[j]) {
                    result = 0;
                    return result;
                } else {
                    break;
                }
            }
            if (count < 3) {
                result = 0;
                break;
            }
            i = i + count;
        }
        return result;
    }

    static int isStepped(int[] a) {
        HashMap<Integer, Integer> valueCount = new HashMap<>();
        for(int i = 0 ; i < a.length; i++) {
            if (i > 0 && a[i] < a[i - 1]) {
                return 0;
            }
            int count = valueCount.getOrDefault(a[i], 0) + 1;
            valueCount.put(a[i], count);
        }

       for (Integer j : valueCount.values()) {
           if(j < 3) {
               return 0;
           }
       }

       return 1;
    }
}
