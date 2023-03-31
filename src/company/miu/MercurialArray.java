package company.miu;

public class MercurialArray {

    public static void main(String[] args) {
        System.out.println(isMercurial(new int[]{1, 2, 10, 3, 15, 1, 2, 2}));
        System.out.println(isMercurial(new int[]{5, 2, 10, 3, 15, 1, 2, 2}));
        System.out.println(isMercurial(new int[]{1, 2, 10, 3, 15, 16, 2, 2}));
        System.out.println(isMercurial(new int[]{3, 2, 18, 1, 0, 3, -11, 1, 3}));
        System.out.println(isMercurial(new int[]{2, 3, 1, 1, 18}));
        System.out.println(isMercurial(new int[]{8, 2, 1, 1, 18, 3, 5}));
        System.out.println(isMercurial(new int[]{3, 3, 3, 3, 3, 3}));
        System.out.println(isMercurial(new int[]{1}));
        System.out.println(isMercurial(new int[]{}));
    }

    static int isMercurial(int[] a) {

        boolean isPrecededByOne = false;

        int position3 = -1;
        int positionOf1 = -1;
        for (int j = 0; j < a.length; j++) {
            if (a[j] == 1)
                positionOf1 = j;

            if (a[j] == 3) {
                position3 = j;
            }

            if (positionOf1 != -1 && position3 > positionOf1)
                isPrecededByOne = true;

            if (isPrecededByOne && a[j] == 1)
                return 0;
        }

        return 1;
    }
}
