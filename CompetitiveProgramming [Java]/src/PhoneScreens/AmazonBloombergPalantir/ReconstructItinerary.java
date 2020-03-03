package PhoneScreens.AmazonBloombergPalantir;

import java.util.*;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-01
 */
public class ReconstructItinerary {

    static HashMap<String, PriorityQueue<String>> staticMap;

    public static void main(String[] args) {

//        String[][] arr = {{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
//        String[][] arr = {{"JFK", "KUL"}, {"JFK", "NRT"}, {"NRT", "JFK"}};
        String[][] arr = {{"JFK", "SFO"}, {"JFK", "ATL"}, {"SFO", "ATL"}, {"ATL", "JFK"}, {"ATL", "SFO"}};
        List<List<String>> input = new ArrayList<>();
        for (String[] a : arr) {
            input.add(Arrays.asList(a));
        }

        System.out.println(findItinerary(input));
    }

    public static List<String> findItinerary(List<List<String>> tickets) {

        List<String> result = new ArrayList<>();
        if (tickets == null || tickets.size() == 0) return result;

        HashMap<String, PriorityQueue<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            map.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            map.get(ticket.get(0)).offer(ticket.get(1));
        }

        if (!map.containsKey("JFK")) return result;

        dfs("JFK", map, result);
        return result;
    }


    private static void dfs(String start, HashMap<String, PriorityQueue<String>> map, List<String> res) {
        PriorityQueue<String> pq = map.get(start);
        while (pq != null && !pq.isEmpty()) {
            dfs(pq.poll(), map, res);
        }
        res.add(0, start);
    }
}
