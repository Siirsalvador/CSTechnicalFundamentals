package ChiPractice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestSubsequence {

    public static void main(String[] args) {
        System.out.println(extractCommonCharacters("BADMINGTON", "BIRMNGHAM"));
    }

    //Assuming every character in the String is unique
    public static List<StringBuilder> extractCommonCharacters(String firstString, String secondString) {

        char[] firstStringCharArr = firstString.toCharArray();
        char[] secondStringCharArr = secondString.toCharArray();


        Set<Character> firstStringSet = new HashSet<>();
        for (char aFirstStringCharArr : firstStringCharArr) {
            firstStringSet.add(aFirstStringCharArr);
        }


        Set<Character> secondStringSet = new HashSet<>();
        for (char aSecondStringCharArr : secondStringCharArr) {
            secondStringSet.add(aSecondStringCharArr);
        }

        StringBuilder firstSetCommonCharacters = new StringBuilder();
        for (int i = 0; i < firstStringCharArr.length; i++) {
            if (secondStringSet.contains(firstStringCharArr[i])) {
                firstSetCommonCharacters.append(firstStringCharArr[i]);
            }
        }

        StringBuilder secondSetCommonCharacters = new StringBuilder();
        for (int i = 0; i < secondStringCharArr.length; i++) {
            if (firstStringSet.contains(secondStringCharArr[i])) {
                secondSetCommonCharacters.append(secondStringCharArr[i]);
            }
        }

        return Arrays.asList(firstSetCommonCharacters, secondSetCommonCharacters);
    }


}
