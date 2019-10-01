package UncategorizedChallenges.PhoneInputShell;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class PhoneInputShell_Ayo {

    static HashMap<String, String> mapOfNumbers = new HashMap<>();

    public static void main(String[] args) throws IllegalArgumentException {

        initializeMap();

        if (mapOfNumbers.size() < 1) {
            throw new IllegalArgumentException("Map is empty: " + mapOfNumbers.size());
        }

        String[] numbers = {"3", "6", "6", "3"};
        ArrayList<String> actualWordStore = new ArrayList<>();
        actualWordStore.add("");
        ArrayList<String> tempWordStore = new ArrayList<>();


        for (String aNumber : numbers) {
            String numLetters = mapOfNumbers.get(aNumber);

            if (numLetters == null) {
                continue;
            }

            StringBuilder currentWord = new StringBuilder();

            for (String s : actualWordStore) {
                for (int j = 0; j < numLetters.length(); j++) {
                    currentWord.append(s);
                    currentWord.append(numLetters.charAt(j));
                    tempWordStore.add(String.valueOf(currentWord));
                    currentWord = new StringBuilder();
                }
            }
            actualWordStore = tempWordStore;
            tempWordStore = new ArrayList<>();
        }

        System.out.println(Arrays.toString(actualWordStore.toArray()));
    }

    public static void initializeMap() {
        inputValuesIntoMap(mapOfNumbers);
    }

    static void inputValuesIntoMap(HashMap<String, String> mapOfNumbers) {
        mapOfNumbers.put("2", "abc");
        mapOfNumbers.put("3", "def");
        mapOfNumbers.put("4", "ghi");
        mapOfNumbers.put("5", "jkl");
        mapOfNumbers.put("6", "mno");
        mapOfNumbers.put("7", "pqrs");
        mapOfNumbers.put("8", "tuv");
        mapOfNumbers.put("9", "wxyz");
    }
}
