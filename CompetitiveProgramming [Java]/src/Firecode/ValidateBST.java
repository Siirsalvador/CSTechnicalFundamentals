package Firecode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-08-27
 */
public class ValidateBST {

    public static boolean validateBSTEff(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isValidBST(TreeNode root, int left, int right) {
        if (root == null) return true;

        if (root.data <= left || root.data >= right) return false;

        return isValidBST(root.left, left, root.data) && isValidBST(root.right, root.data, right);
    }

    public static boolean validateBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list);

        ArrayList<Integer> list2 = new ArrayList<>(list);
        Collections.sort(list2);

        return list.equals(list2);
    }

    public static void inorder(TreeNode root, ArrayList<Integer> nodesInOrder) {

        if (root == null) return;

        inorder(root.left, nodesInOrder);
        nodesInOrder.add(root.data);
        inorder(root.right, nodesInOrder);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);

        System.out.println(validateBST(root));
    }
}
