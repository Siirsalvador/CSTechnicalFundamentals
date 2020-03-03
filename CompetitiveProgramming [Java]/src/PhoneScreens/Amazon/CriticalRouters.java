package PhoneScreens.Amazon;

import java.util.*;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-08
 */
public class CriticalRouters {

    public static void main(String[] args) {

        //int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 5}, {5, 6}, {3, 4}};

        //int[][] edges = {{1, 2}, {1, 3}, {3, 4}, {1, 4}, {4, 5}};

        int[][] edges = {{1, 2}, {1, 3}, {2, 3}, {3, 4}, {3, 6}, {4, 5}, {6, 7}, {6, 9}, {7, 8}, {8, 9}};
        System.out.println(findArticulationPoints(edges));
    }

    public static List<Integer> findArticulationPoints(int[][] egdes) {

        // Create Graph as Adjacency List
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : egdes) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());

            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        //Create visited set to store nodes we have visted
        Set<Integer> visited = new HashSet<>();
        //Create map to store the time each node is visited. If a node visits an earlier node, update its
        //time to the time of the earlier node
        HashMap<Integer, Integer> visitedTime = new HashMap<>();

        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            visitedTime.putIfAbsent(entry.getKey(), 0);
        }

        //Set of Articulation Points
        Set<Integer> aPoints = new HashSet<>();
        //Time we visit each node
        int[] time = new int[1];
        articulationUtil(graph, -1, 1, visited, visitedTime, aPoints, time);

        return new ArrayList<>(aPoints);
    }

    private static void articulationUtil(HashMap<Integer, List<Integer>> graph, int parent, int node, Set<Integer> visited, HashMap<Integer, Integer> visitedTime, Set<Integer> aPoints, int[] time) {

        //Add node to set as visited
        visited.add(node);
        //Store time node is visited
        visitedTime.put(node, time[0]++); //1 : 3

        int currTime = visitedTime.get(node);

        //Traverse each adjacent node of current node
        for (int adj : graph.get(node)) {
            if (adj == parent) continue;

            //if node hasn't been visited, vist it NOW.
            if (!visited.contains(adj)) {
                articulationUtil(graph, node, adj, visited, visitedTime, aPoints, time);
            }

            //Update node's time to time of adjacent node if its node is smaller
            visitedTime.put(node, Math.min(visitedTime.get(node), visitedTime.get(adj)));

            //if old time of curr node is less than low time of last node, it's is an articulation point.
            if (currTime < visitedTime.get(adj)) {
                aPoints.add(node);
            }

        }
    }

}
