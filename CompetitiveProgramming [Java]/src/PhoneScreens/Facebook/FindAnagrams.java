package PhoneScreens.Facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-02-13
 */
public class FindAnagrams {

    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";
        System.out.println(findAnagrams2(s, p));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        if (s == null || s.isEmpty() || s.length() < p.length()) return new ArrayList<>();

        int[] pArray = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pArray[p.charAt(i) - 'a']++;
        }

        List<Integer> indexes = new ArrayList<>();

        //String s = "abab"
        //String p = "ab"
        /*
            4 - 2 = 2

            0 + 2 = 2 (0, 1)
            1 + 2 = 3 (1, 2)
            2 + 2 = 4 (2, 3)
         */

        int lastIdx = s.length() - p.length();
        for (int i = 0; i <= lastIdx; i++) {
            if (sameCharacterFrequency(i, i + p.length(), s, pArray)) {
                indexes.add(i);
            }
        }

        return indexes;
    }

    private static boolean sameCharacterFrequency(int start, int end, String s, int[] charArray) {

        int[] compare = new int[26];
        for (int i = 0; i < compare.length; i++) compare[i] = charArray[i];

        for (int i = start; i < end; i++) {
            compare[s.charAt(i) - 'a']--;
        }

        for (int i = 0; i < compare.length; i++) {
            if (compare[i] != 0) return false;
        }

        return true;
    }

    public static List<Integer> findAnagrams2(String s, String p) {
        if (s == null || p == null || s.isEmpty() || p.isEmpty()) return new ArrayList<>();
        if (p.length() > s.length()) return new ArrayList<>();

        int[] freq = new int[26];
        for (int i = 0; i < p.length(); i++) {
            freq[p.charAt(i) - 'a']++;
        }

        int sLeft = 0;
        int sRight = 0;
        int count = p.length();
        List<Integer> res = new ArrayList<>();

        while (sRight < s.length()) {
            char rChar = s.charAt(sRight);
            if (freq[rChar - 'a'] > 0) count--;
            freq[rChar - 'a']--;
            sRight++;

            if (count == 0) res.add(sLeft);

            if (sRight - sLeft == p.length()) {
                char lChar = s.charAt(sLeft);
                if (freq[lChar - 'a'] >= 0) count++;
                freq[lChar - 'a']++;
                sLeft++;
            }
        }

        return res;
    }

}
