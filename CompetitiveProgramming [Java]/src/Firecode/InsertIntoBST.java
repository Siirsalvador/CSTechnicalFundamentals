package Firecode;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-09-12
 */
public class InsertIntoBST {

    public TreeNode insert(TreeNode root, int data) {
        if (root == null) return new TreeNode(data);

        if (data < root.data) root.left = insert(root.left, data);
        else root.right = insert(root.right, data);
        return root;
    }
}
