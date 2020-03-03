package PhoneScreens.Facebook;

import java.util.HashMap;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-02-13
 */

public class AddAndSearchWords {
    public static void main(String[] args) {
        WordDictionary wd = new WordDictionary();
        wd.addWord("bad");
        wd.addWord("dad");
        wd.addWord("mad");
        wd.addWord("pad");
        wd.addWord("bad");
        wd.addWord(".ad");
        wd.addWord("b..");
    }
}

class WordDictionary {
    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new TrieNode();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        if (word == null || word.isEmpty()) return;

        TrieNode node = this.root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            node.children.putIfAbsent(c, new TrieNode(c));
            node = node.children.get(c);
        }

        node.isLeaf = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */

    public boolean search(String word) {
        return search(this.root, 0, word);
    }

    /*
     is '.'
     is not '.'

     .....

     ap.le

     2 itrs for A & P,
     26 ^ K (* 0(N))


     apple
    */
    private boolean search(TrieNode node, int index, String word) {
        if (index == word.length()) return node.isLeaf;

        char c = word.charAt(index);

        if (c == '.') {
            for (TrieNode child : node.children.values()) {
                if (search(child, index + 1, word))
                    return true;
            }

            return false;
        }

        return node.children.containsKey(c) && search(node.children.get(c), index + 1, word);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

class TrieNode {
    Character currChar;
    HashMap<Character, TrieNode> children;
    boolean isLeaf;

    TrieNode() {
        children = new HashMap<>();
    }

    TrieNode(Character c) {
        this.currChar = c;
        children = new HashMap<>();
    }
}