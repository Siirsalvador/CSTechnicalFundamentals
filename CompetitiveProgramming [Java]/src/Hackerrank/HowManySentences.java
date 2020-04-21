package Hackerrank;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-03-25
 */
public class HowManySentences {

    public static List<Long> countSentences(List<String> wordSet, List<String> sentences) {
        // Write your code here
        List<Long> result = new ArrayList<>();
        for (int i = 0; i < sentences.size(); i++) {
            String[] words = sentences.get(i).split(" ");
            long totalCnt = 0;
            for (String word : words) {
                long count = countAnagrams(word, wordSet);
                if (count == 0) continue;
                totalCnt = totalCnt == 0 ? count : totalCnt * count;
            }
            result.add(totalCnt);
        }

        return result;
    }

    public static long countAnagrams(String word, List<String> wordSet) {
        long anagramCnt = 0;
        for (int i = 0; i < wordSet.size(); i++) {
            if (isAnagram(word, wordSet.get(i)))
                anagramCnt++;
        }

        return anagramCnt;
    }

    public static boolean isAnagram(String word, String word2) {
        if (word.length() != word2.length()) return false;

        int[] charCnt = new int[26];
        for (int i = 0; i < word.length(); i++) {
            charCnt[word.charAt(i) - 'a']++;
            charCnt[word2.charAt(i) - 'a']--;
        }

        for (int cnt : charCnt) {
            if (cnt != 0) return false;
        }

        return true;
    }

//    public static List<Long> countSentences(List<String> wordSet, List<String> sentences) {
//        // Write your code here
//        Set<String> set = new HashSet<>(wordSet);
//        HashMap<String, Long> wordToAnagramCnt = new HashMap<>();
//
//        for(String word : wordSet){
//
//        }
//        List<Long> result = new ArrayList<>();
//        for(int i = 0; i < sentences.size(); i++){
//            String[] words = sentences.get(i).split(" ");
//            long totalCnt = 0;
//            for(String word : words){
//                long count = countAnagrams(word, wordSet);
//                if(count == 0) continue;
//                totalCnt = totalCnt == 0 ? count : totalCnt * count;
//            }
//            result.add(totalCnt);
//        }
//
//        return result;
//    }
}
