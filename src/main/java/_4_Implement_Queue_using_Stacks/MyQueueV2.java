package _4_Implement_Queue_using_Stacks;

// https://leetcode.com/problems/implement-queue-using-stacks/description/

import java.util.Arrays;

public class MyQueueV2 {
    private final static int DEFAULT_SIZE = 10;
    private int [] queue;
    private int head = 0;
    private int tail = 0;

    public MyQueueV2() {
        queue = new int[DEFAULT_SIZE];
    }

    public void push(int x) {
        if (queue.length <= tail) {
            int currentSize = tail - head;
            if (queue.length > currentSize) {
                int [] newQueue = new int[DEFAULT_SIZE];
                System.arraycopy(queue, head, newQueue, 0, currentSize);
                queue = newQueue;
                head = 0;
                tail = currentSize;
            } else {
                queue = Arrays.copyOf(queue, queue.length * 2);
            }
        }
        queue[tail++] = x;
    }

    public int pop() {
        if (tail == head) {
            throw new RuntimeException("The Stack is empty");
        }

        int value = queue[head];
        queue[head++] = 0;
        return value;
    }

    public int peek() {
        if (tail == head) {
            throw new RuntimeException("The Stack is empty");
        }

        return queue[head];
    }

    public boolean empty() {
        return tail == 0 || head == tail;
    }

    public static void main(String[] args) {
        MyQueueV2 myQueue = new MyQueueV2();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek()); // return 1
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        System.out.println(myQueue.empty()); // return false
    }
}
