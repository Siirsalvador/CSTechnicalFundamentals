package PhoneScreens.AmazonBloombergPalantir;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-12-29
 */
public class StringPowerSet {

    public static void main(String[] args) {
        String s = "1234589";
        System.out.println(powerSet(s));
    }

    public static ArrayList<String> powerSet(String s) {
        if (s == null || s.length() == 0) return new ArrayList<>();

        ArrayList<String> res = new ArrayList<>();
        res.add("");

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            ArrayList<String> temp = new ArrayList<>();
            for (String str : res) {
                temp.add(str + curr);
            }

            res.addAll(temp);
        }


        return res;
    }

    public static List<String> subset(String s) {
        if (s == null || s.isEmpty()) return new ArrayList<>();

        List<String> result = new ArrayList<>();
        result.add("abc");

        for (int i = 0; i < s.length(); i++) {

            char cur = s.charAt(i);

            List<String> tmp = new ArrayList<>();
            for (String s1 : result) {
                tmp.add(s1 + cur);
            }

            result.addAll(tmp);
        }

        return result;
    }
}
