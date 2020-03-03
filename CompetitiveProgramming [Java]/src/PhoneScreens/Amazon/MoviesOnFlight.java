package PhoneScreens.Amazon;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-04
 */
public class MoviesOnFlight {
    public static void main(String[] args) {

        int[] duration = {90, 85, 75, 60, 120, 150, 125};
        System.out.println(Arrays.toString(duration));
        int d = 220;

        System.out.println(getHighestMoviesWithinRange(duration, d));
    }

    public static ArrayList<Integer> getHighestMoviesWithinRange(int[] durations, int target) {

        int[] temp = new int[durations.length];
        for (int i = 0; i < durations.length; i++) temp[i] = durations[i];

        Arrays.sort(temp);
        //System.out.println(Arrays.toString(temp));

        int start = 0;
        int end = temp.length - 1;

        int fIdx = 0;
        int sIdx = 0;

        int max = Integer.MIN_VALUE;

        while (start < end) {
            int total = temp[start] + temp[end];

            if (total <= target && total > max) {
                max = Math.max(max, total);
                fIdx = start;
                sIdx = end;
            }

            if (total > target) {
                end--;
            } else if (total < target) {
                start++;
            }
        }

        for (int i = 0; i < durations.length; i++) {
            if (durations[i] == temp[fIdx]) {
                fIdx = i;
                break;
            }
        }

        for (int i = 0; i < durations.length; i++) {
            if (durations[i] == temp[sIdx]) {
                sIdx = i;
                break;
            }
        }

        return new ArrayList<>(Arrays.asList(fIdx, sIdx));
    }
}
