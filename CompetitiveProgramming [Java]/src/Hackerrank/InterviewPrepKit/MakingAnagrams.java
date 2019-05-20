package Hackerrank.InterviewPrepKit;

import java.util.HashMap;
import java.util.Scanner;

public class MakingAnagrams {

    public static int minDeletions;

    public static void insertIntoMap(String s1, String s2, HashMap<String, Integer> name) {
        for (int i = 0; i < s1.length(); i++) {
            if (s2.contains(Character.toString(s1.charAt(i)))) {
                if (name.containsKey(Character.toString(s1.charAt(i)))) {
                    int value = name.get(Character.toString(s1.charAt(i)));
                    name.put(Character.toString(s1.charAt(i)), value + 1);
                } else {
                    name.put(Character.toString(s1.charAt(i)), 1);
                }
            } else {
                minDeletions = minDeletions + 1;
            }
        }

    }

    public static int makeAnagram(String firstString, String secondString) {
        firstString = firstString.toLowerCase();
        secondString = secondString.toLowerCase();

        HashMap<String, Integer> firstStringMap = new HashMap<String, Integer>();
        HashMap<String, Integer> secondStringMap = new HashMap<String, Integer>();

        insertIntoMap(firstString, secondString, firstStringMap);
        insertIntoMap(secondString, firstString, secondStringMap);

        for (String letter : firstStringMap.keySet()) {
            int diff = Math.abs(firstStringMap.get(letter) - secondStringMap.get(letter));
            if (diff != 0) {
                minDeletions = minDeletions + diff;
            }
        }

        return minDeletions;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String firstString = scan.nextLine();
        String secondString = scan.nextLine();

        int res = makeAnagram(firstString, secondString);

        System.out.println(res);

        scan.close();
    }

}
