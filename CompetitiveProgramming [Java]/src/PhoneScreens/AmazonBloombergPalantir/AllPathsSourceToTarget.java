package PhoneScreens.AmazonBloombergPalantir;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-12-13
 */
public class AllPathsSourceToTarget {

    public static void main(String[] args) {
        int[][] graph = {{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
        //System.out.println(allPathsSourceTarget(graph));

        //[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]

        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(109);

        for (int i = 0; i < l.size(); i++) {
            if(l.get(i) % 2 == 0) l.add(l.get(i) + 1);
            System.out.println(l.get(i));
        }
    }

    public static List<List<Integer>> allPathsSourceTarget2(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        cur.add(0);
        dfs(0, graph, cur, result);
        return result;
    }

    public static void dfs(int position, int[][] graph, List<Integer> cur, List<List<Integer>> result) {
        if (position == graph.length - 1) {
            result.add(new ArrayList<>(cur));
            return;
        }

        int[] edges = graph[position];
        for (int i : edges) {
            cur.add(i);
            dfs(i, graph, cur, result);
            cur.remove(cur.size() - 1);
        }
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        int dest = graph.length - 1;
        List<List<Integer>> allPaths = new ArrayList<>();

        Stack<Path> eachPath = new Stack<>();
        int[] initial = graph[0];

        for (int num : initial) {
            List<Integer> zeroPath = new ArrayList<>();
            zeroPath.add(0);
            zeroPath.add(num);

            Path path = new Path();
            path.path = zeroPath;

            eachPath.add(path);
        }


        //from 0, use a stack to store all paths
        //for each of it's connections, update stack objects
        //until we reach a node == graph.length - 1 or a boundary
        while (!eachPath.isEmpty()) {
            Path curr = eachPath.pop();

            int lastIdx = curr.path.size() - 1;
            if (curr.path.get(lastIdx) == dest) {
                allPaths.add(curr.path);
                continue;
            }

            int edgeIdx = curr.path.get(curr.path.size() - 1);
            int[] edges = graph[edgeIdx];
            for (int num : edges) {
                if (num == edgeIdx) continue;
                Path path = new Path();
                path.path = new ArrayList<>(curr.path);
                path.path.add(num);
                eachPath.add(path);
            }
        }

        return allPaths;
    }

    static class Path {
        List<Integer> path;

        Path() {
        }
    }
}
