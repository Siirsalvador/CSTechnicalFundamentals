package Firecode;

import java.util.Stack;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-09-10
 */
public class NumberOfHalfNodes {
    public int numberOfHalfNodes(TreeNode root) {
        int count = 0;

        if (root == null) return count;

        Stack<TreeNode> nodes = new Stack<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            TreeNode curr = nodes.pop();

            if (curr.left != null ^ curr.right != null) count++;
            if (curr.left != null) nodes.add(curr.left);
            if (curr.right != null) nodes.add(curr.right);
        }

        return count;
    }
}
