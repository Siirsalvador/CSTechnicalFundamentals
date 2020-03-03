package PhoneScreens.AmazonBloombergPalantir;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-12-18
 */
public class MergeRanges {

    public static void main(String[] args){
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(2, 3));
        intervals.add(new Interval(5, 10));
        intervals.add(new Interval(9, 14));

        System.out.println(new MergeRanges().mergeRanges(intervals));
    }

    private ArrayList<Interval> mergeRanges(ArrayList<Interval> intervals) {

        ArrayList<Interval> res = new ArrayList<>();
        Collections.sort(intervals);

        int currIdx = 1;
        int start = intervals.get(0).getStart();
        int stop = intervals.get(0).getStop();

        while (currIdx < intervals.size()) {

            int currStart = intervals.get(currIdx).getStart();
            int currStop = intervals.get(currIdx).getStop();

            if (currStart <= stop) {
                stop = currStop;

                if(currIdx + 1 ==  intervals.size()){
                    res.add(new Interval(start, stop));
                }

            } else {
                res.add(new Interval(start, stop));
                start = currStart;
                stop = currStop;
            }



            currIdx++;
        }

        return res;
    }


}

class Interval implements Comparable<Interval> {
    private int start;
    private int stop;

    public Interval(int start, int stop) {
        this.start = start;
        this.stop = stop;
    }

    public int getStart() {
        return start;
    }

    public int getStop() {
        return stop;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", stop=" + stop +
                '}';
    }

    //Ascending order. This is first.
    @Override
    public int compareTo(Interval o) {
        int res = this.start - o.start;
        return res == 0 ? this.stop - o.stop : res;
    }
}
