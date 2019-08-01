package ChiPractice.GS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-08-01
 */
public class MthMostFrequentWord {

    public HashSet<String> getMthMostFreqWords(ArrayList<String> wordList, int m) {

        HashMap<Integer, HashSet<String>> freqToWords = new HashMap<>();
        HashMap<String, Integer> wordToFreq = new HashMap<>();

        computeWordFrequencies(wordList, freqToWords, wordToFreq);

        return freqToWords.get(m);

    }

    private void computeWordFrequencies(ArrayList<String> wordList, HashMap<Integer, HashSet<String>> freqToWords, HashMap<String, Integer> wordToFreq) {
        for (String s : wordList) {

            //Checks if word exists already
            Integer freq = wordToFreq.get(s);

            if (freq == null) {

                wordToFreq.put(s, 1);
                HashSet<String> otherWordWithFreq = freqToWords.get(1);

                if (otherWordWithFreq == null) {
                    HashSet<String> hashSet = new HashSet<>();
                    hashSet.add(s);

                    freqToWords.put(1, hashSet);
                    continue;
                }

                otherWordWithFreq.add(s);
                freqToWords.put(1, otherWordWithFreq);

            } else {

                HashSet<String> oldFreqSet = freqToWords.get(freq);

                if (oldFreqSet != null ) {
                    oldFreqSet.remove(s);

                    if(oldFreqSet.size() == 0){
                        freqToWords.remove(freq);
                    }
                }

                Integer newFreq = wordToFreq.get(s) + 1;
                wordToFreq.put(s, newFreq);

                HashSet<String> newFreqSet = freqToWords.get(newFreq);

                if (newFreqSet == null) {
                    HashSet<String> hashSet = new HashSet<>();
                    hashSet.add(s);


                    freqToWords.put(freq, hashSet);

                } else {

                    newFreqSet.add(s);
                    freqToWords.put(freq, newFreqSet);
                }

            }

        }
    }
}
