package _6_Minimum_Stack;


import java.util.Arrays;
import java.util.Objects;

// https://neetcode.io/problems/minimum-stack

public class MinimumStack {

    private final static int DEFAULT_SIZE = 10;
    private Integer[] stack;
    private int index = 0;
    private int minValue = Integer.MAX_VALUE;

    public MinimumStack() {
        stack = new Integer[DEFAULT_SIZE];
    }

    public void push(int val) {
        if (stack.length <= index) {
            stack = Arrays.copyOf(stack, stack.length * 2);
        }

        if (val < minValue) {
            minValue = val;
        }

        stack[index++] = val;
    }

    public int pop() {
        int value = stack[index - 1];
        stack[index-- - 1] = null;
        return value;
    }

    public int top() {
        return stack[index - 1];
    }

    public int getMin() {
        return Arrays.stream(stack)
                .filter(Objects::nonNull)
                .min(Integer::compareTo)
                .get();
    }
}
