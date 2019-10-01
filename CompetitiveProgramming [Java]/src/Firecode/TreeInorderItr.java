package Firecode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-09-10
 */
public class TreeInorderItr {

    // keep going left until null
    // pop stack add that guy to list (check for right node too)
    /*
        Push current node & go to left child. Do this till left child = null
        Have a break condition
        Pop node. Add to List
        Go to right child of that node.
     */
    public static ArrayList<Integer> inorderItr(TreeNode root) {
        if (root == null) return new ArrayList<>();

        ArrayList<Integer> inorderList = new ArrayList<>();
        Stack<TreeNode> treeNodes = new Stack<>();

        while (true) {
            while (root != null) {
                treeNodes.add(root);
                root = root.left;
            }

            if (treeNodes.isEmpty()) break;

            root = treeNodes.pop();
            inorderList.add(root.data);
            root = root.right;
        }

        return inorderList;
    }
}
