package ChiPractice;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-11-29
 */
public class ChatRoomCharLimit {

    public static void main(String[] args) {
        String str = "I am a girl";
        System.out.println(getStub(str, 6));
    }

    public static String getStub(String str, int limit) {

        if (limit == 0 || str == null || str.isEmpty()) return "";
        if (limit >= str.length()) return str;

        if (str.charAt(limit - 1) == ' ') {
            return str.substring(0, limit - 1);
        }

        if (str.charAt(limit) == ' ') {
            return str.substring(0, limit);
        }

        while (str.charAt(limit) != ' ') {
            limit--;
        }

        return str.substring(0, limit);
    }
}
