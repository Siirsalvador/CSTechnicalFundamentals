package Hackerrank.OtherKnowledge.HuffmanCompression;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-07-27
 */

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

abstract class Node implements Comparable<Node> {
    public int frequency; // the frequency of this tree
    public char data;
    public Node left, right;

    public Node(int freq) {
        frequency = freq;
    }

    // compares on the frequency
    public int compareTo(Node tree) {
        return frequency - tree.frequency;
    }
}

class HuffmanLeaf extends Node {

    public HuffmanLeaf(int freq, char val) {
        super(freq);
        data = val;
    }
}

class HuffmanNode extends Node {

    public HuffmanNode(Node l, Node r) {
        super(l.frequency + r.frequency);
        left = l;
        right = r;
    }
}


class Decoding {

    void decode(String s, Node root) {

        //For final word
        StringBuilder finalWordList = new StringBuilder();

        //create char arr from string
        char[] charArray = s.toCharArray();

        //we need an idx flag
        int idx = 0;

        char c;

        Node temp = root;

        //if 0 go left, if 1 go right
        while (idx < charArray.length) {

            //if we find something, we move to the next idx and call the function again
            //if we don't find something, we keep going deeper into the tree
            if (charArray[idx] == '0') {

                //left
                c = temp.left.data;

                if (c == 0) {

                    idx++;
                    temp = temp.left;

                } else {

                    finalWordList.append(c);
                    reduceFrequency(temp.left);
                    idx++;
                    temp = root;
                }

            } else {

                //right
                c = temp.right.data;

                if (c == 0) {

                    idx++;
                    temp = temp.right;

                } else {

                    finalWordList.append(c);
                    reduceFrequency(temp.right);
                    idx++;
                    temp = root;

                }
            }
        }

        System.out.println(finalWordList.toString());
    }

    private void reduceFrequency(Node right) {
        if(right.frequency > 0){
            right.frequency--;
        }else {
            right.data = 0;
        }
    }


    /*
        charArr = {1,0,0,1,1};

        idx = 0;


        0: Check if charArr[idx] = 0 or 1

        1: if charArr[idx] = 0 check node.left;
        2: if node.left is not empty, add character to list and reduce it's frequency by 1. (When freq gets to 0, set that node to null)
        3: if node.left is empty get idx++ and go to 0

        4: if charArr[idx] = 1 check node.right
        5: if node.right is not empty, add character to list and reduce it's frequency by 1. (When freq gets to 0, set that node to null)
        6: if node.right is empty get idx++ and go to 0

     */
}

public class Huffman {

    public static Map<Character, String> mapA = new HashMap<>();

    // input is an array of frequencies, indexed by character code
    public static Node buildTree(int[] charFreqs) {

        PriorityQueue<Node> trees = new PriorityQueue<Node>();
        // initially, we have a forest of leaves
        // one for each non-empty character
        for (int i = 0; i < charFreqs.length; i++)
            if (charFreqs[i] > 0)
                trees.offer(new HuffmanLeaf(charFreqs[i], (char) i));

        assert trees.size() > 0;

        // loop until there is only one tree left
        while (trees.size() > 1) {
            // two trees with least frequency
            Node a = trees.poll();
            Node b = trees.poll();

            // put into new node and re-insert into queue
            trees.offer(new HuffmanNode(a, b));
        }

        return trees.poll();
    }

    public static void printCodes(Node tree, StringBuffer prefix) {

        assert tree != null;

        if (tree instanceof HuffmanLeaf) {
            HuffmanLeaf leaf = (HuffmanLeaf) tree;

            // print out character, frequency, and code for this leaf (which is just the prefix)
            //System.out.println(leaf.data + "\t" + leaf.frequency + "\t" + prefix);
            mapA.put(leaf.data, prefix.toString());

        } else if (tree instanceof HuffmanNode) {
            HuffmanNode node = (HuffmanNode) tree;

            // traverse left
            prefix.append('0');
            printCodes(node.left, prefix);
            prefix.deleteCharAt(prefix.length() - 1);

            // traverse right
            prefix.append('1');
            printCodes(node.right, prefix);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String test = input.next();

        // we will assume that all our characters will have
        // code less than 256, for simplicity
        int[] charFreqs = new int[256];

        // read each character and record the frequencies
        for (char c : test.toCharArray())
            charFreqs[c]++;

        // build tree
        Node tree = buildTree(charFreqs);

        // print out results
        printCodes(tree, new StringBuffer());
        StringBuffer s = new StringBuffer();

        for (int i = 0; i < test.length(); i++) {
            char c = test.charAt(i);
            s.append(mapA.get(c));
        }

        //System.out.println(s);
        Decoding d = new Decoding();
        d.decode(s.toString(), tree);

    }
}
