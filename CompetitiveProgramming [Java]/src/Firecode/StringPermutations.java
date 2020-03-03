package Firecode;

import java.util.ArrayList;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-11-18
 */
public class StringPermutations {

    public static void main(String[] args) {
        System.out.println(getPermutations("abc"));
    }

    public static ArrayList<String> getPermutations(String s) {
        if (s == null) return null;

        ArrayList<String> list = new ArrayList<>();
        if (s.isEmpty() || s.length() == 1) {
            list.add(s);
            return list;
        }

        for (int i = 0; i < s.length(); i++) {
            ArrayList<String> aList = getPermutations(s.substring(0, i) + s.substring(i + 1));

            for (String str : aList) {
                list.add(s.charAt(i) + str);
            }
        }

        return list;
    }

    public static ArrayList<String> getPermutations2(String s) {

        ArrayList<String> list = new ArrayList<>();
        permuteHelper(s, "", list);
        return list;
    }

    //n * n * n! - Time complexity
    // n! - Space complexity
    private static void permuteHelper(String remainder, String current, ArrayList<String> list) {
        if (remainder == null || remainder.isEmpty()) {
            list.add(current);
            return;
        }

        for (int i = 0; i < remainder.length(); i++) {
            permuteHelper(remainder.substring(0, i) + remainder.substring(i + 1), current + remainder.charAt(i), list);
        }
    }

}
