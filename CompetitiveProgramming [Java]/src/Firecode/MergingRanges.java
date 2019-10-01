package Firecode;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-09-09
 */
public class MergingRanges {

    public static ArrayList<Interval> mergeIntervals(ArrayList<Interval> intervalsList) {

        if (intervalsList.size() < 2) return intervalsList;

        intervalsList.sort(new CompareStart());

        ArrayList<Interval> finalList = new ArrayList<>();
        for (int i = 0; i < intervalsList.size(); i++) {

            int currStart = intervalsList.get(i).start;
            int currEnd = intervalsList.get(i).end;

            while (i + 1 < intervalsList.size() && intervalsList.get(i + 1).start <= currEnd) {
                currEnd = intervalsList.get(i + 1).end;
                i++;
            }

            finalList.add(new Interval(currStart, currEnd));
        }

        return finalList;
    }

    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(0, 1));
        intervals.add(new Interval(0, 1));
        intervals.add(new Interval(0, 1));
        intervals.add(new Interval(0, 0));

        //[[0,1], [0,1], [0,1], [0,0]]

        System.out.println(mergeIntervals(intervals));
    }

    static class CompareStart implements Comparator<Interval> {
        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start - o2.start == 0 ? o1.end - o2.end : o1.start - o2.start;
        }
    }

    static class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
