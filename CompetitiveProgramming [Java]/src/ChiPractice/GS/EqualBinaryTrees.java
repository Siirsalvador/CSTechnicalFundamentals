package ChiPractice.GS;

import java.util.HashSet;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-08-01
 */

class Node{

    Node left, right;
    int data;

    Node(){}
}
public class EqualBinaryTrees {

    private boolean checkIfEqual(Node root1, Node root2){

        if(root1 == null && root2 == null)
            return true;

        if(root1 != null && root2 != null){
            return (root1.data == root2.data) && checkIfEqual(root1.left, root2.left)
                    && checkIfEqual(root1.right, root2.right);
        }

        return false;
    }

}
