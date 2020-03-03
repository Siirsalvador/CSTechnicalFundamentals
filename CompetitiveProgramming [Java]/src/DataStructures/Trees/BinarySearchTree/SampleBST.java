package DataStructures.Trees.BinarySearchTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-07-20
 */
class Node {

    Node left, right;
    int data;

    Node(int data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return data == node.data;
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}

public class SampleBST {

    public static void main(String[] args) {

        SampleBST bst = new SampleBST();
        Node node = new Node(4);
        bst.insert(node, 2);
        bst.insert(node, 3);
        bst.insert(node, 1);
        bst.insert(node, 7);
        bst.insert(node, 6);

    }

    private void insert(Node root, int value) {

        if (root == null) {
            root = new Node(value);
            return;
        }

        if (value < root.data) {
            insert(root.left, value);
        } else {
            insert(root.right, value);
        }
    }

    private void delete(Node root, int val) {
        root = deleteRec(root, val);
    }

    private Node deleteRec(Node root, int val) {

        if (root == null) return root;

        if (val < root.data) {
            root.left = deleteRec(root.left, val);
        } else if (val > root.data) {
            root.right = deleteRec(root.right, val);
        } else {

            if (root.left == null || root.right == null)
                return root.left == null ? root.right : root.left;

            root.data = findMinRightValue(root.right);
            root.right = deleteRec(root.right, root.data);
        }

        return root;
    }

    private int findMinRightValue(Node right) {
        Node curr = right;
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr.data;
    }

    private int height(Node root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    private boolean contains(Node root, int value) {

        if (root == null) return false;
        if (value == root.data) return true;

        boolean found;
        found = value < root.data ? contains(root.left, value) : contains(root.right, value);
        return found;
    }

    private void printInOrder(Node root) {
        if (root == null) return;

        printInOrder(root.left);
        System.out.println(root.data);
        printInOrder(root.right);

    }

    private Node lca(Node root, int v1, int v2) {
        if (root == null || (root.data == v1 || root.data == v2)) return root;

        Node lNode = lca(root.left, v1, v2);
        Node rNode = lca(root.right, v1, v2);

        if (lNode != null && rNode != null) return root;
        return lNode == null ? rNode : lNode;
    }

    private boolean checkBST(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list);

        ArrayList<Integer> uniqueNodeList = new ArrayList<>(list);
        Collections.sort(uniqueNodeList);

        return uniqueNodeList == list;
    }

    private void inorder(Node root, ArrayList<Integer> nodesInOrder) {
        if (root == null) return;

        inorder(root.left, nodesInOrder);
        nodesInOrder.add(root.data);
        inorder(root.right, nodesInOrder);
    }

    private boolean validateBST(Node root) {
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean helper(Node root, int left, int right) {
        if (root == null) return true;
        if (left > root.data || right < root.data) return false;
        return helper(root.left, left, root.data) && helper(root.right, root.data, right);
    }


}



