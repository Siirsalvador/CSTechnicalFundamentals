package ChiPractice;


/*
 * Eliminate duplicate consecutive words from a huge string
 * E.g. Input  : aaaaabbbbbb   Output : ab
 * aaabbbabb - abab
 */

public class Duplicates {
    public static void main(String[] args) {

    }

    private static String remove(String input) {

        // string builder to hold unique characters
        StringBuilder sb = new StringBuilder();

        // hold the current char being considered
        Character current = null;

        //loop through to obtain unique characters
        for (char c : input.toCharArray()) {

            if (current == null) { //first pass
                current = c;
                continue;
            }

            //adds only unique chars
            if (current != c) {
                sb.append(current);
                current = c;
            }
        }

        sb.append(current); //append last unique char
        return sb.toString();
    }
}
