package PhoneScreens.Facebook;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-29
 */
public class SmallestSubtreeWithAllTheDeepestNodes {

    public static void main(String[] args) {
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) return null;
        TreeNode[] maxNode = new TreeNode[1];
        int[] maxLvl = {Integer.MIN_VALUE};

        dfs(root, 0, maxNode, maxLvl);
        return maxNode[0];
    }

    private int dfs(TreeNode node, int level, TreeNode[] maxNode, int[] max) {
        if (node == null)
            return level;

        int leftLvl = dfs(node.left, level + 1, maxNode, max);
        int rightLvl = dfs(node.right, level + 1, maxNode, max);

        if (leftLvl == rightLvl && leftLvl >= max[0]) {
            max[0] = leftLvl;
            maxNode[0] = node;
        }

        return Math.max(leftLvl, rightLvl);
    }
}
