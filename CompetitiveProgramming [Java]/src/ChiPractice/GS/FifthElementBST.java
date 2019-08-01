package ChiPractice.GS;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-08-01
 */

public class FifthElementBST {

    //Assuming insert has already happened
    public int findN5thElement(Node root) {

        int count = 0;
        return inOrderTraversal(root, count);

    }

    private int inOrderTraversal(Node root, int count) {

        if (root.left != null) {
            inOrderTraversal(root, count);
        }

        count = count + 1;

        if (count == 5) {
            return root.data;
        }

        if (root.right != null) {
            inOrderTraversal(root, count);
        }

        return -1;
    }
}
