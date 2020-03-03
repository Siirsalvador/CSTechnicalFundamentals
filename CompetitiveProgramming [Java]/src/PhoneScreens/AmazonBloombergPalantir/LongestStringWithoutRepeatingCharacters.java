package PhoneScreens.AmazonBloombergPalantir;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-01
 */
public class LongestStringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String s = "dvdf";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;

        //character to index
        Map<Character, Integer> map = new HashMap<>();

        int max = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (map.containsKey(c) && map.get(c) >= start) {
                int len = i - start;
                max = Math.max(max, len);
                start = map.get(c) + 1;
            }

            map.put(c, i);
        }

        //last index edge case
        int len = s.length() - start;
        max = Math.max(max, len);

        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.isEmpty()) return 0;

        //character index
        Map<Character, Integer> map = new HashMap<>();

        int max = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (map.containsKey(c)) {
                max = Math.max(i - start, max);
                start = map.get(c) + 1;
            }

            map.put(c, i);
        }

        max = Math.max(s.length() - start, max);
        return max;
    }
}
