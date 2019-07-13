package Hackerrank.InterviewPrepKit.DictionariesAndHashMaps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class SherlockandAnagrams {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int queries = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        SherlockandAnagrams findAnagrams = new SherlockandAnagrams();

        for (int queryItr = 0; queryItr < queries; queryItr++) {
            String word = scanner.nextLine();
            int result = findAnagrams.sherlockAndAnagrams(word);
            System.out.println(result);
        }

        scanner.close();

    }

    int sherlockAndAnagrams(String word) {

        /*
            7 -> aaaaaaa

            6: a (aaaaaa)
            5: a (aaaaa)
            4: a (aaaa)
            3: a (aaa)
            2: a (aa)
            1: a (a)

            6+5+4+3+2+1

         */

        HashMap<String, Integer> substringMap = findAllSubstrings(word);
        int count = 0;

        for (String aWord : substringMap.keySet()) {
            int subCount = substringMap.get(aWord);
            subCount = subCount - 1;
            int tempCount = 0;

            while (subCount >= 1) {
                tempCount += subCount;
                subCount--;
            }

            count += tempCount;
        }

        return count;
    }

    static HashMap<String, Integer> findAllSubstrings(String word) {

        HashMap<String, Integer> substringMap = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            for (int j = i + 1; j <= word.length(); j++) {

                char[] charArr = word.substring(i, j).toCharArray();
                Arrays.sort(charArr);

                String sortedString = String.valueOf(charArr);

                if (substringMap.containsKey(sortedString)) {
                    substringMap.put(sortedString, substringMap.get(sortedString) + 1);
                } else {
                    substringMap.put(sortedString, 1);
                }

            }
        }

        return substringMap;
    }

}
