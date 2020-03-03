package PhoneScreens.AmazonBloombergPalantir;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-19
 */
public class MinTreeDepth {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;

        int minDepth = Integer.MAX_VALUE;
        if(root.left != null){
            int left = minDepth(root.left);
            minDepth = Math.min(minDepth, left);
        }

        if(root.right != null){
            int right = minDepth(root.right);
            minDepth = Math.min(minDepth, right);
        }

        return 1 + minDepth;
    }
}
