package Random;

import java.time.Instant;

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
    }
}
