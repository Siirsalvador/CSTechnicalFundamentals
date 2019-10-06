package Firecode;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-10-04
 */
public class MirrorMirrorOnTheWall {
    public static boolean isMirror(TreeNode root1, TreeNode root2) {

        //if only one is null return false
        if (root1 == null && root2 == null) return true;
        if (root1 == null ^ root2 == null) return false;

        TreeNode temp = root1.right;
        root1.right = root1.left;
        root1.left = temp;

        return root1.data == root2.data && isMirror(root1.right, root2.right) && isMirror(root1.left, root2.left);
    }

    public boolean isMirror2(TreeNode root1, TreeNode root2) {
        //if only one is null return false
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;

        return root1.data == root2.data && isMirror(root1.right, root2.left) && isMirror(root1.left, root2.right);
    }

    public static void main(String[] args){
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);

        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);

        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(7);


        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);

        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);

        root2.right.left = new TreeNode(6);
        root2.right.right = new TreeNode(7);

        System.out.println(isMirror(root1, root2));
    }
}
