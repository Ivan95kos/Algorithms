package _3_Implement_Stack_using_Queues;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyStackV2 {

    private final Deque<Integer> stack;

    public MyStackV2() {
        stack = new ArrayDeque<>();
    }
    public void push(int x) {
        stack.add(x);
    }
    public int pop() {
        return stack.pollLast();
    }
    public int top() {
        return stack.peekLast();
    }
    public boolean empty() {
        return stack.isEmpty();
    }

}
