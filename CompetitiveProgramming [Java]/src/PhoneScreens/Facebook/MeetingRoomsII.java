package PhoneScreens.Facebook;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-02-16
 */
public class MeetingRoomsII {

    public static void main(String[] args) {
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(minMeetingRooms(intervals));
    }

    public static int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        if (intervals.length == 1) return 1;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0] == 0 ? a[1] - b[1] : a[0] - b[0]);
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        int rooms = 0;
        for (int i = 0; i < intervals.length; i++) {

            int cStart = intervals[i][0];
            if (queue.isEmpty() || cStart < queue.peek()[1]) {
                queue.offer(intervals[i]);
                rooms++;
            } else {
                queue.poll();
                queue.offer(intervals[i]);
            }
        }

        return rooms;
    }
}
