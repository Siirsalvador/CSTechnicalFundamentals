package PhoneScreens.AmazonBloombergPalantir;

import java.util.ArrayList;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-12-13
 */
public class SplitSentenceIntoWords {

    public static void main(String[] args) {
        String s = "   Hi my name is Ayo";
        System.out.println(splitSentence(s));
    }

    public static ArrayList<String> splitSentence(String s) {

        ArrayList<String> wordList = new ArrayList<>();

        int startIdx = 0;
        int i = 0;
        while (i < s.length()) {

            if (s.charAt(startIdx) == ' ') {
                startIdx++;
                i++;
                continue;
            }

            if (s.charAt(i) == ' ') {
                wordList.add(s.substring(startIdx, i));
                startIdx = i + 1;
            }

            if (i + 1 == s.length()) {
                wordList.add(s.substring(startIdx));
            }

            i++;
        }

        return wordList;
    }
}
