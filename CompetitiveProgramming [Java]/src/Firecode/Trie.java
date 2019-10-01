package Firecode;

import java.util.HashMap;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-09-10
 */
class TrieNode {
    Character c;
    Boolean isLeaf = false;
    HashMap<Character, TrieNode> children = new HashMap<>();

    TrieNode() {
    }

    TrieNode(Character c) {
        this.c = c;
    }
}

class Trie {
    private TrieNode root;

    // Implement these methods :
    private Trie() {
        this.root = new TrieNode();
    }

    /*
        Note:
        In the above example, underlined letters represent
        word boundaries.

        Word boundaries are important when differentiating
        between words and prefixes.

        For example, searchPrefix("AC") should return true,
        but since C is not a word boundary,
        searchWord("AC") should return false.

        The TrieNode class has a Boolean - isLeaf that
        is used to denote if the node is a word boundary.
     */

    public static void main(String[] args) {

        Trie trie = new Trie();
        trie.insertWord("AB");
        System.out.println(trie.searchWord("AB"));
        trie.insertWord("ABS");
        System.out.println(trie.searchWord("AB"));
        System.out.println(trie.searchWord("ABS"));
        trie.insertWord("ADS");
        trie.insertWord("ADSD");
        System.out.println(trie.searchPrefix("ADS"));
        trie.insertWord("ACS");

    }

    private void insertWord(String word) {
        if (word == null || word.isEmpty()) return;

        TrieNode curr = root;
        int i = 0;
        while (i < word.length()) {
            if (!curr.children.containsKey(word.charAt(i))) {
                curr.children.put(word.charAt(i), new TrieNode(word.charAt(i)));
            }
            curr = curr.children.get(word.charAt(i));
            curr.isLeaf = i == word.length() - 1;
            i++;
        }

    }

    private Boolean searchWord(String word) {
        TrieNode curr = contains(word);
        return curr != null && curr.isLeaf;
    }

    private Boolean searchPrefix(String word) {
        TrieNode curr = contains(word);
        return curr != null;
    }

    private TrieNode contains(String word) {
        TrieNode curr = root;
        int i = 0;
        while (i < word.length()) {
            if (!curr.children.containsKey(word.charAt(i))) return null;
            curr = curr.children.get(word.charAt(i));
            i++;
        }

        return curr;
    }
}

/*
private TrieNode root;

    // Implement these methods :
    public Trie() {
        this.root = new TrieNode();
    }

    public void insertWord(String word) {

        if(word == null || word.isEmpty()) return;

        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            if(!curr.children.containsKey(word.charAt(i))) {
                curr.children.put(word.charAt(i), new TrieNode(word.charAt(i)));
            }
            curr = curr.children.get(word.charAt(i));
            curr.isLeaf = i == word.length() - 1;
        }
    }

    public Boolean searchWord(String word) {
        TrieNode curr = root;
        int i = 0;
        while(i < word.length()){
            if(!curr.children.containsKey(word.charAt(i))) return false;
            curr = curr.children.get(word.charAt(i));
            i++;
        }

        return curr.isLeaf;
    }

    public Boolean searchPrefix(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            if(!curr.children.containsKey(word.charAt(i))) return false;
            curr = curr.children.get(word.charAt(i));
        }

        return true;
    }
 */