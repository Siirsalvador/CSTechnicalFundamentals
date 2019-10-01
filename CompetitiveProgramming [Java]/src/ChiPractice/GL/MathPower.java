package ChiPractice.GL;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-08-27
 */
public class MathPower {

// returns x to the power of y    ==   x ** y    ==    x ^ y

// 5 1 = 5
// 0 2 = 0
// 5 0 = 1
// 3 2 = 9

    int pow(int x, int y) {
        // your code here
        if (y == 0) return 1;

        int result = x;
        for (int i = 1; i < y; i++) {
            result *= x;
        }

        return result;
    }

    //Math.pow(5, 8) =
    //        (5 * 5 * 5 * 5) * (5 * 5 * 5 * 5) =
    //
    //        Math.pow(5, 9) =
    //        5 * 5 * 5 * 5 * 5 * 5 * 5 * 5 * 5 =
    //
    //        [0, 5, 25, 625, x, y,
    //         0   1   2   3   4  5

    // 5 1 = 5
    // 0 2 = 0
    // 5 0 = 1
    // 3 2 = 9

    //pow(5, 3)
    int pow2(int x, int y) {

        if (y == 0) return 1;

        Integer[] prevResults = new Integer[y + 1];
        prevResults[0] = 1; // [1, 5, 25, 625]
        int remaining = y; //0
        for (int i = 1; i <= y; i++) {
            if (prevResults[remaining] != null) {
                return prevResults[i - 1] * prevResults[remaining];
            }
            prevResults[i] *= prevResults[i - 1] * x; //[2] = [1] * x;
            remaining--;
        }

        return prevResults[y];
    }

}
