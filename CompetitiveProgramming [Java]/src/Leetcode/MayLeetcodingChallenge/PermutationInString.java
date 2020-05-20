package Leetcode.MayLeetcodingChallenge;

/**
 * @author: aoyekanmi
 * @date: 2020-05-18
 */
public class PermutationInString {

    //. >
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";

        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.isEmpty() || s2.isEmpty())
            return false;
        if (s1.length() > s2.length())
            return false;

        int[] chars = new int[128];
        for (char c : s1.toCharArray())
            chars[c]++;

        int left = 0;
        int right = 0;
        int cnt = s1.length();

        while (right < s2.length()) {
            char c = s2.charAt(right);
            if (chars[c] > 0) cnt--;
            chars[c]--;
            right++;

            if (cnt == 0)
                return true;

            if (right - left == s1.length()) {
                char lC = s2.charAt(left);
                if (chars[lC] >= 0) cnt++;
                chars[lC]++;
                left++;
            }
        }

        return false;
    }
}
