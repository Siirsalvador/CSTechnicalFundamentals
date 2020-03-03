package PhoneScreens.AmazonBloombergPalantir;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-12-19
 */
public class StringEncoding {

    public static void main(String[] args){
        String s = "aaaaabbbccd";
        System.out.println(encodeString(s));
    }

    public static String encodeString(String str) {

        char currChar = str.charAt(0);
        int count = 1;

        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < str.length(); i++) {

            if (str.charAt(i) == currChar) {
                count++;
            } else {

                builder.append(currChar);
                builder.append(count);
                currChar = str.charAt(i);
                count = 1;


                if (i + 1 == str.length()) {
                    builder.append(currChar);
                    builder.append(count);
                }
            }
        }

        return builder.toString();
    }
}
