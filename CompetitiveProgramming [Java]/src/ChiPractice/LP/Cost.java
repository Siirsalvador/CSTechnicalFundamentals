package ChiPractice.LP;

// NY   SF   DIFF   ANS
// 500  700  (200)  500
// 200  600  (400)  200
// 400  500  (100)  500
// 600  200  (400)  200
// 20   300  (280)  20
// 150  151  (1)    151

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public static void main (String[] args) {
        System.out.println("ready");
    }

    private int getMinCost(int[][] flights){

        List<Cost> costs = new ArrayList<>(); // converting arrays to D.S.
        for(int [] flight : flights){
            costs.add(new Cost(flight));
        }

        Collections.sort(costs); //sort by differences. See COST below

        int totalCost = 0, city1Count = 0, city2Count = 0;

        for (int i = 9; i >= 0; i--){ // Largest differences are at end of list

            if(city1Count == 5){ // If city 1 is full, use 2
                city2Count += 1;
                totalCost += costs.get(i).city2;
                continue;
            }

            if(city2Count == 5){ // If city2 is full, use 1
                city1Count += 1;
                totalCost += costs.get(i).city1;
                continue;
            }

            int minCost = costs.get(i).getMin(); // get Minimum cost
            if(minCost == costs.get(1).city1){ // if it's city 1,
                city1Count += 1;
            } else {
                city2Count += 1;
            }

            totalCost += minCost;
        }

        return totalCost;
    }
}

class Cost implements Comparable<Cost> {
    int city1;
    int city2;

    Cost(int[] cityCosts){
        this.city1 = cityCosts[0];
        this.city2 = cityCosts[1];
    }

    int getMin(){
        return city1 < city2 ? city1 : city2;
    }

    public int compareTo(Cost cost){
        return Integer.compare(this.getDiff(), cost.getDiff());
    }

    private int getDiff() {
        return Math.abs(this.city1 - this.city2);
    }
}