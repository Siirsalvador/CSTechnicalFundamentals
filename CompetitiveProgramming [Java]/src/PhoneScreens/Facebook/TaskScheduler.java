package PhoneScreens.Facebook;

import java.util.*;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-02-12
 */
public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        int[] taskCounts = new int[26];
        for (char t : tasks) {
            taskCounts[t - 'A']++;
        }

        Queue<Integer> taskQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int t : taskCounts) {
            if (t > 0) taskQueue.offer(t);
        }

        int time = 0;
        while (!taskQueue.isEmpty()) {
            int intervalCheck = 0;
            List<Integer> temp = new ArrayList<>();

            while (intervalCheck <= n) {
                if (!taskQueue.isEmpty()) {
                    Integer top = taskQueue.poll();
                    if (top > 1) temp.add(top - 1);
                }

                time++;
                intervalCheck++;

                if (taskQueue.isEmpty() && temp.isEmpty()) break;
            }

            for (Integer tmp : temp) {
                taskQueue.offer(tmp);
            }
        }

        return time;
    }

    public int leastInterval2(char[] tasks, int n) {
        if (tasks.length == 0) return 0;

        int[] taskCount = new int[26];
        for (char t : tasks) {
            taskCount[t - 'A']++;
        }

        Arrays.sort(taskCount);
        int maxVal = taskCount[25] - 1;
        int idleSlots = maxVal * n;

        for (int i = 24; i >= 0; i--) {
            idleSlots -= Math.min(taskCount[i], maxVal);
        }

        return idleSlots > 0 ? idleSlots + tasks.length : tasks.length;
    }
}
