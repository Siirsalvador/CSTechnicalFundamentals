package PhoneScreens.Facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-02-16
 */
public class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> ans = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < A.length && j < B.length) {

            int lo = Math.max(A[i][0], B[j][0]);
            int hi = Math.min(A[i][1], B[j][1]);

            if (lo <= hi)
                ans.add(new int[]{lo, hi});

            if (A[i][1] < B[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
