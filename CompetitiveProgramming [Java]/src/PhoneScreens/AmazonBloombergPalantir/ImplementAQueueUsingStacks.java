package PhoneScreens.AmazonBloombergPalantir;

import java.util.Stack;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-19
 */
public class ImplementAQueueUsingStacks {

    public static void main(String[] args) {

    }
}

class MyQueue {

    private Stack<Integer> queueStack;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        queueStack = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        queueStack.add(0, x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        return queueStack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return queueStack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return queueStack.isEmpty();
    }
}
