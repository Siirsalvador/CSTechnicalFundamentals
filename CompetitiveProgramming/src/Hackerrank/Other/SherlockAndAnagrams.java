package Hackerrank.Other;

import java.util.Stack;

public class SherlockAndAnagrams {


    public static void main(String[] args) {
        String firstWord = "kkkk";

        System.out.println(findMaximumAnagramCount(firstWord));
    }

    private static int findMaximumAnagramCount(String word) {

        String[] arrOfStrings = word.split("");
        Stack<String> stackOfStrings = new Stack<>();

        StringBuilder builder = new StringBuilder();

        int count = 0;

//        for (String arrOfString : arrOfStrings) {
//            stackOfStrings.push(arrOfString);
//
//        }

        for (int i = 0; i < arrOfStrings.length; i++) {
            String arrOfString = arrOfStrings[i];
            builder.append(arrOfString);


            if (word.contains(builder.reverse().toString())) {
                if (builder.length() == 1 && (word.indexOf(builder.toString()) == word.lastIndexOf(builder.toString()))) {
                    continue;
                }
                count++;
            }

            builder.reverse();

        }

        //Need to check for number of a particular anagram exists

        return count;
    }
}
