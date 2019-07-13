package Hackerrank.InterviewPrepKit.Graphs;

import java.util.*;

public class RoadsandLibraries {

    private static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
        /**
         *
         * We need a map of roads to a set of roads they are connected to
         * For each  [i][0] [i][1]:
         *
         * Cities: {{1,2},{4,2},{2,3},{3,1}}
         * Visited: [1, 2, 4, 3]
         * Map: [
         *     1 = {2}
         *     2 = {4, 3}
         * ]
         *
         * If neither have been visited:
         * Create 0 as key, add 1 to its Hashset
         * Add both to Visited Hashset
         * Increase minLibs count by 1
         *
         * if [0] has not been visited:
         * check if [i][1] is a key:
         *  if YES: add [i][0] to its Hashset, Add [i][0] to Visited cities
         *  if NO:
         *      create [i][1] as a key and add [i][0] to its HashSet, Add [i][0] to Visited Cities
         *
         * if [1] has not been visited:
         * check if [i][0] is a key:
         * if YES: add [i][1] to its Hashset, Add [i][1] to Visited cities
         * if NO:
         *      create [i][0] as a key and add [i][1] to its HashSet, Add [i][1] to Visited Cities
         *
         *
         * Get( minRoads * c_road ) + ( minLibs * c_lib )
         * Get (visited * c_libs)
         * return which is less
         */

        Set<Integer> visitedCities = new HashSet<>();
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        int minLibs = 0, minRoads = 0;

        for (int[] city : cities) {

            int firstCity = city[0];
            int secCity = city[1];

            if (secCity < firstCity) {
                int temp = firstCity;
                firstCity = secCity;
                secCity = temp;
            }

            if (!visitedCities.contains(firstCity) && !visitedCities.contains(secCity)) {

                HashSet<Integer> set = new HashSet<>();
                set.add(secCity);
                graph.put(firstCity, set);

                visitedCities.add(firstCity);
                visitedCities.add(secCity);

                minLibs++;
                minRoads++;
                continue;
            }

            //Checks if the smaller city is a key, and makes sure the bigger city has been visited already
            if (!graph.containsKey(firstCity) && !visitedCities.contains(secCity)) {
                visitCity(visitedCities, graph, secCity, firstCity);
                minRoads++;
                continue;
            }

            //{{3,5}, {5,1}, {5,2}}
            //Uses the bigger city as key, if it has been visited already, and smaller city is not a key
            if (!graph.containsKey(firstCity) && visitedCities.contains(secCity)) {
                visitCity(visitedCities, graph, firstCity, secCity);
                minRoads++;
                continue;
            }


            if (!visitedCities.contains(secCity)) {
                graph.get(firstCity).add(secCity);
                minRoads++;
            }

        }

        long firstOption;
        if (visitedCities.size() != n) {
            minLibs += (n - visitedCities.size());
            firstOption = (long) (minRoads * c_road) + (long) (minLibs * c_lib);
        } else {
            firstOption = (long) (minRoads * c_road) + (long) (minLibs * c_lib);
        }

        long secondOption = (long) n * c_lib;

        return (firstOption < secondOption) ? firstOption : secondOption;
    }

    private static void visitCity(Set<Integer> visitedCities, Map<Integer, Set<Integer>> graph,
                                  int secCity, int firstCity) {

        Set<Integer> set = graph.get(firstCity);
        if(set == null){
            set = new HashSet<>();
        }
        set.add(secCity);
        graph.put(firstCity, set);

        visitedCities.add(firstCity);
        visitedCities.add(secCity);

    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        /*
            1
            3 3 2 1
            1 2
            3 1
            2 3
         */
        int q = scanner.nextInt(); //1
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

//        n = number of cities; m = number of bidirectional roads; CLib = cost of building a library; CRoad = cost of building a road
        for (int queryIterator = 0; queryIterator < q; queryIterator++) {

            String[] nmCLibCRoad = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nmCLibCRoad[0]); // 3

            int m = Integer.parseInt(nmCLibCRoad[1]);

            int c_lib = Integer.parseInt(nmCLibCRoad[2]);

            int c_road = Integer.parseInt(nmCLibCRoad[3]);

            int[][] cities = new int[m][2];
            //If m = 3, P.S. A max of 2 cities can be connected by a bidirectional road
            //{{1,2},{2,3},{1,3}}

            //For each road
            for (int i = 0; i < m; i++) {

                //"2 3"
                String[] citiesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");


                for (int j = 0; j < 2; j++) {
                    int citiesItem = Integer.parseInt(citiesRowItems[j]);
                    cities[i][j] = citiesItem;
                    //{{2,3}}
                }
            }

            long result = roadsAndLibraries(n, c_lib, c_road, cities);
            System.out.println(result);
        }

        scanner.close();
    }
}
