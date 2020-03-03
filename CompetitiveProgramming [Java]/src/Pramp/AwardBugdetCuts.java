package Pramp;

import java.util.Arrays;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-10-20
 */
public class AwardBugdetCuts {

    static double findGrantsCap(double[] grantsArray, double newBudget){

        Arrays.sort(grantsArray);

        int currSum = 0;
        double[] arrayCap = new double[grantsArray.length];

        for(int i = 0; i < grantsArray.length; i++){
            arrayCap[i] = (grantsArray[i] * (grantsArray.length - i)) + currSum;
            currSum += grantsArray[i];

            if(arrayCap[i] >= newBudget){
                double excess = arrayCap[i] - newBudget;
                int numOfPeople = grantsArray.length - i;

                return grantsArray[i] - (excess/numOfPeople);
            }
        }

        return 0.0;
    }
}
