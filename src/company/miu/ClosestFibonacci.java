package company.miu;

public class ClosestFibonacci {

    public static void main(String[] args) {
        System.out.println(closestFibonacci(12));
        System.out.println(closestFibonacci(33));
        System.out.println(closestFibonacci(34));
    }

    static int closestFibonacci(int n) {
        int result = 0;
        int[] fibonacci = new int[n];
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        for (int i = 2; i <= n; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
            if (fibonacci[i] > n) {
                break;
            }
            result = fibonacci[i];
        }
        return result;
    }
}
