package CSDistilled;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-11-28
 */
public class PowerSet {

    public static void main(String[] args) {
        String word = "abc";
        System.out.println(powerSet(word));
    }

    public static Set<String> powerSet(String word) {
        ArrayList<String> res = new ArrayList<>();
        res.add("");

        for (int i = 0; i < word.length(); i++) {

            ArrayList<String> temp = new ArrayList<>();
            for (String str : res) {
                temp.add(str + word.charAt(i));
            }

            res.addAll(temp);
        }

        return new HashSet<>(res);
    }
}
