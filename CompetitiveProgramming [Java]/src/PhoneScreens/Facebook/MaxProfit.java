package PhoneScreens.Facebook;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-02-14
 */
public class MaxProfit {

    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int min = prices[0];
        int diff = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > min) {
                diff = Math.max(diff, prices[i] - min);
            }

            min = Math.min(min, prices[i]);
        }

        return diff;
    }
}
