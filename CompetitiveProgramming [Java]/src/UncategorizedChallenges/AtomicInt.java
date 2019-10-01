package UncategorizedChallenges;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-09-04
 */
public class AtomicInt {

    static AtomicInteger atomicInteger = new AtomicInteger(0);

    private static int getAtomicInteger() {
        atomicInteger.compareAndSet(99999, 0);
        return atomicInteger.getAndIncrement();
    }
}
