package Hackerrank.Challenges.GSCodeSprint2017;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import static java.util.stream.Collectors.toMap;

public class BuyMaximumStocks {

    static long buyMaximumProducts(int n, long k, int[] a) {

        long customerFunds = k;

        Map<Integer, Integer> unsortedDayAndPriceMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < a.length; i++) {
            unsortedDayAndPriceMap.put(i + 1, a[i]);
        }

        //Sort by prices in ascending order
        Map<Integer, Integer> sortedDayAndPriceMap = new HashMap<Integer, Integer>();
        sortedDayAndPriceMap = unsortedDayAndPriceMap.entrySet().
                stream().sorted(Map.Entry.comparingByValue()).
                collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

        //Sorting will permit the implementation of a Greedy Algorithm
        long maxCount = 0L;
        for (Integer day : sortedDayAndPriceMap.keySet()) {
            if (sortedDayAndPriceMap.get(day) > customerFunds) {
                return maxCount;
            }
            maxCount += Math.min(day, (customerFunds / sortedDayAndPriceMap.get(day)));
            customerFunds -= sortedDayAndPriceMap.get(day) * Math.min(1 * day, (customerFunds / sortedDayAndPriceMap.get(day)));
        }

        return maxCount;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        in.skip("(\r\n|[\n\r\u2028\u2029\u0085\u0020])?");

        int[] arr = new int[n];
        for (int arr_i = 0; arr_i < n; arr_i++) {
            arr[arr_i] = in.nextInt();
            in.skip("(\r\n|[\n\r\u2028\u2029\u0085\u0020])?");
        }

        long k = in.nextLong();
        in.skip("(\r\n|[\n\r\u2028\u2029\u0085\u0020])?");

        long result = buyMaximumProducts(n, k, arr);
        System.out.println(result);

        in.close();
    }
}