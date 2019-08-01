package ChiPractice.GS;

import java.util.Random;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-08-01
 */
public class RandomBtw1and7 {

    private Random random = new Random();

    int getRandom() {
        int randomNumber = random.nextInt(7);
        return randomNumber + 1;
    }
}