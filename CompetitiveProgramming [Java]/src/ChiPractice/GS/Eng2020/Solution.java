package ChiPractice.GS.Eng2020;

import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-08-02
 */
public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);


        int mappingCount = Integer.parseInt(sc.nextLine().trim());

        List<Integer> mapping = IntStream.range(0, mappingCount).mapToObj(i ->
                sc.nextLine().replaceAll("\\s+$", ""))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int numsCount = Integer.parseInt(sc.nextLine().trim());

        List<String> nums = IntStream.range(0, numsCount).mapToObj(i -> {
            return sc.nextLine();
        })
                .collect(toList());

        List<String> result = strangeSort(mapping, nums);

        System.out.println(String.join("\n", result)
                + "\n");

        sc.close();
    }

    public static List<String> strangeSort(List<Integer> mapping, List<String> nums) {

        HashMap<Integer, Integer> valToIdx = new HashMap<>();

        for (int i = 0; i < mapping.size(); i++) {
            valToIdx.put(mapping.get(i), i);
        }

        ArrayList<Integer> list = new ArrayList<>();

        HashMap<Integer, List<String>> val = new HashMap<>();
        HashMap<String, Integer> strToPos = new HashMap<>();

        for (int i = 0; i < nums.size(); i++) {

            strToPos.put(nums.get(i), i);

            StringBuilder stringBuilder = new StringBuilder();

            for (int j = 0; j < nums.get(i).length(); j++) {

                stringBuilder.append(valToIdx.get(Integer.parseInt(String.valueOf(nums.get(i).charAt(j)))));

            }

            List<String> stringList = val.get(Integer.parseInt(stringBuilder.toString()));

            if (stringList != null) {
                stringList.add(nums.get(i));
            } else {
                stringList = new ArrayList<>();
                stringList.add(nums.get(i));

                val.put(Integer.parseInt(stringBuilder.toString()), stringList);
            }

            list.add(Integer.parseInt(stringBuilder.toString()));
        }

        Collections.sort(list);

        List<String> res = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {

            if (val.get(i) != null) {
                res.add(val.get(i).get(0));
                val.get(i).remove(0);
            }
        }

        return res;
    }

    public int findTheRank(List<List<Integer>> values, int rank) {

        //Put the scores in a list
        //if scores a

        int size = values.get(0).size();
        ArrayList<Integer> totalScores = new ArrayList<>(size);

        for (List<Integer> scores : values) {

            for (int j = 0; j < scores.size(); j++) {

                if (totalScores.size() == 0) {
                    totalScores.add(j, scores.get(j));
                } else if (totalScores.get(j) != null) {
                    totalScores.add(j, totalScores.get(j) + scores.get(j));
                } else {
                    totalScores.add(j, scores.get(j));
                }
            }
        }

        ArrayList<Integer> tempList = totalScores;
        Collections.sort(tempList);

        int score = tempList.get(rank - 1);
        int ignore = 0;

        for (int i = 0; i < rank; i++) {
            if (tempList.contains(score)) {
                ignore++;
            }
        }

        for (int i = 0; i < totalScores.size(); i++) {
            if (totalScores.get(i) == score && ignore == 0) {
                return i;
            } else if (totalScores.get(i) == score && ignore != 0) {
                ignore--;
            }
        }

        return -1;
    }

}
