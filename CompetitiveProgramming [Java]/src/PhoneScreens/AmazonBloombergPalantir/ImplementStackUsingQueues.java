package PhoneScreens.AmazonBloombergPalantir;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-19
 */
public class ImplementStackUsingQueues {

    public static void main(String[] args) {

        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        System.out.println(obj.top());
        System.out.println(obj.pop());
    }
}


class MyStack {

    private Queue<Integer> stackQueue;
    private Queue<Integer> queue;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        stackQueue = new LinkedList<>();
        queue = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */

    //[1, 2, 3, 4, 5]
    //[]
    public void push(int x) {

        queue.offer(x);

        while (!stackQueue.isEmpty()) {
            queue.offer(stackQueue.poll());
        }

        stackQueue = queue;
        queue = new LinkedList<>();
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return stackQueue.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return stackQueue.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return stackQueue.isEmpty();
    }
}