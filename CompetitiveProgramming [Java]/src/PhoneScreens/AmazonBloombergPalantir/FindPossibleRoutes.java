package PhoneScreens.AmazonBloombergPalantir;

import java.util.*;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-12-20
 */
public class FindPossibleRoutes {

    public static void main(String[] args) {
        char[][] chars = {{'A', 'B'}, {'A', 'C'}, {'A', 'D'}, {'B', 'C'}, {'B', 'D'}};
        char start = 'C', end = 'D';
        System.out.println(getPossibleRoutes(chars, start, end));

    }

    public static List<List<Character>> getPossibleRoutes(char[][] paths, char start, char end) {
        if (paths == null || paths.length == 0) return new ArrayList<>();

        Map<Character, List<Character>> graph = new HashMap<>();
        for (char[] path : paths) {
            graph.putIfAbsent(path[0], new ArrayList<>());
            graph.putIfAbsent(path[1], new ArrayList<>());

            graph.get(path[0]).add(path[1]);
            graph.get(path[1]).add(path[0]);
        }


        /*
            Start Creating a Path with C. Use A Stack
            Add All adjacent nodes not in their "visited" context
            Return a Path when It has reached destination
         */
        Stack<Path> pathStack = new Stack<>();

        List<Character> firstAdjs = graph.get(start);
        for (Character adj : firstAdjs) {
            Path path = new Path();
            path.addAdj(start);
            path.addAdj(adj);

            path.visit(start);
            path.visit(adj);
            pathStack.push(path);
        }

        List<Path> pathResult = new ArrayList<>();
        while (!pathStack.isEmpty()) {
            Path path = pathStack.pop();

            int lastIdx = path.getLastIdx();
            char lastChar = path.getCharacter(lastIdx);
            if (lastChar == end) {
                pathResult.add(path);
                continue;
            }

            List<Character> adjs = graph.get(lastChar);
            for (Character adj : adjs) {
                Path newPath = new Path();
                newPath.resetListAndSet(path.path);

                if (newPath.visit(adj)) {
                    newPath.addAdj(adj);
                    pathStack.add(newPath);
                }
            }
        }

        List<List<Character>> res = new ArrayList<>();
        for (Path path : pathResult) {
            res.add(path.path);
        }
        return res;
    }

    static class Path {
        List<Character> path;
        Set<Character> visited;

        Path() {
            path = new ArrayList<>();
            visited = new HashSet<>();
        }

        void addAdj(Character c) {
            path.add(c);
        }

        int getLastIdx() {
            return path.size() - 1;
        }

        Character getCharacter(int idx) {
            return path.get(idx);
        }

        boolean visit(Character c) {
            return visited.add(c);
        }

        void resetListAndSet(List<Character> c) {
            path = new ArrayList<>(c);
            visited = new HashSet<>(c);
        }
    }
}
