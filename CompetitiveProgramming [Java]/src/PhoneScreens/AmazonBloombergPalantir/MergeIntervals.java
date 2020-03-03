package PhoneScreens.AmazonBloombergPalantir;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-12-24
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {

        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
            return new int[0][0];
        }

        //Sort intervals
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                int c = a[0] - b[0];
                return c == 0 ? a[1] - b[1] : c;
            }
        });

        ArrayList<int[]> res = new ArrayList<>();
        //Merge overlaps
        int start = -1;
        int end = -1;
        int idx = 0;

        while (idx < intervals.length) {
            if (intervals[idx][0] <= end) {
                end = Math.max(intervals[idx][1], end);
            } else {
                //Assuming every number is NonNegative
                if (start != -1 && end != -1)
                    res.add(new int[]{start, end});

                start = intervals[idx][0];
                end = intervals[idx][1];
            }

            if (idx + 1 == intervals.length) {
                res.add(new int[]{start, end});
            }

            idx++;
        }


        int[][] result = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }

        return result;
    }
}
