package PhoneScreens.AmazonBloombergPalantir;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-12-20
 */
public class TwoCityScheduling {

    public static void main(String[] args) {
        int[][] costs = {{259, 770}, {448, 54}, {926, 667}, {184, 139}, {840, 118}, {577, 469}};
        System.out.println(twoCitySchedCost2(costs));
    }

    public static int twoCitySchedCost(int[][] costs) {
        //N
        ArrayList<City> cityCost = new ArrayList<>();
        for (int[] aCost : costs) {
            cityCost.add(new City(aCost[0], aCost[1]));
        }
        Collections.sort(cityCost);

        int half = cityCost.size() / 2;
        int idx = 0;
        int cost = 0;
        while (idx < half) {
            cost += cityCost.get(idx).cityA;
            cost += cityCost.get(idx + half).cityB;
            idx++;
        }

        return cost;
    }

    public static int twoCitySchedCost2(int[][] costs) {
        // Sort by a gain which company has
        // by sending a person to city A and not to city B
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o1[1] - (o2[0] - o2[1]);
            }
        });

        int total = 0;
        int n = costs.length / 2;
        // To optimize the company expenses,
        // send the first n persons to the city A
        // and the others to the city B
        for (int i = 0; i < n; ++i) {
            total += costs[i][0] + costs[i + n][1];
        }
        return total;
    }

    public int twoCitySchedCost3(int[][] costs) {
        Arrays.sort(costs, (c1, c2) -> c1[0] - c1[1] - (c2[0] - c2[1]));

        int total = 0;
        int n = costs.length / 2;
        for (int i = 0; i < n; i++) {
            total += costs[i][0] + costs[i + n][1];
        }

        return total;
    }


}

class City implements Comparable<City> {
    int cityA;
    int cityB;

    City(int cityA, int cityB) {
        this.cityA = cityA;
        this.cityB = cityB;
    }

    public int compareTo(City o) {
        int additionalCostPerCity = (this.cityA - this.cityB);
        return additionalCostPerCity - (o.cityA - o.cityB);
    }
}