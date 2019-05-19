package Hackerrank.ThirtyDaysOfCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Day8_Maps {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfEntries = scan.nextInt();

        Map<String, Integer> phoneBookMap = new HashMap();
        for (int i = 0; i < numberOfEntries; i++) {
            String name = scan.next().toLowerCase();
            int phone = scan.nextInt();
            phoneBookMap.put(name, phone);
        }

        while (scan.hasNext()) {
            String nameKey = scan.next();

            if (Pattern.matches("[a-zA-Z]+", nameKey)) {
                boolean isContains = phoneBookMap.containsKey(nameKey.toLowerCase());

                if (isContains) {
                    Object personNumber = phoneBookMap.get(nameKey);
                    System.out.println(nameKey + "=" + personNumber);
                } else {
                    System.out.println("Not found");
                }

            }
        }

        scan.close();
    }
}
