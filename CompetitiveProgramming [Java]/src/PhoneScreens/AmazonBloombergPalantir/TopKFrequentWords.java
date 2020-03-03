package PhoneScreens.AmazonBloombergPalantir;

import java.util.*;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-12-19
 */
public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        //Store words To Freq in a map
        HashMap<String, Integer> wordsToFreq = new HashMap<>();
        for (String word : words) {
            if (wordsToFreq.containsKey(word)) {
                wordsToFreq.put(word, wordsToFreq.get(word) + 1);
            } else {
                wordsToFreq.put(word, 1);
            }
        }

        ArrayList<Word> wordList = new ArrayList<>();
        //Create object with words to freq
        for (Map.Entry entry : wordsToFreq.entrySet()) {
            Word newWord = new Word((String) entry.getKey(), (Integer) entry.getValue());
            wordList.add(newWord);
        }

        //Sort object list
        Collections.sort(wordList);

        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(wordList.get(i).value);
        }

        return result;
    }

    class Word implements Comparable<Word> {
        String value;
        int freq;

        Word(String value, int freq) {
            this.value = value;
            this.freq = freq;
        }

        @Override
        public int compareTo(Word o) {
            int compare = o.freq - this.freq;
            return compare == 0 ? this.value.compareTo(o.value) : compare;
        }
    }
}
