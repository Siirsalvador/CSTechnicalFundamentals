package PhoneScreens.Amazon;

import java.util.ArrayList;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-19
 */


public class MaxStackImplementation {

    public static void main(String[] args) {
        MaxStack maxStack = new MaxStack();
        maxStack.push(5);
        maxStack.push(1);
        maxStack.push(5);
        maxStack.top();
        maxStack.popMax();
        maxStack.top();
        maxStack.peekMax();
        maxStack.pop();
        maxStack.top();
    }
}

class MaxStack {

    ArrayList<Integer> stack;
    int max;
    int maxIdx;

    /**
     * initialize your data structure here.
     */
    public MaxStack() {
        stack = new ArrayList<>();
        max = Integer.MIN_VALUE;
        maxIdx = 0;
    }

    public void push(int x) {
        stack.add(x);
        if (x >= max) {
            max = x;
            maxIdx = stack.size() - 1;
        }
    }

    public int pop() {
        int topIdx = stack.size() - 1;
        int top = stack.remove(topIdx);

        if (maxIdx == topIdx) {
            max = Integer.MIN_VALUE;
            for (int i = 0; i < stack.size(); i++) {
                if (stack.get(i) >= max) {
                    max = stack.get(i);
                    maxIdx = i;
                }
            }
        }

        return top;
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int peekMax() {
        return max;
    }

    public int popMax() {
        int maxVal = max;
        stack.remove(maxIdx);
        max = Integer.MIN_VALUE;

        for (int i = 0; i < stack.size(); i++) {
            if (stack.get(i) >= max) {
                max = stack.get(i);
                maxIdx = i;
            }
        }

        return maxVal;
    }
}
