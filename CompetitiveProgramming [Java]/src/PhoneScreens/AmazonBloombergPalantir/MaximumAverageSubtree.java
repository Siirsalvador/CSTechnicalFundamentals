package PhoneScreens.AmazonBloombergPalantir;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-19
 */
public class MaximumAverageSubtree {
    public double maximumAverageSubtree(TreeNode root) {
        double[] maxAverage = {0};
        findMaxAverage(root, maxAverage);
        return maxAverage[0];
    }

    private int[] findMaxAverage(TreeNode root, double[] maxAverage) {
        if (root == null) return new int[]{0, 0};

        int[] leftChildAvg = findMaxAverage(root.left, maxAverage);
        int[] rightChildAvg = findMaxAverage(root.right, maxAverage);

        if (leftChildAvg[0] == 0 && rightChildAvg[0] == 0) {
            maxAverage[0] = Math.max(maxAverage[0], root.val / 1);
            return new int[]{1, root.val};
        }

        int[] currentAvg = {leftChildAvg[0] + rightChildAvg[0] + 1, leftChildAvg[1] + rightChildAvg[1] + root.val};
        maxAverage[0] = Math.max(maxAverage[0], (double) currentAvg[1] / (double) currentAvg[0]);

        return currentAvg;
    }
}
