package PhoneScreens.Facebook;


import java.util.HashMap;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-02-16
 */
public class DecodeWays {

    static HashMap<String, Integer> map = new HashMap<>();

    public static int numDecodings(String s) {
        if (s.isEmpty()) return 0;
        return helper(s, -1);
    }

    //01, 1
    private static int helper(String s, int number) {
        if (s.isEmpty() && number <= 26)
            return 1;

        if (s.isEmpty() || s.charAt(0) == '0' || number == 0 || number > 26)
            return 0;

        if (s.length() == 1) {
            if (!map.containsKey(s)) {
                map.put(s, helper(s.substring(1), Integer.parseInt(s.substring(0, 1))));
            }
            return map.get(s);
        }

        int firstNum = Integer.parseInt(s.substring(0, 1));
        int secondNum = Integer.parseInt(s.substring(0, 2));

        if (!map.containsKey(s)) {
            map.put(s, helper(s.substring(1), firstNum) + helper(s.substring(2), secondNum));
        }

        return map.get(s);
    }
}
