package Random.PhoneInputShell;

import java.util.Arrays;
import java.util.HashMap;

public class PhoneInputShell_Chinemerem {
    static HashMap<String, String> map = new HashMap();

    public static void main(String[] main) {
        initMap();
        System.out.println(Arrays.toString(generateWordsFrom("3663")));
    }

    private static StringBuilder[] generateWordsFrom(String input) {

        int lenInput = input.length();
        String[] chars = new String[lenInput];

        // Get the values from the map
        for (int i = 0; i < lenInput; i++) {
            chars[i] = map.get(input.substring(i, i + 1));
        }

        int total = getTotalCombinationsFrom(input);
        StringBuilder[] result = new StringBuilder[total];

        int charLimit = total;
        for (int pos = 0; pos < lenInput; pos++) {
            charLimit = charLimit / chars[pos].length();

            int charCount = 0;
            int currentIndex = 0;
            char currChar = chars[pos].charAt(0);

            for (int word = 0; word < total; word++) {

                if (charCount >= charLimit) {
                    currentIndex++;
                    currentIndex = currentIndex >= chars[pos].length() ? currentIndex - chars[pos].length() : currentIndex;
                    currChar = chars[pos].charAt(currentIndex);
                    charCount = 0;
                }

                StringBuilder current = result[word];
                result[word] = current == null ? new StringBuilder().append(currChar) : current.append(currChar);
                charCount++;
            }
        }

        System.out.println("ok");
        return result;
    }

    private static int getTotalCombinationsFrom(String input) {

        int total = 1;
        for (Character c : input.toCharArray()) {
            total *= map.get(c.toString()).length();
        }
        return total;
    }

    private static void initMap() {

        PhoneInputShell_Ayo.inputValuesIntoMap(map);
    }

}
