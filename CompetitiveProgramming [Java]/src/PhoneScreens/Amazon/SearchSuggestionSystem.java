package PhoneScreens.Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-04
 */
public class SearchSuggestionSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        if (products == null || products.length == 0) return new ArrayList<>();
        if (searchWord == null || searchWord.isEmpty()) return new ArrayList<>();

        Arrays.sort(products);
        /*
        Sort products
        For each char in search word,

        iterate over product list and add <= 3 products containing curr str to a list.

        Add list to a result list.
        */

        //what happens if searchword is empty?
        List<List<String>> result = new ArrayList<>();
        int idx = 0;
        String currStr = "" + searchWord.charAt(idx);

        while (idx < searchWord.length()) {

            List<String> temp = new ArrayList<>();
            int k = 0;

            for (String product : products) {
                if (k == 3) break;
                if (product.startsWith(currStr)) {
                    temp.add(product);
                    k++;
                }
            }

            result.add(temp);
            if (idx + 1 == searchWord.length()) break;

            idx++;
            currStr = currStr + searchWord.charAt(idx);
        }

        return result;
    }
}
