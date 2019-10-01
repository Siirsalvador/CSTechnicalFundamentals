package Firecode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-09-23
 */
public class MinTreeDepth {

    public int minTreeDepthRec(TreeNode root) {
        if (root == null) return 0;
        int firstMin = 1 + minTreeDepthRec(root.left);
        int secMin = 1 + minTreeDepthRec(root.right);
        return firstMin < secMin ? firstMin : secMin;
    }

    /*
              1
             / \
            2   3
           / \
          4   5
    */

    public int minTreeDepth(TreeNode root) {
        if (root == null) return 0;

        int depth = 1;

        Queue<TreeNode> currLevel = new LinkedList<>(); //2, 3
        Queue<TreeNode> nextLevel = new LinkedList<>();

        currLevel.add(root);

        while (!currLevel.isEmpty()) {
            TreeNode node = currLevel.poll(); //1
            if (node.left == null && node.right == null) return depth;
            if (node.left != null) nextLevel.add(node.left);
            if (node.right != null) nextLevel.add(node.right);
            if (currLevel.isEmpty()) {
                currLevel = nextLevel;
                nextLevel = new LinkedList<>();
                depth++; //2
            }
        }

        return depth;
    }
}
