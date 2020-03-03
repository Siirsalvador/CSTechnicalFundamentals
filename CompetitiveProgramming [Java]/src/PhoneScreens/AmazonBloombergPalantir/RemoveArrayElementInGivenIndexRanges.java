package PhoneScreens.AmazonBloombergPalantir;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-19
 */
public class RemoveArrayElementInGivenIndexRanges {

    public static void main(String[] args) {
        int[] arr = {-8, 3, -5, 1, 51, 56, 0, -5, 29, 43, 78, 75, 32, 76, 73, 76};
        int[][] ranges = {{5, 8}, {10, 13}, {3, 6}, {20, 25}};

        System.out.println(Arrays.toString(removeIndexes(arr, ranges)));
    }

    /*
        O(n * m)

        n: size of arr
        m: length of idxs

        NEED TO CONFIRM WHAT I'M BEING ASKED.
     */
    public static int[] removeIndexes(int[] arr, int[][] idxs) {
        if (arr == null || arr.length == 0) return new int[0];
        if (idxs == null || idxs.length == 0 || idxs[0].length == 0) return arr;

        Set<Integer> visited = new HashSet<>();
        for (int[] range : idxs) {
            int start = range[0];
            int end = range[1];
            while (start <= end) {
                visited.add(start++);
            }
        }

        int[] res = new int[arr.length - visited.size()];
        int resIdx = 0;
        int arrIdx = 0;

        while (resIdx < res.length && arrIdx < arr.length) {

            if (visited.contains(arrIdx)) {
                arrIdx++;
                continue;
            }

            res[resIdx] = arr[arrIdx];
            resIdx++;
            arrIdx++;
        }

        return res;
    }
}
