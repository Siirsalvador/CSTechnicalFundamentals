package DailyCodingProblem;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class DecodeMessageClass {

    private static Map<String, String> mapOfAlphabets = new TreeMap<>();
    //TreeMap insertion is O(logn)

    private static void Init() {
        mapOfAlphabets.put("1", "a");
        mapOfAlphabets.put("2", "b");
        mapOfAlphabets.put("3", "c");
        mapOfAlphabets.put("4", "d");
        mapOfAlphabets.put("5", "e");
        mapOfAlphabets.put("6", "f");
        mapOfAlphabets.put("7", "g");
        mapOfAlphabets.put("8", "h");
        mapOfAlphabets.put("9", "i");
        mapOfAlphabets.put("10", "j");
        mapOfAlphabets.put("11", "k");
        mapOfAlphabets.put("12", "l");
        mapOfAlphabets.put("13", "m");
        mapOfAlphabets.put("14", "n");
        mapOfAlphabets.put("15", "o");
        mapOfAlphabets.put("16", "p");
        mapOfAlphabets.put("17", "q");
        mapOfAlphabets.put("18", "r");
        mapOfAlphabets.put("19", "s");
        mapOfAlphabets.put("20", "t");
        mapOfAlphabets.put("21", "u");
        mapOfAlphabets.put("22", "v");
        mapOfAlphabets.put("23", "w");
        mapOfAlphabets.put("24", "x");
        mapOfAlphabets.put("25", "y");
        mapOfAlphabets.put("26", "z");
    }

    private static int getNumberOfWaysToDecodeInput(String message, int numberOfCharactersToConsider, int[] memoizationArray) {
        if (numberOfCharactersToConsider == 0) {
            return 1;
        }

        String[] messageToStringArray = message.split("");
        int startIndex = message.length() - numberOfCharactersToConsider;
        if (messageToStringArray[startIndex].equals("0")) {
            return 0;
        }

        if (memoizationArray[numberOfCharactersToConsider] != 0) {
            return memoizationArray[numberOfCharactersToConsider];
        }

        int result = getNumberOfWaysToDecodeInput(message, numberOfCharactersToConsider - 1, memoizationArray);
        if (numberOfCharactersToConsider >= 2 && Integer.parseInt(messageToStringArray[startIndex] + messageToStringArray[startIndex + 1]) < 26) {
            result = result + getNumberOfWaysToDecodeInput(message, numberOfCharactersToConsider - 2, memoizationArray);
        }
        return result;
    }

    public static void main(String[] args) {
        Init();

        String name = "Ayo";
        String[] nameArray = name.split("");
        System.out.println(Arrays.toString(nameArray));

        System.out.println(mapOfAlphabets.get(""));
        System.out.println(Arrays.toString(mapOfAlphabets.values().toArray())); //O(n)

        String message = "";
        int[] memoizationArray = new int[message.length() + 1];
        System.out.println(getNumberOfWaysToDecodeInput(message, message.length(), memoizationArray));


    }
}
