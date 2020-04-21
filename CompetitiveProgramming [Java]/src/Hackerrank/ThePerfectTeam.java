package Hackerrank;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-03-25
 */
public class ThePerfectTeam {
    public static int perfectTeam(String skills) {
        // Write your code here
        Map<Character, Integer> map = new HashMap<>();
        map.put('p', 0);
        map.put('c', 0);
        map.put('m', 0);
        map.put('b', 0);
        map.put('z', 0);


        for (int i = 0; i < skills.length(); i++) {
            char c = skills.charAt(i);
            map.put(c, map.get(c) + 1);
        }

        int min = 0;
        for (Map.Entry<Character, Integer> es : map.entrySet()) {
            if (es.getValue() == 0) return 0;
            if (min == 0) min = es.getValue();
            else min = Math.min(es.getValue(), min);
        }

        return min;
    }
}
