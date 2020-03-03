package Firecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-10-30
 */
public class Ipv4Addresses {

    public static void main(String[] args) {
        String test = "192168010";
        String[] r = test.split(":");
        System.out.println(generateIPAddrs(test));

    }

    public static ArrayList<String> generateIPAddrs(String s) {
        if (s == null || s.length() < 4) return null;

        ArrayList<String> res = new ArrayList<>();

        Stack<IpLevelNode> nodes = new Stack<>();

        //Prefill stack with first 3 possible inputs
        for (int i = 1; i < 4; i++) {
            String predecessor = s.substring(0, i);
            IpLevelNode node = new IpLevelNode(predecessor, s.substring(i), 1, predecessor.length());
            if (stringMeetsCriteria(s.substring(0, i)))
                nodes.add(node);
        }

        while (!nodes.isEmpty()) {
            IpLevelNode curr = nodes.pop();

            if (curr.level == 4 && curr.remainder.isEmpty()) {
                res.add(curr.prefix);
                continue;
            }

            int len = curr.prefixLength;
            for (int i = 1; i <= 3; i++) {
                if (len + i <= s.length()) {

                    IpLevelNode newNode = new IpLevelNode();
                    String substring = s.substring(len, len + i);
                    newNode.prefix = curr.prefix.concat(".").concat(substring);
                    newNode.prefixLength = curr.prefixLength + substring.length();
                    newNode.remainder = s.substring(len + i);
                    newNode.level = curr.level + 1;

                    if(stringMeetsCriteria(substring))
                        nodes.add(newNode);
                }
            }

        }

        return res;
    }

    private static boolean stringMeetsCriteria(String sub) {
        return Integer.parseInt(sub) <= 255;
    }

    static class IpLevelNode {
        String prefix;
        int prefixLength;
        int level;
        String remainder;

        IpLevelNode(String prefix, String remainder, int level, int prefixLength) {
            this.prefix = prefix;
            this.remainder = remainder;
            this.level = level;
            this.prefixLength = prefixLength;
        }

        IpLevelNode() {
        }
    }
}
