package ChiPractice.GL;

import java.util.regex.Pattern;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-08-08
 */
public class EmailRegex {
    public static void main(String[] args) {
        //https://regexr.com/

        String regex = "[a-zA-Z0-9]+@[a-zA-Z0-9]+(\\.[a-zA-Z]{2,4}){2}";
        String test = "ayo@gmail.co.za.9.0.8";

        System.out.println(Pattern.compile(regex).matcher(test).matches());
    }
}