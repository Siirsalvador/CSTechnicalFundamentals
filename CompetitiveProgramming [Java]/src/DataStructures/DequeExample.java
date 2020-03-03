package DataStructures;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-02-04
 */
public class DequeExample {
    public static void main(String[] args){
        Deque<Integer> dq = new ArrayDeque<>();
        dq.addFirst(2);
        dq.add(1);
        dq.addFirst(3);

        System.out.println(dq.toString());
    }
}
