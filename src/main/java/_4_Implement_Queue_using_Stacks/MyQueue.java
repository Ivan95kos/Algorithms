package _4_Implement_Queue_using_Stacks;

import java.util.Stack;

// https://leetcode.com/problems/implement-queue-using-stacks/description/

public class MyQueue {
    private Stack<Integer> tail;
    private Stack<Integer> head;

    public MyQueue() {
        tail = new Stack<>();
        head = new Stack<>();
    }

    public void push(int x) {
        tail.push(x);
    }

    public int pop() {
        if (head.isEmpty()) {
            while (!tail.isEmpty()) {
                head.push(tail.pop());
            }
        }
        return head.pop();
    }

    public int peek() {
        if (head.isEmpty()) {
            while (!tail.isEmpty()) {
                head.push(tail.pop());
            }
        }
        return head.peek();
    }

    public boolean empty() {
        return tail.isEmpty() && head.isEmpty();
    }
}
