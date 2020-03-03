package PhoneScreens.Amazon;

import java.util.*;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-05
 */
public class TopNBuzzwords {

    public static void main(String[] args) {

        List<String> toys = new ArrayList<>();
        toys.add("elmo");
        toys.add("elsa");
        toys.add("legos");
        toys.add("drone");
        toys.add("tablet");
        toys.add("warcraft");

        List<String> quotes = new ArrayList<>();
        quotes.add("Elmo is the hottest of the season! Elmo will be on every kid's wishlist!".toLowerCase());
        quotes.add("The new Elmo dolls are super high quality".toLowerCase());
        quotes.add("Expect the Elsa dolls to be very popular this year, Elsa!".toLowerCase());
        quotes.add("Elsa and Elmo are the toys I'll be buying for my kids, Elsa is good".toLowerCase());
        quotes.add("For parents of older kids, look into buying them a drone".toLowerCase());
        quotes.add("Warcraft is slowly rising in popularity ahead of the holiday season".toLowerCase());

        System.out.println(getTopKTops(2, toys, quotes));
    }

    public static List<String> getTopKTops(int k, List<String> toys, List<String> quotes) {
        /*
            The comparison of strings is case-insensitive.

            If the value of topToys is more than the number of toys,
            return the names of only the toys mentioned in the quotes.

            If toys are mentioned an equal number of times in quotes,
            sort alphabetically.
         */

        Set<String> toySet = new HashSet<>(toys);

        //We are using an array list to store the number times we see the words
        // and the number of quotes in which we see the word
        HashMap<String, int[]> toyToFreq = new HashMap<>();

        for (String quote : quotes) {
            String[] eachWord = quote.split(" ");

            Set<String> seenWords = new HashSet<>();
            for (String word : eachWord) {
                //Strip exclamation maBrk and other things that are not letters.
                if (toySet.contains(word)) {
                    toyToFreq.putIfAbsent(word, new int[2]);
                    toyToFreq.get(word)[0] += toyToFreq.get(word)[0] + 1;

                    seenWords.add(word);
                }
            }

            for (String word : seenWords) {
                toyToFreq.get(word)[1] += toyToFreq.get(word)[1] + 1;
            }
        }

        List<Toys> toysList = new ArrayList<>();
        for (Map.Entry<String, int[]> entry : toyToFreq.entrySet()) {
            toysList.add(new Toys(entry.getKey(), entry.getValue()[0], entry.getValue()[1]));
        }

        Collections.sort(toysList);
        List<String> res = new ArrayList<>();
        for (Toys eachToy : toysList) {
            if (k == 0) break;
            res.add(eachToy.name);
            k--;
        }

        return res;
    }
}

class Toys implements Comparable<Toys> {
    String name;
    int freq;
    int quoteFreq;

    Toys(String name, int freq, int quoteFreq) {
        this.name = name;
        this.freq = freq;
        this.quoteFreq = quoteFreq;
    }

    public int compareTo(Toys o) {
        int diff = o.freq - this.freq;
        return diff == 0 ? this.name.compareTo(o.name) : diff;
    }
}