package PhoneScreens.AmazonBloombergPalantir;

import java.util.*;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-02
 */
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;


        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int currSize = queue.size();

            for (int i = 0; i < currSize; i++) {
                TreeNode curr = queue.poll();
                if(curr == null) continue;;
                if (i + 1 == currSize) res.add(curr.val);
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
        }

        return res;
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,4};

        int[] arr2 = new int[arr.length];
        for(int i = 0; i < arr2.length; i++){
            arr2[i] = arr[i];
        }

        arr[2] = 9;

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
    }
}
