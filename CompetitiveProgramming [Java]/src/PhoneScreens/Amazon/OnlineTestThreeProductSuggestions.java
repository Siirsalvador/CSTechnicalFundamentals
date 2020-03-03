package PhoneScreens.Amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-07
 */
public class OnlineTestThreeProductSuggestions {

    public static void main(String[] args){
        int numProducts = 5;
        List<String> repository = new ArrayList<>();
        repository.add("bags");
        repository.add("baggage");
        repository.add("Banner");
        repository.add("box");
        repository.add("cloths");

        String q = "bags";

        System.out.println(threeProductSuggestions(numProducts, repository, q));
    }
    public static List<List<String>> threeProductSuggestions(int numProducts,
                                                      List<String> repository,
                                                      String customerQuery) {

        //n : repository
        //m: query
        // WRITE YOUR CODE HERE
        if (repository == null || repository.size() == 0) return new ArrayList<>();
        if (customerQuery == null || customerQuery.length() < 2) return new ArrayList<>();

        for(int i = 0; i < repository.size(); i++){ //O(n)
            String p = repository.get(i).toLowerCase();
            repository.set(i, p);
        }

        Collections.sort(repository); //O9nlogn)
        System.out.println(repository);

        customerQuery = customerQuery.toLowerCase();

        List<List<String>> result = new ArrayList<>();
        int idx = 1;
        String currStr = "" + customerQuery.charAt(0) + customerQuery.charAt(idx);

        while (idx < customerQuery.length()) { //O(m)

            List<String> temp = new ArrayList<>();
            int k = 0;

            for (String prod : repository) { //(On)
                if (k == 3) break;
                if (prod.toLowerCase().startsWith(currStr)) {
                    temp.add(prod);
                    k++;
                }
            }

            result.add(temp);
            if (idx + 1 == customerQuery.length()) break;


            idx++;
            currStr = currStr + customerQuery.charAt(idx);
        }

        return result;
    }
}
