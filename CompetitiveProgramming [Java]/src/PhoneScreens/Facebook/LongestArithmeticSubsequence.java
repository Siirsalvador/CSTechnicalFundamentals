package PhoneScreens.Facebook;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-27
 */
public class LongestArithmeticSubsequence {

    public int longestArithSeqLength(int[] A) {
        if (A == null || A.length == 0) return 0;

        int max = 2;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                int gap = A[j] - A[i];
                int count = map.getOrDefault(i + ":" + gap, 1) + 1;

                map.put(j + ":" + gap, count);
                max = Math.max(max, count);
            }
        }

        return max;
    }

    public int longestArithSeqLength2(int[] A) {
        if (A == null || A.length == 0) return 0;
        if (A.length < 2) return 1;

        int max = 2;
        Map<Integer, Integer>[] dp = new HashMap[A.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new HashMap<>();
        }

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                int gap = A[i] - A[j];
                int count = dp[j].getOrDefault(gap, 1) + 1;

                dp[i].put(gap, count);
                max = Math.max(max, count);
            }
        }

        return max;
    }
}
