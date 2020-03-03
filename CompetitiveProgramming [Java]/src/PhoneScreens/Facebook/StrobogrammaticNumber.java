package PhoneScreens.Facebook;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-02-16
 */
public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        if (num == null || num.isEmpty()) return false;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            int rot = rotateNum(num.charAt(i) - '0');
            if (rot < 0) return false;
            sb.append((char) (rot + '0'));
        }

        System.out.println(sb.toString());

        return num.equals(sb.reverse().toString());
    }

    private int rotateNum(int n) {
        switch (n) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 6:
                return 9;
            case 8:
                return 8;
            case 9:
                return 6;
            default:
                return -1;
        }
    }
}
