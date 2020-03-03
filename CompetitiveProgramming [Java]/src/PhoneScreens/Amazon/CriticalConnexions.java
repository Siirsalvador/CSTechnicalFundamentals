package PhoneScreens.Amazon;

import java.util.*;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-08
 */
public class CriticalConnexions {

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (List<Integer> edge : connections) {
            graph[edge.get(0)].add(edge.get(1));
            graph[edge.get(1)].add(edge.get(0));
        }

        boolean[] visited = new boolean[n];
        int[] timestampAt = new int[n];
        int[] time = new int[1];

        Set<List<Integer>> result = new HashSet<>();
        connUtil(graph, -1, 0, visited, timestampAt, time, result);

        return new ArrayList<>(result);
    }

    private void connUtil(List<Integer>[] graph, int parent, int node, boolean[] visited, int[] timestampAt, int[] time, Set<List<Integer>> result) {

        visited[node] = true;
        timestampAt[node] = time[0]++;
        int currTime = timestampAt[node];

        for (int adj : graph[node]) {
            if (adj == parent) continue;

            if (!visited[node])
                connUtil(graph, node, adj, visited, timestampAt, time, result);

            timestampAt[node] = Math.min(timestampAt[node], timestampAt[adj]);

            if (currTime < timestampAt[adj]) {
                result.add(new ArrayList<>(Arrays.asList(node, adj)));
            }
        }


    }
}
