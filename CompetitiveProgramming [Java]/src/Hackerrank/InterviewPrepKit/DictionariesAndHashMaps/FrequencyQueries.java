package Hackerrank.InterviewPrepKit.DictionariesAndHashMaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-07-15
 * @link: https://www.hackerrank.com/challenges/frequency-queries/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
 */
public class FrequencyQueries {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int noOfQueries = Integer.parseInt(bufferedReader.readLine().trim());

        List<int[]> queries = new ArrayList<>();

        IntStream.range(0, noOfQueries).forEach(i ->
        {
            try {

                String[] entry = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
                int[] query = new int[2];
                query[0] = Integer.parseInt(entry[0]);
                query[1] = Integer.parseInt(entry[1]);
                queries.add(query);

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        List<Integer> ans = freqQuery(queries);
        System.out.println(ans);

        bufferedReader.close();
    }

    private static List<Integer> freqQuery(List<int[]> queries) {

        HashMap<Integer, Integer> valToFreq = new HashMap<>();
        HashMap<Integer, Integer> freqToOccurrence = new HashMap<>();

        List<Integer> frequencies = new ArrayList<>();

        for (int[] aQuery : queries) {

            int key = aQuery[0];
            Integer element = aQuery[1];

            Integer oldFreq, newFreq;
            Integer oldOccurrence, newOccurrence;

            if (key == 3) {

                if (element == 0) {
                    frequencies.add(1);
                }

                frequencies.add(freqToOccurrence.get(element) == null ? 0 : 1);
            }

            if (key == 1) {

                oldFreq = valToFreq.get(element);
                oldFreq = oldFreq == null ? 0 : oldFreq;

                oldOccurrence = freqToOccurrence.get(oldFreq);
                oldOccurrence = oldOccurrence == null ? 0 : oldOccurrence;

                if ((oldOccurrence - 1) < 1) {
                    freqToOccurrence.remove(oldFreq);
                } else {
                    freqToOccurrence.put(oldFreq, oldOccurrence - 1);
                }

                valToFreq.put(element, oldFreq + 1);

                newFreq = valToFreq.get(element);

                newOccurrence = freqToOccurrence.get(newFreq);
                newOccurrence = newOccurrence == null ? 0 : newOccurrence;

                freqToOccurrence.put(newFreq, newOccurrence + 1);
            }

            if (key == 2 && valToFreq.containsKey(element)) {

                oldFreq = valToFreq.get(element);
                oldFreq = oldFreq == null ? 0 : oldFreq;

                oldOccurrence = freqToOccurrence.get(oldFreq);
                oldOccurrence = oldOccurrence == null ? 0 : oldOccurrence;

                if ((oldOccurrence - 1) < 1) {
                    freqToOccurrence.remove(oldFreq);
                } else {
                    freqToOccurrence.put(oldFreq, oldOccurrence - 1);
                }

                newFreq = oldFreq - 1;

                if (newFreq < 1) {
                    valToFreq.remove(element);
                } else {
                    valToFreq.put(element, oldFreq - 1);
                }

                newOccurrence = freqToOccurrence.get(newFreq);
                newOccurrence = newOccurrence == null ? 0 : newOccurrence;

                freqToOccurrence.put(newFreq, newOccurrence + 1);

            }

        }

        return frequencies;
    }
}
