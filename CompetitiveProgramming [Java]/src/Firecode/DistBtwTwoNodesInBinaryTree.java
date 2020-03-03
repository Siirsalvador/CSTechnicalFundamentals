package Firecode;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-11-18
 */
public class DistBtwTwoNodesInBinaryTree {
    public int getNodeDistance(TreeNode root, int n1, int n2) {
        //Find LCA
        TreeNode lca = findLCA(root, n1, n2);

        //Find distance from LCA to n1
        int dist1 = findDist(lca, n1, 0);
        //Find distance from LCA to n2
        int dist2 = findDist(lca, n2, 0);

        //add distances
        return dist1 + dist2;
    }

    public TreeNode findLCA(TreeNode root, int n1, int n2) {
        if (root == null || root.data == n1 || root.data == n2) return root;

        TreeNode lNode = findLCA(root.left, n1, n2);
        TreeNode rNode = findLCA(root.right, n1, n2);

        if (lNode != null && rNode != null) return root;

        return lNode != null ? findLCA(root.left, n1, n2) : findLCA(root.right, n1, n2);
    }

    public int findDist(TreeNode root, int num, int level) {
        if (root == null) return -1;
        if (root.data == num) return level;

        int dist = findDist(root.left, num, level + 1);
        if (dist == -1) dist = findDist(root.right, num, level + 1);

        return dist;
    }
}
