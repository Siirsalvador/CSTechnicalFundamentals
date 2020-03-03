package PhoneScreens.Facebook;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-02-16
 */
public class DiameterOfABinaryTree {

    static int diameter;

    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        diameter = 0;
        depth(root);
        return diameter;
    }

    private static int depth(TreeNode root) {
        if (root == null) return 0;

        int left = depth(root.left);
        int right = depth(root.right);

        int currDiameter = left + right;
        diameter = Math.max(diameter, currDiameter);

        return 1 + Math.max(left, right);
    }


    public int diameterOfBinaryTree2(TreeNode root) {
        if (root == null) return 0;

        int lHei = height(root.left);
        int rHei = height(root.right);
        int lDiam = diameterOfBinaryTree2(root.left);
        int rDiam = diameterOfBinaryTree2(root.right);

        return Math.max(lHei + rHei, Math.max(lDiam, rDiam));
    }

    private int height(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }


}
