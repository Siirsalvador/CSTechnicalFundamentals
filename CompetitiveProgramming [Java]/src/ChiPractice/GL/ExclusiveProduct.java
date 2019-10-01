package ChiPractice.GL;

import java.util.Arrays;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-08-14
 */
public class ExclusiveProduct {

    /**
     * There is an array A[N] of N numbers.
     * <p>
     * You have to compose an array Output[N] such that
     * Output[i] will be equal to multiplication of all the elements of A[N] except A[i].
     * <p>
     * For example Output[0] will be multiplication of A[1] to A[N-1]
     * and Output[1] will be multiplication of A[0] and from A[2] to A[N-1].
     * <p>
     * Solve it without division operator and in O(n).
     */

    private static int[] findExclusiveProduct(int[] array) {
        int len = array.length;
        int[] fromLeft = new int[len];
        int[] fromRight = new int[len];

        fromLeft[0] = array[0];
        for (int i = 1; i < len; i++) {
            fromLeft[i] = array[i] * fromLeft[i - 1];
        }

        fromRight[len - 1] = array[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            fromRight[i] = array[i] * fromRight[i + 1];
        }

        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            if (i == 0)
                result[i] = fromRight[1];
            else if (i == len - 1)
                result[i] = fromLeft[len - 2];
            else {
                result[i] = fromLeft[i - 1] * fromRight[i + 1];
            }
        }

        return result;
    }

    private static int[] findExclusiveProductLean(int[] input) {
        int n = input.length;
        int[] result = new int[n];
        Arrays.fill(result, 1);

        int left = 1;
        int right = 1;

        // {3, 4, 5, 2, 6};
        for (int i = 0; i < n; i++) {
            result[i] *= left;
            result[n - 1 - i] *= right;
            left *= input[i];
            right *= input[n - 1 - i];
        }

        return result;
    }


    public static void main(String[] args) {

        int[] nums = {3, 4, 5, 2, 6};
        //fromLeft = {3, 12,
        //{240, 180, 144, 360, 120}
        System.out.println(Arrays.toString(findExclusiveProduct(nums)));
    }


}
