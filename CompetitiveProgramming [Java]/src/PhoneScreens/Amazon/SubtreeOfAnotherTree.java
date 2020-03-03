package PhoneScreens.Amazon;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-10
 */
public class SubtreeOfAnotherTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(2);

        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(2);

        System.out.println(isSubtreeRecursive(root, root2));
    }

    public static boolean isSubtreeRecursive(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;

        return doSubtreesMatch(s, t) || isSubtreeRecursive(s.left, t) || isSubtreeRecursive(s.right, t);
    }

    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null) return false;

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(s);

        while (!nodes.isEmpty()) {
            TreeNode curr = nodes.poll();

            if (curr.val == t.val && doSubtreesMatch(curr, t)) {
                return true;
            }

            if (curr.left != null) nodes.offer(curr.left);
            if (curr.right != null) nodes.offer(curr.right);
        }

        return false;
    }

    private static boolean doSubtreesMatch(TreeNode curr, TreeNode t) {
        if (curr == null && t == null) return true;
        if (curr == null || t == null) return false;

        return curr.val == t.val && doSubtreesMatch(curr.left, t.left)
                && doSubtreesMatch(curr.right, t.right);

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
