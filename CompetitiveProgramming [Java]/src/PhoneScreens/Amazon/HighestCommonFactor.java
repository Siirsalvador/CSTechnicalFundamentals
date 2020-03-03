package PhoneScreens.Amazon;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-04
 */
public class HighestCommonFactor {

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 10};
        System.out.println(generalizedGCD2(5, arr));
    }

    public static int generalizedGCD(int num, int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        int min = Integer.MAX_VALUE;
        for (int value : arr) {
            min = Math.min(value, min);
        }

        int greatestCommonDivisor = 1;
        for (int i = 1; i <= min; i++) {
            int remainder = 0;

            for (int value : arr) {
                remainder = value % i > 0 ? value % i : 0;
            }

            greatestCommonDivisor = remainder == 0 ? i : greatestCommonDivisor;
        }

        return greatestCommonDivisor;
    }

    public static int generalizedGCD2(int num, int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        // WRITE YOUR CODE HERE
        int hcf = arr[0];
        for (int i = 1; i < arr.length; i++) {
            hcf = gcd(hcf, arr[i]);
        }

        return hcf;
    }

    // Why does it work?
    private static int gcd(int a, int b) {
        if (b == 0)
            return a;

        return gcd(b, a % b);
    }

}
