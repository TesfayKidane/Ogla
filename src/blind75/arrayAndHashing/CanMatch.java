package blind75.arrayAndHashing;
import java.util.*;

/*
You are provided two integer arrays.

You are allowed to swap one element with another element anywhere in one of the arrays.
You can swap one time only and only in one of the arrays.

After the swap, if the two arrays have the same order, return true.

If they don't, return false.

You can test your logic by clicking Run.
*/

class CanMatch {
    public static boolean canMatch(int[] a, int[] b) {
        if(a.length != b.length) return false;

        List<Integer> list = new ArrayList<>();
        // happy case
        for(int i = 0; i < a.length; i++) {
            if(a[i] != b[i]) {
                list.add(i);
            }

            if (list.size() > 2) {
                return false;
            }
        }

        if(list.isEmpty()) return true;

        // swap
        int index1 = list.get(0);
        int index2 = list.get(1);

        // re canMatch

        if(a[index1] != b[index2] ||
                a[index2] != b[index1]) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {

        int[] a1 = {1, 2, 3};
        int[] b1 = {1, 2, 3};
        boolean response = canMatch(a1, b1);
        System.out.println("a1: " + Arrays.toString(a1));
        System.out.println("b1: " + Arrays.toString(b1));
        System.out.println("expected: true, response: " + response);

        int[] a2 = {1, 2, 3};
        int[] b2 = {2, 1, 3};
        response = canMatch(a2, b2);
        System.out.println("a2: " + Arrays.toString(a2));
        System.out.println("b2: " + Arrays.toString(b2));
        System.out.println("expected: true, response: " + response);

        int[] a3 = {1, 2, 2};
        int[] b3 = {2, 1, 1};
        response = canMatch(a3, b3);
        System.out.println("a3: " + Arrays.toString(a3));
        System.out.println("b3: " + Arrays.toString(b3));
        System.out.println("expected: false, response: " + response);

        int[] a4 = {1, 2, 1, 2};
        int[] b4 = {2, 2, 1, 1};
        response = canMatch(a4, b4);
        System.out.println("a4: " + Arrays.toString(a4));
        System.out.println("b4: " + Arrays.toString(b4));
        System.out.println("expected: true, response: " + response);

        int[] a5 = {1, 2, 1, 2, 2, 1};
        int[] b5 = {2, 2, 1, 1, 2, 1};
        response = canMatch(a5, b5);
        System.out.println("a5: " + Arrays.toString(a5));
        System.out.println("b5: " + Arrays.toString(b5));
        System.out.println("expected: true, response: " + response);

        int[] a6 = {1, 1, 4};
        int[] b6 = {1, 2, 3};
        response = canMatch(a6, b6);
        System.out.println("a6: " + Arrays.toString(a6));
        System.out.println("b6: " + Arrays.toString(b6));
        System.out.println("expected: false, response: " + response);

        int[] a7 = {1, 2, 3};
        int[] b7 = {1, 10, 2};
        response = canMatch(a7, b7);
        System.out.println("a7: " + Arrays.toString(a7));
        System.out.println("b7: " + Arrays.toString(b7));
        System.out.println("expected: false, response: " + response);

        int[] a8 = {2, 3, 1};
        int[] b8 = {1, 3, 2};
        response = canMatch(a8, b8);
        System.out.println("a8: " + Arrays.toString(a8));
        System.out.println("b8: " + Arrays.toString(b8));
        System.out.println("expected: true, response: " + response);

        int[] a9 = {2, 3, 9};
        int[] b9 = {10, 3, 2};
        response = canMatch(a9, b9);
        System.out.println("a9: " + Arrays.toString(a9));
        System.out.println("b9: " + Arrays.toString(b9));
        System.out.println("expected: false, response: " + response);

        int[] a10 = {832, 998, 148, 570, 533, 561, 894, 147, 455, 279};
        int[] b10 = {832, 570, 148, 998, 533, 561, 455, 147, 894, 279};
        response = canMatch(a10, b10);
        System.out.println("a10: " + Arrays.toString(a10));
        System.out.println("b10: " + Arrays.toString(b10));
        System.out.println("expected: false, response: " + response);

        int[] a11 = {2, 1};
        int[] b11 = {1, 2};
        response = canMatch(a11, b11);
        System.out.println("a11: " + Arrays.toString(a11));
        System.out.println("b11: " + Arrays.toString(b11));
        System.out.println("expected: true, response: " + response);

        int[] a12 = {1, 2, 3, 4};
        int[] b12 = {1, 2, 3};
        response = canMatch(a12, b12);
        System.out.println("a12: " + Arrays.toString(a12));
        System.out.println("b12: " + Arrays.toString(b12));
        System.out.println("expected: false, response: " + response);
    }
}

