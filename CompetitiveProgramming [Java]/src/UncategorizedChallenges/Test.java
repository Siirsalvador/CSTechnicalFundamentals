package UncategorizedChallenges;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        int integer1 = scanner.nextInt();
//        int integer2 = scanner.nextInt();
//        int integer3 = scanner.nextInt();
//
//        System.out.println(integer1+integer2+integer3);

//        Instant instant = Instant.now();
//        long timeStampSeconds = instant.getEpochSecond();

        String a = "00000200";
        String b = a.replaceAll("^0+","");
        String c = a.replaceAll("^0+(?!$)","");
        System.out.println(b);
        System.out.println(c);


    }
}
