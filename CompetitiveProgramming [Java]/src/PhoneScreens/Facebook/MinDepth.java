package PhoneScreens.Facebook;

import java.util.Random;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-31
 */
public class MinDepth {

    public static void main(String[] args){
        Random r = new Random();


        for(int i = 0; i < 10; i++)
            System.out.println(r.nextInt(3));
    }
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        if (root.left != null && root.right != null) {
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        }

        return root.left == null ? 1 + minDepth(root.right) : 1 + minDepth(root.left);
    }
}
