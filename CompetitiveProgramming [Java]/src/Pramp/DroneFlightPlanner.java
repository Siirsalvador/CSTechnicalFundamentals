package Pramp;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-10-19
 */
public class DroneFlightPlanner {


    static int calcDroneMinEnergy(int[][] route) {
        // your code goes here
        if(route == null || route.length < 2 || route[0].length < 3)
            return 0;

        int startPoint = route[0][2];
        int max = Integer.MIN_VALUE;

        for(int[] aRoute : route){
            if(aRoute[2] > max){
                max = aRoute[2];
            }
        }

        return max > startPoint ? max - startPoint : 0;
    }

    public static void main(String[] args) {

    }

}

/*

min =
[0,   2, 10], -> Tot = 0, curr = 10
[3,   5,  0],-> (0 > 10) Tot = Tot + (10 - 0), curr = 0 Total < min
[9,  20,  6],-> (6 > curr) Tot = 10 + (0 - 6) = 4, curr = 6 // Tot = Tot + (previous-current)
[10, 12, 15],-> (15 > curr) Tot = 4 + (6 - 15) = -5; curr = 15
[10, 10,  8] -> (8 > curr) Total = -5 + (15 - 8) = 2

*/