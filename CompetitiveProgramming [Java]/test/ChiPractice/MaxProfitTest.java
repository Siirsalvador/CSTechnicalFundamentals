package ChiPractice;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxProfitTest {


    @Test
    public void findMaxProfitTest() {

        MaxProfit maxProfit = new MaxProfit();

        int[] stockPrices = new int[]{2, 7, 5, 6, 1, 10, 5};
        int actualMaxProfit = maxProfit.findMaxProfit(stockPrices);

        assertEquals(9, actualMaxProfit);

    }
}