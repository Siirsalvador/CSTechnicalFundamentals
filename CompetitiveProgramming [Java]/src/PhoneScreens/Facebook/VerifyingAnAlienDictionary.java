package PhoneScreens.Facebook;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-31
 */
public class VerifyingAnAlienDictionary {

    public static void main(String[] args) {
        String[] words = {"kuvp", "q"};
        String order = "ngxlkthsjuoqcpavbfdermiywz";
        System.out.println(isAlienSorted(words, order));

    }

    public static boolean isAlienSorted(String[] words, String order) {
        int[] alphabets = new int[26];
        for (int i = 0; i < order.length(); i++) {
            alphabets[order.charAt(i) - 'a'] = i;
        }


        for (int i = 0; i < words.length - 1; i++) {

            String word1 = words[i];
            String word2 = words[i + 1];

            int idx1 = 0;
            int idx2 = 0;

            while (idx1 < word1.length() && idx2 < word2.length()) {

                if (word1.charAt(idx1) != word2.charAt(idx2)) {
                    if (alphabets[word1.charAt(idx1) - 'a'] > alphabets[word2.charAt(idx2) - 'a'])
                        return false;

                    break;
                }

                idx1++;
                idx2++;

                if (word1.length() > word2.length())
                    return false;
            }

        }

        return true;
    }
}
