package PhoneScreens.AmazonBloombergPalantir;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-12-14
 */
public class FormatNumber {

    public static String formatNum(int num) {

        //reverse string
        //put commas at correct pos
        //reverse back

        StringBuilder builder = new StringBuilder();
        builder.append(num);
        builder.reverse();

        String reversed = builder.toString();
        builder = new StringBuilder();

        int i = 0;
        while (i < reversed.length()) {
            if (i != 0 && i % 3 == 0) builder.append(",");
            builder.append(reversed.charAt(i));
            i++;
        }

        return builder.reverse().toString();
    }

    public static String formatNumber(int num) {

        int total_processed = 0;
        String ret = "";

        while (num > 0) {
            if (total_processed != 0 && total_processed % 3 == 0)
                ret += ",";

            ret += num % 10;
            total_processed++;
            num /= 10;
        }

        return ret;
    }

    public static void main(String[] args) {
        System.out.println(formatNum(1000096));
    }
}
