package PhoneScreens.GoldmanSachs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class TradingDigits implements Comparable<TradingDigits> {

    private int idx;
    private String jumbledDigit;
    private int mappedDigit;

    void setIdx(int idx) {
        this.idx = idx;
    }

    void setMappedDigit(int digit) {
        this.mappedDigit = digit;
    }

    String getJumbledDigit() {
        return this.jumbledDigit;
    }

    void setJumbledDigit(String digit) {
        this.jumbledDigit = digit;
    }

    @Override
    public int compareTo(TradingDigits o) {
        int sameMapped = this.mappedDigit - o.mappedDigit;
        return sameMapped == 0 ? this.idx - o.idx : sameMapped;
    }
}

public class StrangeSorting {

    private static List<String> strangeSort(List<Integer> mapping, List<String> nums) {

        HashMap<Integer, Integer> mappingToIdx = new HashMap<>();

        for (int i = 0; i < mapping.size(); i++) {
            mappingToIdx.put(mapping.get(i), i);
        }

        List<TradingDigits> tradingDigits = new ArrayList<>();

        for (int i = 0; i < nums.size(); i++) {
            String num = nums.get(i);

            TradingDigits digits = new TradingDigits();
            digits.setIdx(i);
            digits.setJumbledDigit(num);

            int mappedDigit = getMappedDigit(num, mappingToIdx);
            digits.setMappedDigit(mappedDigit);

            tradingDigits.add(digits);
        }

        Collections.sort(tradingDigits);

        List<String> digits = new ArrayList<>();

        for (TradingDigits tradingDigit : tradingDigits) {
            digits.add(tradingDigit.getJumbledDigit());
        }

        return digits;

    }

    private static int getMappedDigit(String jumbledDigit, HashMap<Integer, Integer> mappingToIdx) {

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < jumbledDigit.length(); i++) {
            int aDigit = mappingToIdx.get(Integer.parseInt(String.valueOf(jumbledDigit.charAt(i))));
            stringBuilder.append(aDigit);
        }

        return Integer.parseInt(stringBuilder.toString());
    }

    public static void main(String[] args) {

        List<Integer> mapping = new ArrayList<>();
        mapping.add(3);
        mapping.add(5);
        mapping.add(4);
        mapping.add(6);
        mapping.add(2);
        mapping.add(7);
        mapping.add(9);
        mapping.add(8);
        mapping.add(0);
        mapping.add(1);

        List<String> nums = new ArrayList<>();
        nums.add("990");
        nums.add("332");
        nums.add("32");

        System.out.println(strangeSort(mapping, nums));
    }
}