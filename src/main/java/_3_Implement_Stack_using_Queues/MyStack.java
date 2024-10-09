package _3_Implement_Stack_using_Queues;

// https://leetcode.com/problems/implement-stack-using-queues/description/

import java.util.Arrays;

public class MyStack {
    private final static int DEFAULT_SIZE = 10;
    private int [] stack;
    private int index = 0;

    public MyStack() {
        stack = new int[DEFAULT_SIZE];
    }

    public void push(int x) {
        if (stack.length <= index) {
            stack = Arrays.copyOf(stack, stack.length * 2);
        }
        stack[index++] = x;
    }

    public int pop() {
        if (index == 0) {
            throw new RuntimeException("The Stack is empty");
        }

        int value = stack[index - 1];
        stack[index-- - 1] = 0;
        return value;
    }

    public int top() {
        if (index == 0) {
            throw new RuntimeException("The Stack is empty");
        }

        return stack[index - 1];
    }

    public boolean empty() {
        return index == 0;
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top()); // return 2
        System.out.println(myStack.pop()); // return 2
        System.out.println(myStack.empty()); // return False
    }

}
