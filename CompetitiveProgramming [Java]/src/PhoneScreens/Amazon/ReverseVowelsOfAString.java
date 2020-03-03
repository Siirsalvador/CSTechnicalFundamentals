package PhoneScreens.Amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-07
 */
public class ReverseVowelsOfAString {

    public String reverseVowels(String s) {
        if (s == null || s.isEmpty()) return "";

        char[] charArr = s.toCharArray();
        List<Integer> vowelPos = new ArrayList<>();

        for (int i = 0; i < charArr.length; i++) {
            if (isVowel(charArr[i])) vowelPos.add(i);
        }

        int start = 0;
        int end = vowelPos.size() - 1;
        while (start < end) {
            char temp = charArr[vowelPos.get(start)];
            charArr[vowelPos.get(start)] = charArr[vowelPos.get(end)];
            charArr[vowelPos.get(end)] = temp;

            start++;
            end--;
        }

        StringBuilder b = new StringBuilder();
        for (char aChar : charArr) {
            b.append(aChar);
        }

        return b.toString();
    }

    private boolean isVowel(char a) {
        return a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u' ||
                a == 'A' || a == 'E' || a == 'I' || a == 'O' || a == 'U';
    }
}
