package PhoneScreens.AmazonBloombergPalantir;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-12-24
 */
public class MinimumTimeDifference {

    public static void main(String[] args) {
        List<String> t = new ArrayList<>();
        t.add("23:59");
        t.add("00:00");
//        t.add("12:12");
//        t.add("00:13");

        System.out.println(findMinDifference(t));
    }

    public static int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < timePoints.size(); i++) {
            int currTime = convertToTime(timePoints.get(i));
            int prevTime = convertToTime(timePoints.get(i - 1));

            min = Math.min(currTime - prevTime, min);
            if(min == 0) return 0;

        }

        String firstPoint = timePoints.get(0);
        String lastPoint = timePoints.get(timePoints.size() - 1);
        return Math.min(1440 - convertToTime(lastPoint) + convertToTime(firstPoint), min);
    }

    private static int convertToTime(String s) {
        String[] points = s.split(":");
        return (Integer.parseInt(points[0]) * 60) + Integer.parseInt(points[1]);
    }


}

