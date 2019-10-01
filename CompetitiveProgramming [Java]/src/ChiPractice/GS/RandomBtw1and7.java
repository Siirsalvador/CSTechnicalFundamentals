package ChiPractice.GS;

import java.util.Random;
import java.util.Stack;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-08-01
 */
public class RandomBtw1and7 {

    private static Random random = new Random();

    private static int getRandom() {
        int randomNumber = random.nextInt(7);
        return randomNumber + 1;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(getRandom());
        }

    }
}