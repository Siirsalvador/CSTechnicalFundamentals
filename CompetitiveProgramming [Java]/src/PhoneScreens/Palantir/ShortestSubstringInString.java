package PhoneScreens.Palantir;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-02-25
 */
public class ShortestSubstringInString {

    private static TrieNode root;

    public static void main(String[] args){

        List<String> word = Arrays.asList("palantir", "pelantors", "cheapair", "cheapoair");
    }

    public static String findAllLongestSubs(List<String> words) {
        if (words == null || words.isEmpty())
            return "";

        for (String word : words) {
            addWord(word);
        }

        Map<String, String> wordToSub = new HashMap<>();
        for (String word : words) {
            String sub = shortestUniqueSubstring(word);
            wordToSub.put(word, sub);
        }

        return String.valueOf(wordToSub.entrySet());
    }

    public static void addWord(String s) {
        if (s == null || s.isEmpty())
            return;

        TrieNode node = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            node.children.putIfAbsent(c, new TrieNode(c, 0));
            node = node.children.get(c);
            node.visitCount++;
        }

        node.isLeaf = true;
    }


    public static String shortestUniqueSubstring(String s) {
        if (s == null || s.isEmpty())
            return "";

        String maxSub = "";
        String currSub = "";

        TrieNode node = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            int count = node.children.get(c).visitCount;
            if (count == 1) {
                currSub += c;
                maxSub = currSub.length() > maxSub.length() ? currSub : maxSub;
                continue;
            }

            currSub = "";
        }

        return maxSub;
    }

}


class TrieNode {
    char c;
    Map<Character, TrieNode> children;
    int visitCount;
    boolean isLeaf;

    TrieNode(char c, int visitCount) {
        this.c = c;
        this.visitCount = visitCount;
    }
}