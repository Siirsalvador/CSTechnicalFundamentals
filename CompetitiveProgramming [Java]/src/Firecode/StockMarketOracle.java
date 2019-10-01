package Firecode;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-09-03
 */
public class StockMarketOracle {
    public static int maxProfit(int[] a) {
        int profit = 0;

        for (int i = 1; i < a.length; i++) {
            if (a[i] > a[i - 1] && a[i] - a[i - 1] > 0) {
                profit += a[i] - a[i - 1];
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        int[] arr = {0, 100, 0, 100, 0, 100};
        System.out.println(maxProfit(arr));
    }
}
