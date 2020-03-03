package PhoneScreens.Palantir.CipherText;

import java.util.Stack;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-09-05
 */

class VarStore {
    boolean isReversed;
    int shift;
}

public class CipherText4 {
    public static void main(String[] args) {
        System.out.println(caesarCipher("he12(!l(9lo w)o!-1r)ld", 30));
    }

    private static String caesarCipher(String message, int shift) {

        if (message == null) return message;
        message = message.toLowerCase();

        StringBuilder sb = new StringBuilder();
        boolean isNegative = false;

        Stack<VarStore> storeStack = new Stack<>();
        VarStore store = new VarStore();
        store.shift = shift;
        store.isReversed = false;
        storeStack.add(store);

        for (int i = 0; i < message.length(); i++) {

            char curr = message.charAt(i);

            VarStore currStore = storeStack.peek();
            currStore.shift = currStore.shift % 26;

            String temp = String.valueOf(curr);

            if (curr == '(') {
                VarStore newStore = new VarStore();
                newStore.isReversed = storeStack.peek().isReversed;
                newStore.shift = storeStack.peek().shift;
                storeStack.add(newStore);
            }

            if (curr == ')') {
                storeStack.pop();
            }

            if (curr == '!') {
                currStore.isReversed = !currStore.isReversed;
            }

            if (isLowerCaseRelevant(curr)) {
                curr = (char) (curr + currStore.shift);
                if (curr > 'z') curr = (char) ('a' + curr - 'z' - 1);
                if (currStore.isReversed) curr = getReverse(curr);
                temp = String.valueOf(curr);
            }

            if (curr == '-') isNegative = true;

            if (Character.isDigit(curr)) {
                while (i + 1 < message.length() && Character.isDigit(message.charAt(i + 1))) {
                    temp = temp.concat(String.valueOf(message.charAt(i + 1)));
                    i++;
                }

                int num = Integer.parseInt(temp);
                if (isNegative) num *= -1;

                currStore.shift = increment(currStore.shift, num);
                isNegative = false;
            }

            sb.append(temp);
        }

        return sb.toString();

    }

    private static boolean isLowerCaseRelevant(char c) {
        return c >= 'a' && c <= 'z';
    }

    private static int increment(int total, int num) {
        return total + num;
    }

    private static char getReverse(char aChar) {
        int currNo = aChar - 'a' + 1;
        return (char) (27 - currNo - 1 + 'a');
    }
}
