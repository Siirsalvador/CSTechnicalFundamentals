package Firecode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-08-27
 */
public class CoupleSum {
    private static int[] coupleSum(int[] numbers, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int number : numbers) {
            list.add(number);
        }

        boolean found = false;
        int firstIdx, secondIdx;
        firstIdx = secondIdx = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (found && numbers[i] == target - numbers[firstIdx]) {
                secondIdx = i;
                break;
            } else if (list.contains(target - numbers[i])) {
                firstIdx = i;
                found = true;
            }
        }

        int[] coupleSum = new int[2];
        coupleSum[0] = firstIdx + 1;
        coupleSum[1] = secondIdx + 1;

        return coupleSum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 7};
        System.out.println(Arrays.toString(coupleSum(arr, 7)));
    }
}
