package Firecode;

import java.util.ArrayList;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-09-07
 */
public class Ancestors {

    public static ArrayList<Integer> ancestorsList = new ArrayList<Integer>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);

        printAncestors(root, 4);
        System.out.println(ancestorsList);
    }

    public static boolean printAncestors(TreeNode root, int nodeData) {

        if (root == null) return false;

        if (root.data == nodeData) {
            return true;
        }

        if (printAncestors(root.left, nodeData) || printAncestors(root.right, nodeData)) {
            ancestorsList.add(root.data);
            return true;
        }

        return false;
    }
}
