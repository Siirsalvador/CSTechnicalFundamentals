package Firecode;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-08-27
 */
public class InsertStars {
    static int i = 0;

    public static String insertPairStar(String s) {
        if (s == null || s.isEmpty() || s.length() == 1) return s;
//        StringBuilder sb = new StringBuilder();
//        while (i < s.length()) {
//            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
//                sb.append(s.charAt(i));
//                sb.append("*");
//                i++;
//                sb.append(insertPairStar(s));
//            }else{
//                sb.append(s.charAt(i));
//                i++;
//            }
//        }
//        return sb.toString();

        return s.charAt(0) == s.charAt(1) ? s.substring(0, 1).concat("*").concat(insertPairStar(s.substring(1))) :
                s.substring(0, 1).concat(insertPairStar(s.substring(1)));
    }


    public static void main(String[] args) {
        System.out.println(insertPairStar("abbba"));
    }
}
