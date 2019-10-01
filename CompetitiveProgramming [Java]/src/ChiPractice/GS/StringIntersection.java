package ChiPractice.GS;

import java.util.HashMap;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-08-01
 */
public class StringIntersection {

    //Linear Time
    public String getIntersectionInOrderOfA(String a, String b) {

        //Assuming there could be duplications
        HashMap<Character, Integer> stringToCount = new HashMap<>();

        for (int i = 0; i < b.length(); i++) {
            Character curr = b.charAt(i);

            if (stringToCount.containsKey(curr)) {
                stringToCount.put(curr, stringToCount.get(curr) + 1);
            } else {
                stringToCount.put(curr, 1);
            }
        }

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < a.length(); i++) {

            Character curr = a.charAt(i);

            if (stringToCount.containsKey(curr) && stringToCount.get(curr) > 0) {
                builder.append(curr);
                stringToCount.replace(curr, stringToCount.get(curr) - 1);
            }

        }

        return builder.toString();
    }

    //N squared by Chinemerem
    public String getIntersectionNSq(String s1, String s2) {

        StringBuilder sb = new StringBuilder();
        for (char c : s1.toCharArray()) {
            int idx = s2.indexOf(c);

            if (idx >= 0) {
                sb.append(c);
                s2 = idx == s2.length() - 1 ? s2.substring(0, idx)
                        : s2.substring(0, idx) + s2.substring(idx + 1);
            }

        }

        return sb.toString();
    }
}
