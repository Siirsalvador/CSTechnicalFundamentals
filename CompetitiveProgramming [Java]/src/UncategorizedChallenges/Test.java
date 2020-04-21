package UncategorizedChallenges;

import java.time.Instant;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        int integer1 = scanner.nextInt();
//        int integer2 = scanner.nextInt();
//        int integer3 = scanner.nextInt();
//
//        System.out.println(integer1+integer2+integer3);

        Instant instant = Instant.now();
        long timeStampSeconds = instant.getEpochSecond();

        System.out.println(timeStampSeconds);

        char[] arr = {'a', 'b', 'c'};
        char[] arr2 = {'a', 'b', 'c'};

        Set<char[]> s = new HashSet<>();
        s.add(arr);

        System.out.println(s.contains(arr2));
    }
}
