package PhoneScreens.AmazonBloombergPalantir;

import java.util.Stack;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-12-31
 */
public class CandyCrush {

    public static void main(String[] args) {

        CandyCrush candyCrush = new CandyCrush();

        System.out.println(candyCrush.crushTheCandy("aaabbbc"));
        System.out.println(candyCrush.crushTheCandy("aabbbacd"));
        System.out.println(candyCrush.crushTheCandy("aabbccddeeedcba"));
        System.out.println(candyCrush.crushTheCandy("aaabbbacd"));
        System.out.println(candyCrush.crushTheCandy("baaabbbabbccccd"));
    }

    /*


        abbd


     */

    public String crushTheCandy(String str) {


        str = str + "#";
        /*
           Maintain a stack
           Store a letter object
           loop through string:
            if character is equal to character at the top, increment count
            if character is not equal:
                check if count of stack top is >= 3 if yes, pop letter
                add character to stack (check if it matches what is at the top of the stack first
         */
        Stack<Letter> letters = new Stack<>();
        for (Character c : str.toCharArray()) {

            if (!letters.isEmpty() && c == letters.peek().aChar) {
                letters.peek().frequency += 1;
            } else if (!letters.isEmpty() && c != letters.peek().aChar) {

                if (letters.peek().frequency >= 3) letters.pop();

                if (!letters.isEmpty() && letters.peek().aChar == c) letters.peek().frequency += 1;
                else letters.add(new Letter(c, 1));

            } else {
                letters.add(new Letter(c, 1));
            }

        }

        letters.pop();

        StringBuilder builder = new StringBuilder();
        while (!letters.isEmpty()) {

            Letter curr = letters.pop();

            for (int i = 0; i < curr.frequency; i++) {
                builder.append(curr.aChar);
            }
        }

        return builder.reverse().toString();
    }
}

class Letter {
    Character aChar;
    int frequency;

    Letter(Character aChar, int frequency) {
        this.aChar = aChar;
        this.frequency = frequency;
    }

}