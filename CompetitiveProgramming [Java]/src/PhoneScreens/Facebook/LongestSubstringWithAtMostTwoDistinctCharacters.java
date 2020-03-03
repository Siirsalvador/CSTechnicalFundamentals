package PhoneScreens.Facebook;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-30
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters {

    /*
    Time Complexity O(N * M). N
    Space Complexity O(1), since we always have at most 3 entries in the array3
     */
    public int lengthOfLongestSubstringTwoDistinct(String s) {

        int s_len = s.length();
        if (s_len <= 2) return s_len;

        int left = 0;
        int right = 0;

        //eetec
        // e:3, t:2,
        //tec

        Map<Character, Integer> map = new HashMap<>();
        int max_len = 2;

        while (right < s_len) {

            map.put(s.charAt(right), right++);


            if (map.size() == 3) {
                int idx = Collections.min(map.values());  // 2M, where M is the number of map entries
                map.remove(s.charAt(idx));

                left = idx + 1;
            }

            max_len = Math.max(max_len, right - left);
        }

        return max_len;
    }
}
