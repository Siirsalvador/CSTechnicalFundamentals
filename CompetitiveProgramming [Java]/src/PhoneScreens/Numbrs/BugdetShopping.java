package PhoneScreens.Numbrs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-03-10
 */
public class BugdetShopping {
}

class Result {

    /*
     * Complete the 'budgetShopping' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY bundleQuantities
     *  3. INTEGER_ARRAY bundleCosts
     */

    public static int budgetShopping(int n, List<Integer> bundleQuantities, List<Integer> bundleCosts) {

        if (bundleQuantities.size() != bundleCosts.size()) return 0;

        List<BookPrice> list = new ArrayList<>();
        for (int i = 0; i < bundleQuantities.size(); i++) {
            float bookPrice = (float) bundleCosts.get(i) / (float) bundleQuantities.get(i);
            BookPrice curr = new BookPrice(bookPrice, i);
            list.add(curr);
        }

        Collections.sort(list);
        int maxNoOfBooks = 0;
        int currIdx = 0;

        while (currIdx < list.size()) {
            BookPrice curr = list.get(currIdx);
            int idx = curr.idx;

            if (bundleCosts.get(idx) <= n) {
                n -= bundleCosts.get(idx);
                maxNoOfBooks += bundleQuantities.get(idx);
            }

            if (n >= bundleCosts.get(idx)) continue;
            currIdx++;
        }

        return maxNoOfBooks;
    }

}

class BookPrice implements Comparable<BookPrice> {
    float bookPrice;
    int idx;

    BookPrice(float bookPrice, int idx) {
        this.bookPrice = bookPrice;
        this.idx = idx;
    }

    @Override
    public int compareTo(BookPrice bp) {
        return Float.compare(this.bookPrice, bp.bookPrice);

    }
}