package PhoneScreens.Facebook;

import java.util.*;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-31
 */
public class LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args){
        System.out.println(letterCombinations("259"));
    }

    public static List<String> letterCombinations(String digits) {

        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;

        Map<Integer, String> map = populateMap();

        Stack<Digit> stack = new Stack<>();
        int dg = Character.getNumericValue(digits.charAt(0));
        String mapping = map.get(dg);

        for (int i = 0; i < mapping.length(); i++) {
            stack.push(new Digit(0, "" + mapping.charAt(i)));
        }

        // 4: 1 - 121
        // 3: 40
        // 3 ^ N * 4 ^ M
        int po = 1;
        while (!stack.isEmpty()) {
            po++;
            Digit curr = stack.pop();

            if (curr.index == digits.length() - 1) {
                res.add(curr.sequence);
                continue;
            }

            int idx = curr.index + 1;
            dg = Character.getNumericValue(digits.charAt(idx));
            mapping = map.get(dg);

            for (int i = 0; i < mapping.length(); i++) {
                stack.push(new Digit(idx, curr.sequence + mapping.charAt(i)));
            }

        }

        System.out.println("PO: " + po);

        return res;
    }


    public static Map<Integer, String> populateMap() {
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        return map;
    }
}

class Digit {
    int index;
    String sequence;

    Digit(int index, String sequence) {
        this.index = index;
        this.sequence = sequence;
    }
}
