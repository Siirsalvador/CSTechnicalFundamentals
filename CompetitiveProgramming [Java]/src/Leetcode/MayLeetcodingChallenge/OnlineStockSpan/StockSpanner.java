package Leetcode.MayLeetcodingChallenge.OnlineStockSpan;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: aoyekanmi
 * @date: 2020-05-19
 */
public class StockSpanner {
    List<Integer> list;

    public StockSpanner() {
        list = new ArrayList<>();
    }

    public int next(int price) {
        list.add(price);

        int lstIdx = list.size() - 1;
        int days = 0;
        for (int i = lstIdx; i >= 0; i--) {
            if (list.get(i) <= price) {
                days++;
            } else {
                break;
            }
        }
        return days;
    }

}
