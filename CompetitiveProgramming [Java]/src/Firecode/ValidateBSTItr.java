package Firecode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-09-08
 */
public class ValidateBSTItr {

    public static boolean validateBSTItr(TreeNode root) {
        if (root == null) return true;

        Queue<BoundaryNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(new BoundaryNode(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

        while (!nodeQueue.isEmpty()) {
            BoundaryNode curr = nodeQueue.poll();

            if (curr.node.data < curr.leftData || curr.node.data > curr.rightData) return false;

            if (curr.node.left != null)
                nodeQueue.add(new BoundaryNode(curr.node.left, curr.leftData, curr.node.data));

            if (curr.node.right != null)
                nodeQueue.add(new BoundaryNode(curr.node.right, curr.node.data, curr.rightData));
        }

        return true;
    }

    static class BoundaryNode {
        TreeNode node;
        int leftData;
        int rightData;

        public BoundaryNode(TreeNode node, int leftData, int rightData) {
            this.node = node;
            this.leftData = leftData;
            this.rightData = rightData;
        }
    }

    public static void main(String[] args) {

    }


}

