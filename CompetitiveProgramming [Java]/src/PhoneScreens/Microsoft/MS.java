package PhoneScreens.Microsoft;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-10
 */
public class MS {

    public static void main(String[] args) {
        System.out.println(findMinBets2(18, 2));
    }

    public static int solution2(int target, int maxAllIns) {

        Queue<int[]> chips = new LinkedList<>();
        chips.add(new int[]{1, 0, 0});

        // idx 0 : curr chips
        // idx 1 : curr all ins
        // idx 2 : curr level / number of steps

        while (!chips.isEmpty()) {
            int[] curr = chips.poll();

            if (curr[0] == target) return curr[2];

            chips.offer(new int[]{curr[0] + 1, curr[1], curr[2] + 1});

            if (curr[1] != maxAllIns && curr[0] * 2 <= target) {
                chips.offer(new int[]{curr[0] * 2, curr[1] + 1, curr[2] + 1});
            }

        }

        return 0;
    }

    public static int findMinBets2(int N, int K) {
        int res = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, K});

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {

                int[] info = q.poll();

                assert info != null;
                int current = info[0];
                int allIns = info[1];

                if (current == N) return res;


                if (current > N) continue;

                q.offer(new int[]{current + 1, allIns});
                if (allIns > 0) {
                    q.offer(new int[]{current * 2, allIns - 1});
                }
            }

            res++;

            if (q.size() == 1) {
                return res + N - q.peek()[0];
            }
        }

        return 0;
    }

    public int solution(int target, int maxAllIns) {

        Queue<int[]> chips = new LinkedList<>();
        chips.add(new int[]{1, 0, 0});

        while (!chips.isEmpty()) {
            int[] curr = chips.poll();

            if (curr[0] == target) return curr[2];
            chips.offer(new int[]{curr[0] + 1, curr[1], curr[2] + 1});

            if (curr[1] != maxAllIns && curr[0] * 2 <= target) {
                curr[0] = curr[0] * 2;
                curr[1] = curr[1] + 1;
                curr[2] = curr[2] + 1;
                chips.offer(curr);
            }

        }

        return 0;
    }

}


