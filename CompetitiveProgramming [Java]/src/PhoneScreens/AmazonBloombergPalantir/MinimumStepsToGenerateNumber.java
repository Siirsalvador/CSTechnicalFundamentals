package PhoneScreens.AmazonBloombergPalantir;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-03-03
 */
public class MinimumStepsToGenerateNumber {

    public static void main(String[] args) {
        System.out.println(minSteps(10));
    }

    public static int minSteps(int target) {

        int min = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            if (curr[0] == target) {
                min = curr[1];
                return min;
            }


            queue.offer(new int[]{curr[0] * 2, curr[1] + 1});
            queue.offer(new int[]{curr[0] / 3, curr[1] + 1});
        }

        return -1;
    }
}
