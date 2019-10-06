package Firecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-10-05
 */
public class FB1800Problem {

    private static HashMap<String, String> mapOfNumbers = new HashMap<>();

    private static void init() {
        mapOfNumbers.put("2", "abc");
        mapOfNumbers.put("3", "def");
        mapOfNumbers.put("4", "ghi");
        mapOfNumbers.put("5", "jkl");
        mapOfNumbers.put("6", "mno");
        mapOfNumbers.put("7", "pqrs");
        mapOfNumbers.put("8", "tuv");
        mapOfNumbers.put("9", "wxyz");
    }

    public static ArrayList<String> getStringsFromNums(String digits) {

        if (digits == null || digits.isEmpty()) return new ArrayList<>();

        init();
        ArrayList<String> result = new ArrayList<>();

        String[] digitArr = digits.split("");
        int idx = 0;

        Stack<PhoneNode> nodes = new Stack<>();

        String[] currLetters = mapOfNumbers.get(digitArr[idx]).split("");
        for (String aLetter : currLetters) {
            nodes.add(new PhoneNode(aLetter, 1));
        }
        idx++;

        while (!nodes.isEmpty()) {
            PhoneNode curr = nodes.pop();

            if (curr.digitCount == digits.length()) {
                result.add(curr.word);
                continue;
            }
            if (idx > digitArr.length - 1) idx = curr.digitCount;

            String[] letters = mapOfNumbers.get(digitArr[idx]).split("");
            for (String aLetter : letters) {
                int var = curr.digitCount;
                nodes.add(new PhoneNode(curr.word.concat(aLetter), var + 1));
            }
            idx++;
        }

        /*
            2 3 4

            a b c

            cd ce cf

            cfg cfh cfi

         */

        return result;

    }

    public static void main(String[] args) {
        System.out.println(getStringsFromNums("232"));
    }

    static class PhoneNode {
        String word;
        int digitCount;

        PhoneNode(String w, int c) {
            word = w;
            digitCount = c;
        }
    }
}

