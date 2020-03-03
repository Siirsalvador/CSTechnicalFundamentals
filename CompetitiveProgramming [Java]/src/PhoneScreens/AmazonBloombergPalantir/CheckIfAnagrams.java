package PhoneScreens.AmazonBloombergPalantir;

import java.util.HashMap;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-12-13
 */
public class CheckIfAnagrams {

    public static void main(String[] args){
        String s = "ayomide";
        String s2 = "ymiadeo";
        System.out.println(checkIfAnagrams(s, s2));
    }

    public static boolean checkIfAnagrams(String s, String s2) {

        if (s == null || s2 == null || s.length() != s2.length()) return false;

        HashMap<Character, Integer> charToFreq = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (charToFreq.containsKey(c)) {
                charToFreq.put(c, charToFreq.get(c) + 1);
            } else {
                charToFreq.put(c, 1);
            }
        }

        for (char c : s2.toCharArray()) {

            if (!charToFreq.containsKey(c)) {
                return false;
            } else {

                int newVal = charToFreq.get(c) - 1;
                if (newVal == 0) {
                    charToFreq.remove(c);
                } else {
                    charToFreq.put(c, newVal);
                }

            }
        }

        return true;

    }
}
