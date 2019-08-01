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

            if (stringToCount.containsKey(curr)) {
                builder.append(curr);
                reduceCount(stringToCount, curr);
            }

        }

        return builder.toString();
    }

    //N squared
    public String getIntersectionInOrderOfANSquare(String a, String b) {

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < a.length(); i++) {

            char curr = a.charAt(i);

            for (int j = 0; j < b.length(); j++) {

                if (curr == b.charAt(j)) {
                    builder.append(curr);
                }
            }
        }

        return builder.toString();
    }


    private void reduceCount(HashMap<Character, Integer> stringToCount, Character curr) {

        if (stringToCount.get(curr) - 1 == 0) {
            stringToCount.remove(curr);
        } else {
            stringToCount.put(curr, stringToCount.get(curr) - 1);
        }
    }
}
