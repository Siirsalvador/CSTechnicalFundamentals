package DailyCodingProblem;

import java.util.HashMap;
import java.util.Scanner;

public class DCP28_JustifiedText {

    private static void padWithExtraSpaces(String s, int lineLength) {
        String[] currentStringArray = s.split(" ");
        int wordCount = currentStringArray.length;

        /**
         * Calculate number of spaces you need (noOfNeededSpaces)
         * Calculate number of spaces slots that can be filled evenly noOfNeededSpaces / noOfSpaceSlots
         * Calculate it extra spaces need to be added noOfNeededSpaces % noOfSpaceSlots
         */
        for (int i = 0; i < currentStringArray.length; i++) {
            if (i != currentStringArray.length - 1) {
                currentStringArray[i] = currentStringArray[i].concat(" ");
            }
        }

        int noOfExtraNeededSpaces = lineLength - s.length();
        //Determine how many spaces for each slot
        int spacesForEachSlot = noOfExtraNeededSpaces / (wordCount - 1);
        int remainingSpaces = noOfExtraNeededSpaces % (wordCount - 1);
        String space = " ";

        for (int i = 0; i < wordCount - 1; i++) {
            currentStringArray[i] = currentStringArray[i].concat(DCP28_JustifiedText.repeat(" ", spacesForEachSlot));
        }

        currentStringArray[0] = currentStringArray[0].concat(DCP28_JustifiedText.repeat(" ", remainingSpaces));
    }

    private static String repeat(String str, int times) {
        StringBuilder sb = new StringBuilder(str.length() * times);
        for (int i = 0; i < times; i++)
            sb.append(str);
        return sb.toString();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //int k = scanner.nextInt();
        String sentence = scanner.nextLine();

        DCP28_JustifiedText justifiedText = new DCP28_JustifiedText();
        justifiedText.justifyText(sentence.split(" "), 16);
    }

    private void justifyText(String[] arrayOfStrings, int lineLength) {
        int currentLineWordCount = 0;
        String wordConcatForCurrentLine = "";
        HashMap<Integer, String> mapOfLinesToWords = new HashMap<>();

        /**
         * To determine the number of lines and the words on each line.
         */
        for (int i = 0; i < arrayOfStrings.length; i++) {
            currentLineWordCount += arrayOfStrings[i].length();

            if (currentLineWordCount <= lineLength) {

                wordConcatForCurrentLine = wordConcatForCurrentLine.isEmpty() ?
                        wordConcatForCurrentLine.concat(arrayOfStrings[i]) : wordConcatForCurrentLine.concat(" ".concat(arrayOfStrings[i]));

                if (mapOfLinesToWords.get(i) == null) {
                    mapOfLinesToWords.putIfAbsent(i, wordConcatForCurrentLine);
                } else {
                    mapOfLinesToWords.replace(i, wordConcatForCurrentLine);
                }

            } else {
                currentLineWordCount = 0;
                wordConcatForCurrentLine = arrayOfStrings[i];
            }
        }

        /**
         * To add required extra spaces to each line
         */
        for (int i = 0; i < mapOfLinesToWords.size(); i++) {
            if (mapOfLinesToWords.get(i).length() < lineLength) {
                padWithExtraSpaces(mapOfLinesToWords.get(i), lineLength);
            }
        }

        for (int i = 0; i < mapOfLinesToWords.size(); i++) {
            System.out.println(mapOfLinesToWords.get(i));
        }
    }

}
