package Hackerrank.GSWomenCodeSprint;

import java.util.*;

public class StockExchangeMatchingAlgorithm {

    public static List<Integer> computePrices(List<Integer> s, List<Integer> p, List<Integer> q) {
        NavigableSet setOfS = new TreeSet();
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> newPriceList = new ArrayList<>();

        for (int i = 0; i < s.size(); i++) {
            setOfS.add(s.get(i));
            map.put(s.get(i), p.get(i));
        }

        for (int i = 0; i < q.size(); i++) {
            Object floorOfQ = setOfS.floor(q.get(i));
            newPriceList.add(map.get(floorOfQ));
        }
        return newPriceList;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfEntries = scanner.nextInt();

        List<Integer> s = new ArrayList<>();
        for (int i = 0; i < numberOfEntries; i++) {
            s.add(scanner.nextInt());
        }

        List<Integer> p = new ArrayList<>();
        for (int i = 0; i < numberOfEntries; i++) {
            p.add(scanner.nextInt());
        }

        int numberOfRequests = scanner.nextInt();

        List<Integer> q = new ArrayList<>();
        for (int i = 0; i < numberOfRequests; i++) {
            q.add(scanner.nextInt());
        }

        computePrices(s, p, q);
    }


}
