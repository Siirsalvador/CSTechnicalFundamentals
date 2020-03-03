package PhoneScreens.AmazonBloombergPalantir;

import java.util.ArrayList;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-12-13
 */
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
        maxIdx = Integer.MIN_VALUE;
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
        int top = stack.remove(stack.size() - 1);

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
        return stack.get(maxIdx);
    }

    public int popMax() {
        int maxVal = stack.remove(maxIdx);
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

class Test {
    public static void main(String[] args) {
        MaxStack obj = new MaxStack();
        obj.push(5);
        obj.push(1);
        obj.push(5);

        System.out.println(obj.top()); //5,5,1,5,1,5
        System.out.println(obj.popMax());
        System.out.println(obj.top());
        System.out.println(obj.peekMax());
        System.out.println(obj.pop());
        System.out.println(obj.top());
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */