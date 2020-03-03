package Firecode;

import java.util.ArrayList;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-11-19
 */
public class MobileGameRangesModule {
    // java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

    public static ArrayList<Interval> insertRange(ArrayList<Interval> intervalsList, Interval insert) {
        ArrayList<Interval> result = new ArrayList<>();
        if (intervalsList == null || intervalsList.isEmpty()) {
            result.add(insert);
            return result;
        }

        //[[1,2], [3,5], [6,7], [8,10], [12,14]], Interval: [5,9]
        int idx = 0;
        int start = insert.start;
        int end = insert.end;
        while (idx < intervalsList.size()) {
            Interval curr = intervalsList.get(idx);

            if (insert.start > curr.end) {
                result.add(curr);

            } else if (curr.start > insert.end) {
                result.add(new Interval(start, end));
                result.add(curr);

            } else {
                start = Math.max(curr.start, start);
                end = Math.max(curr.end, end);

                if (idx + 1 == intervalsList.size()) {
                    result.add(new Interval(start, end));
                }

            }

            idx++;
        }

        return result;
    }

    static class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
