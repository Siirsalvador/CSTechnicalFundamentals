package PhoneScreens.Amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-11
 */
public class WordDistance {

    HashMap<String, ArrayList<Integer>> wordLocations;

    public WordDistance(String[] words) {
        this.wordLocations = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            wordLocations.putIfAbsent(words[i], new ArrayList<>());
            wordLocations.get(words[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        if (word1 == null || word1.isEmpty() || !wordLocations.containsKey(word1)) return 0;
        if (word2 == null || word2.isEmpty() || !wordLocations.containsKey(word2)) return 0;

        ArrayList<Integer> loc1 = wordLocations.get(word1);
        ArrayList<Integer> loc2 = wordLocations.get(word2);

        int l1 = 0;
        int l2 = 0;
        int minDistance = Integer.MAX_VALUE;

        while (l1 < loc1.size() && l2 < loc2.size()) {

            int currDist = Math.abs(loc1.get(l1) - loc1.get(l2));
            minDistance = Math.min(minDistance, currDist);

            if (loc1.get(l1) < loc1.get(l2)) {
                l1++;
            } else {
                l2++;
            }
        }

        return minDistance;
    }
}
