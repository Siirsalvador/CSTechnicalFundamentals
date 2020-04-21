package PhoneScreens.Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-08
 */
public class CriticalConnections {

    public static void main(String[] args) {

        int[][] edges = {{1, 2}, {1, 3}, {3, 4}, {1, 4}, {4, 5}};

        List<List<Integer>> conns = new ArrayList<>();
        for (int[] edge : edges) {
            List<Integer> sub = new ArrayList<>();
            sub.add(edge[0]);
            sub.add(edge[1]);
            conns.add(sub);
        }

        System.out.println(criticalConnections(4, conns));
    }

    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> conns) {

        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < graph.length; i++) graph[i] = new ArrayList<>();
        for (List<Integer> conn : conns) {
            graph[conn.get(0)].add(conn.get(1));
            graph[conn.get(1)].add(conn.get(0));
        }

        boolean[] visited = new boolean[n];
        int[] timeStamp = new int[n];
        int[] time = new int[1];

        List<List<Integer>> result = new ArrayList<>();
        criticalConnsUtil(graph, -1, 0, visited, timeStamp, time, result);

        return result;
    }

    private static void criticalConnsUtil(List<Integer>[] graph, int parent, int node, boolean[] visited, int[] timestampAt, int[] time, List<List<Integer>> result) {

        visited[node] = true;
        timestampAt[node] = time[0]++;

        int currTime = timestampAt[node];

        for (int adj : graph[node]) {
            if (adj == parent) continue;

            if (!visited[adj]) {
                criticalConnsUtil(graph, node, adj, visited, timestampAt, time, result);
            }

            timestampAt[node] = Math.min(timestampAt[node], timestampAt[adj]);
            if (currTime < timestampAt[adj]) {
                result.add(new ArrayList<>(Arrays.asList(node, adj)));
            }
        }
    }
}
