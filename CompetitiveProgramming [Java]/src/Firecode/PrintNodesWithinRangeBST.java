package Firecode;

import java.util.ArrayList;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-09-23
 */
public class PrintNodesWithinRangeBST {

    public ArrayList<Integer> rangeList = new ArrayList<Integer>();

    /*
        Given a
        Binary Search Tree
        and two numbers - a & b, return all the nodes in the tree that lie in the range [a .. b].
        Your method should return an ArrayList with the data of the qualifying nodes inserted in ascending order.
     */
    public void printRange(TreeNode root, int a, int b) {
        //Find left child as a
        //add root, add right
        //only add if <= b
        if(root == null) return;
        printRange(root.left, a, b);
        if(root.data >= a && root.data <= b) rangeList.add(root.data);
        printRange(root.right, a, b);
    }
}
