package ChiPractice;

public class MaxProfit {

    public static void main(String[] args) {
        int[] stocks = new int[]{2, 7, 5, 6, 1, 10, 5};

        int maxProfit = findMaxProfit(stocks);
        System.out.println(maxProfit);

        stocks = new int[]{5, 7, 19, 2, 17, 1, 10};

        maxProfit = findMaxProfit(stocks);
        System.out.println(maxProfit);
    }

    private static int findMaxProfit(int[] stocks) {

        if(stocks.length < 2)
            throw new IllegalArgumentException("No profit available, prices didn't change");

        int buy = stocks[0];
        int sell = stocks[1];
        int profit = sell - buy;

        if(stocks.length == 2)
            return profit;


        for (int i = 2; i < stocks.length; i++) {

            if (stocks[i] >= sell) {
                sell = stocks[i];
                profit = sell - buy;
            }

            if (stocks[i] < buy) {
                buy = stocks[i];

                if (i++ < stocks.length) {
                    sell = stocks[i++];
                    profit = sell - buy > profit ? sell - buy : profit;
                }
            }

        }

        return profit;
    }

}
