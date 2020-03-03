package PhoneScreens.AmazonBloombergPalantir;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-01
 */
public class BalancedParentheses {

    static int a = 0;

    public static void main(String[] args) {
        String s = "((ab(a(c)fg)9)";
        System.out.println(balanceParentheses(s));
    }

    public static String balanceParentheses(String s) {
        if (s == null || s.isEmpty()) return null;

        boolean[] remove = new boolean[s.length()];
        int open = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open++;
            }

            if (s.charAt(i) == ')') {
                if (open > 0) open--;
                else remove[i] = true;
            }
        }


        int close = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                close++;
            }

            if (s.charAt(i) == '(') {
                if (close > 0) close--;
                else remove[i] = true;
            }
        }

        StringBuilder b = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!remove[i]) b.append(s.charAt(i));
        }

        return b.toString();
    }

    public void eat(String s){
        a = 2;
    }
}
