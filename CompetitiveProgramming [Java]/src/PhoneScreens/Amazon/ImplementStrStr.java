package PhoneScreens.Amazon;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-16
 */
public class ImplementStrStr {

    public static void main(String[] args) {
//        String h = "hello";
//        String n = "ll";
//        System.out.println(strStr(h, n));
//
//        String h2 = "aaaaa";
//        String n2 = "bba";
//        System.out.println(strStr(h2, n2));

        String h3 = "aaa";
        String n3 = "aaaa";
        //System.out.println(strStr(h3, n3));


        System.out.println(h3.hashCode() == n3.substring(0, 3).hashCode());
    }

    public static int strStr(String haystack, String needle) {
        if (needle == null || needle.isEmpty()) return 0;

        int hIdx = 0;
        int nIdx = 0;
        int hLen = haystack.length();
        int nLen = needle.length();
        while (hIdx < hLen) {

            if (haystack.charAt(hIdx) == needle.charAt(nIdx)) {
                //Search Idx
                int sIdx = hIdx;
                while (sIdx <= hLen && nIdx <= nLen) {
                    if (nIdx == nLen) return hIdx;
                    if (sIdx == hLen || haystack.charAt(sIdx) != needle.charAt(nIdx)) break;
                    sIdx++;
                    nIdx++;
                }

                nIdx = 0;
            }

            hIdx++;
        }

        return -1;
    }


    public int strStr2(String haystack, String needle) {
        int L = needle.length(), n = haystack.length();

        for (int start = 0; start < n - L + 1; ++start) {
            if (haystack.substring(start, start + L).equals(needle)) {
                return start;
            }
        }
        return -1;
    }
}
