package PhoneScreens.Amazon;

import java.util.HashMap;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-04
 */
public class Trie {

    TrieNode root;

    Trie() {
        root = new TrieNode();
    }


    private void insertWord(String word) {
        if (word == null || word.isEmpty()) return;

        HashMap<Character, TrieNode> children = root.children;

        int idx = 0;
        while (idx < word.length()) {
            children.putIfAbsent(word.charAt(idx), new TrieNode(word.charAt(idx)));
            if (idx + 1 == word.length()) children.get(word.charAt(idx)).isLeaf = true;

            children = children.get(word.charAt(idx)).children;
            idx++;
        }

    }

    private Boolean searchWord(String word) {
        if (word == null || word.isEmpty()) return false;

        HashMap<Character, TrieNode> children = root.children;

        int idx = 0;
        boolean contains = true;
        boolean isLeaf = false;

        while (idx < word.length()) {
            if (!children.containsKey(word.charAt(0))) {
                contains = false;
                break;
            }

            isLeaf = idx + 1 == word.length() ? children.get(word.charAt(0)).isLeaf : false;
            children = children.get(word.charAt(0)).children;
            idx++;
        }

        return contains && isLeaf;
    }

    private Boolean searchPrefix(String word) {
        if (word == null || word.isEmpty()) return false;

        HashMap<Character, TrieNode> children = root.children;

        int idx = 0;
        boolean contains = true;

        while (idx < word.length()) {
            if (!children.containsKey(word.charAt(0))) {
                contains = false;
                break;
            }

            children = children.get(word.charAt(0)).children;
            idx++;
        }

        return contains;
    }
}

class TrieNode {
    Character c;
    Boolean isLeaf;
    HashMap<Character, TrieNode> children;

    TrieNode() {
        children = new HashMap<>();
    }

    TrieNode(Character c) {
        this.c = c;
        children = new HashMap<>();
    }
}