package Firecode;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-10-04
 */
public class LowestCommonAncestor {

    public static TreeNode findLCA(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null || (root == a || root == b)) return root;

        TreeNode lNode = findLCA(root.left, a, b);
        TreeNode rNode = findLCA(root.right, a, b);

        if (lNode != null && rNode != null) return root;
        return lNode == null ? rNode : lNode;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);

        root.right.right = new TreeNode(9);
        root.left.left.left = new TreeNode(2);

        TreeNode res = findLCA(root, root.left, root.left.left);
        System.out.println(res.data);
    }
}
