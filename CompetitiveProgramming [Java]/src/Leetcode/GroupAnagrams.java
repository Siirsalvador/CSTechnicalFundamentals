package Leetcode;

import java.util.*;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-04-06
 */
public class GroupAnagrams {

    public static void main(String[] a) {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(input));

    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        /*Go through array
        Count number of characters
        maintain map of arr to List<>*/

        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            addToMap(strs[i], map);
        }

        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }

        return res;
    }

    private static void addToMap(String word, Map<String, List<String>> map) {
        int[] chars = new int[26];
        for (int i = 0; i < word.length(); i++) {
            chars[word.charAt(i) - 'a']++;
        }

        String key = "";
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != 0) key += i + ":" + chars[i];
        }

        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(word);
    }
}
