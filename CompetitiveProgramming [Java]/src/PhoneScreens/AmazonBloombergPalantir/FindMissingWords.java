package PhoneScreens.AmazonBloombergPalantir;

import java.util.ArrayList;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-12-18
 */
public class FindMissingWords {

    public static void main(String[] args) {
        String one = "This is an example";
        String two = "is example";
        System.out.println(findMissingWords(one, two));
    }

    private static ArrayList<String> findMissingWords(String first, String second) {
        if (first == null || second == null) return new ArrayList<>();

        //Put smaller words in a list
        //Compare words in larger string to what is in list. Add what is missing to result
        if (first.length() > second.length()) {
            String temp = first;
            first = second;
            second = temp;
        }

        ArrayList<String> res = new ArrayList<>();
        String[] words = first.split(" ");

        int wordIdx = 0;
        int startIdx = 0;
        int end = 0;

        //n2 - NO
        while (end <= second.length()) {

            if (end == second.length()) {

                String sub = second.substring(startIdx);
                if (wordIdx == words.length || !words[wordIdx].equals(sub)) {
                    res.add(sub);
                } else {
                    wordIdx++;
                }

                startIdx = end + 1;

            } else if (second.charAt(end) == ' ') {

                String sub = second.substring(startIdx, end);
                if (wordIdx == words.length || !words[wordIdx].equals(sub)) {
                    res.add(sub);
                } else {
                    wordIdx++;
                }

                startIdx = end + 1;
            }

            end++;

        }

        return res;
    }
}
