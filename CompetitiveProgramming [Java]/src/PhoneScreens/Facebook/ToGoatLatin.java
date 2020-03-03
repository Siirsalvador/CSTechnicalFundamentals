package PhoneScreens.Facebook;

import java.util.StringJoiner;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-28
 */
public class ToGoatLatin {
    public String toGoatLatin(String S) {

        //word begins with vowel
        //word begins with consonant
        //append a

        StringJoiner res = new StringJoiner(" ");

        String[] words = S.split(" ");
        String appendA = "a";
        for (int i = 0; i < words.length; i++) {
            char firstChar = words[i].charAt(0);

            String w = words[i];
            if (isVowel(firstChar)) {
                w = editVowel(w);
            } else {
                w = editConsonant(w);
            }

            w = w + appendA;
            res.add(w);
            appendA += "a";
        }

        return res.toString();
    }

    private boolean isVowel(char a) {
        return a == 'a' || a == 'e' || a == 'i' || a == 'o'
                || a == 'u' || a == 'A' || a == 'E' || a == 'I'
                || a == 'O' || a == 'U';
    }

    private String editVowel(String w) {
        return w + "ma";
    }

    private String editConsonant(String w) {
        return w.substring(1, w.length()) + w.substring(0, 1) + "ma";
    }
}
