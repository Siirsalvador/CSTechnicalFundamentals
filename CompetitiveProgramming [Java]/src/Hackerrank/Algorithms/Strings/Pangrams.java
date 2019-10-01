package Hackerrank.Algorithms.Strings;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-08-08
 */
public class Pangrams {

    private static char[] alphabets = new char[26];

    private static void init(){

        int ascii = 97;

        for(int i = 0; i < alphabets.length; i++){
            alphabets[i] = (char) ascii;
            ascii++;
        }

    }

    private static String pangrams(String s){

        init();

        s = s.toLowerCase();
        boolean pangram = true;

        for (char alphabet : alphabets) {
            if (!s.contains(String.valueOf(alphabet))) {
                pangram = false;
                break;
            }
        }

        return pangram ? "pangram" : "not pangram";
    }

    public static void main(String[] args){

        System.out.println(pangrams("We promptly judged antique ivory buckles for the next prize"));
    }
}
