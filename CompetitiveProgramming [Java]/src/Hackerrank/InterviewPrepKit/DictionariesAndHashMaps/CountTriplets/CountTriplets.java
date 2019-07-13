package Hackerrank.InterviewPrepKit.DictionariesAndHashMaps.CountTriplets;

import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-07-13
 */
public class CountTriplets {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(System.in);

        String[] nr = scanner.nextLine().replaceAll("\\s+$", "").split(" ");

        int arrLength = Integer.parseInt(nr[0]);
        int geoRatio = Integer.parseInt(nr[1]);

        List<Long> listOfNumbers = Stream.of(scanner.nextLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(Collectors.toList());

        Long ans = countTriplets(listOfNumbers, geoRatio);
        System.out.println(ans);

        scanner.close();

    }

    static long countTriplets(List<Long> listOfNumbers, long ratio) throws FileNotFoundException {

        HashMap<Long, Long> countMap = new HashMap<>();
        HashMap<Long, Long> tripletMap = new HashMap<>();

        long triplets = 0;

        Collections.reverse(listOfNumbers);

        for (long num : listOfNumbers) {

            if (tripletMap.containsKey(num * ratio))
                triplets = triplets + tripletMap.get(num * ratio);

            if (countMap.containsKey(num * ratio))
                tripletMap.merge(num, countMap.get(num * ratio), Long::sum);

            countMap.merge(num, 1L, Long::sum);
        }

        return triplets;
    }
}
