package DailyCodingProblem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-07-18
 */
public class DCP209_LongestCommonSubsequence {

    public static void sortLengthAscending(List<String> list) {
        list.sort(Comparator.comparingInt(String::length));
    }

    static void findLongestSubsequences(String s1, String s2, String s3) {

        //Find smallest string
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(s1);
        arrayList.add(s2);
        arrayList.add(s3);

        sortLengthAscending(arrayList);

        //Delete every character in smallest String not in other strings

        String smallest = arrayList.get(0);
        String aString = arrayList.get(1);
        String aString2 = arrayList.get(2);

        String newSmallest = deleteUncommonCharacters(smallest, aString, aString2);

        System.out.println(newSmallest);


        //Delete every character in other strings not in smallest string

        //Compare 3
    }

    private static String deleteUncommonCharacters(String smallest, String aString, String aString2) {

        StringBuilder smallBuilder = new StringBuilder(smallest);
        StringBuilder aStringBuilder = new StringBuilder(aString);
        StringBuilder aString2Builder = new StringBuilder(aString2);

        ArrayList<String> listOfIdxToKeep = new ArrayList<>();
        ArrayList<Integer> listOfIdxToDelete = new ArrayList<>();

        for (int i = 0; i < smallBuilder.toString().length(); i++) {

            String toCheck = String.valueOf(smallBuilder.charAt(i));

            int characterInaString = aStringBuilder.indexOf(toCheck);
            int characterInaString2 = aString2Builder.indexOf(toCheck);


            if (aStringBuilder.indexOf(toCheck) == -1 || aString2Builder.indexOf(toCheck) == -1) {
                listOfIdxToDelete.add(i);
                continue;
            }

            //Delete character from other strings, when it has been used for comparison
            //Delete characters before current character, so that they aren't used for comparison
            if (aStringBuilder.indexOf(toCheck) != -1 && aString2Builder.indexOf(toCheck) != -1) {
                aStringBuilder.delete(0, characterInaString + 1);
                aString2Builder.delete(0, characterInaString2 + 1);

                System.out.println(aStringBuilder.toString());
                System.out.println(aString2Builder.toString());

                listOfIdxToKeep.add(toCheck);
            }
        }

        for(int i = listOfIdxToDelete.size() - 1; i >= 0; i--){
            smallBuilder.deleteCharAt(i);
        }


        return smallBuilder.toString();
    }

    public static void main(String[] args) {

        findLongestSubsequences("epidemiologist", "refrigeration", "supercalifragilisticexpialidocious");
        //eieio
    }
}
