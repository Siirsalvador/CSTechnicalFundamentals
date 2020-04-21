package Hackerrank;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-03-16
 */

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FreqQueries {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        //int to freq
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> freqMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (List<Integer> query : queries) {
            int op = query.get(0);
            if (op == 1)
                insertIntoMap(query.get(1), map, freqMap);
            else if (op == 2)
                deleteFromMap(query.get(1), map, freqMap);
            else if (op == 3)
                doesFreqExist(query.get(1), freqMap, result);
        }

        System.out.println(queries);
        System.out.println(result);
        return result;
    }

    private static void insertIntoMap(int n, Map<Integer, Integer> map, Map<Integer, Integer> freqMap) {

        map.putIfAbsent(n, 0);
        if (map.get(n) > 0) {
            int val = map.get(n);
            freqMap.put(val, freqMap.get(val) - 1);
        }

        map.put(n, map.get(n) + 1);
        int newVal = map.get(n);
        freqMap.putIfAbsent(newVal, 0);
        freqMap.put(newVal, freqMap.get(newVal) + 1);
    }

    private static void deleteFromMap(int n, Map<Integer, Integer> map, Map<Integer, Integer> freqMap) {
        map.putIfAbsent(n, 0);
        if (map.get(n) > 0) {
            int freq = map.get(n);

            map.put(n, map.get(n) - 1);
            freqMap.put(freq, freqMap.get(freq) - 1);

            freq = map.get(n);
            freqMap.putIfAbsent(freq, 0);
            freqMap.put(freq, freqMap.get(freq) + 1);
        }
    }

    private static void doesFreqExist(int n, Map<Integer, Integer> freqMap, List<Integer> result) {

        if (freqMap.containsKey(n) && freqMap.get(n) > 0) {
            result.add(1);
        } else {
            result.add(0);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/Users/aoyekanmi/code/CSTechnicalFundamentals/CompetitiveProgramming [Java]/src/Hackerrank/output"));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });


        List<Integer> ans = freqQuery(queries);
        System.out.println(ans.size());

        List<Integer> res = new ArrayList<>();

        IntStream.range(0, 33246).forEach(i -> {
            try {
                res.add(Integer.parseInt(
                        bufferedReader.readLine().replaceAll("\\s+$", "")));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedWriter.write(
                ans.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        for (int i = 0; i < ans.size(); i++) {
            if (!ans.get(i).equals(res.get(i))) {
                System.out.println("Gotten: " + ans.get(i) + ";" + " Expected: " + res.get(i));
            }

        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
