package PhoneScreens.Facebook;

import java.util.*;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-30
 */
public class LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {


        int maxCount = 0;

        for (int i = 0; i < s.length(); i++) {

            Set<Character> set = new HashSet<>();
            int distinct = 0;
            int count = 0;

            for (int j = i; j < s.length(); j++) {
                char curr = s.charAt(j);
                System.out.println(curr);
                if (!set.contains(curr) && distinct == k) {
                    break;
                }

                if (set.add(curr)) distinct++;
                count++;
                maxCount = Math.max(count, maxCount);
                System.out.println(count);
            }
        }

        return maxCount;
    }

    public int lengthOfLongestSubstringKDistinct2(String s, int k) {
        int len = s.length();
        if (len <= k) return len;

        int left = 0;
        int right = 0;

        Map<Character, Integer> map = new HashMap<>();
        int maxLen = k;
        while (right < len) {

            map.put(s.charAt(right), right++);

            if (map.size() == k + 1) {
                int idx = Collections.min(map.values());
                map.remove(s.charAt(idx));
                left = idx + 1;
            }

            maxLen = Math.max(maxLen, right - left);
        }

        return maxLen;

    }
}
