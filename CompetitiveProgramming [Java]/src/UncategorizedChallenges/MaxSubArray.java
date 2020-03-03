package UncategorizedChallenges;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-12-03
 */
public class MaxSubArray {

    public static void main(String[] args) {
        int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Maximum contiguous sum is " +
                maxSubArraySum(a));
    }

    private static int maxSubArraySum(int[] intArr) {

        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;
        System.out.println("Max So Far: " + max_so_far);
        System.out.println("Max Ending: " + max_ending_here);
        System.out.println("==============================");

        for (int value : intArr) {

            max_ending_here = max_ending_here + value;
            max_so_far = Math.max(max_so_far, max_ending_here);

            if (max_ending_here < 0)
                max_ending_here = 0;

            System.out.println("Max So Far: " + max_so_far);
            System.out.println("Max Ending: " + max_ending_here);
            System.out.println("==============================");
        }

        return max_so_far;
    }
}
