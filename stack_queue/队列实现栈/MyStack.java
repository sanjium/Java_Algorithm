package stack_queue.队列实现栈;

import java.util.LinkedList;
import java.util.Queue;

// 225.用队列实现栈：https://leetcode.cn/problems/implement-stack-using-queues/description/
class MyStack {

    Queue<Integer> queue = new LinkedList<>();

    int n;
    public MyStack() {
      n = 0;
    }

    public void push(int x) {
        queue.offer(x);
        for (int i = 0; i < n; i++) {
            queue.offer(queue.poll());
        }
        n++;
    }

    public int pop() {
        assert !queue.isEmpty();
        n--;
        return queue.poll();
    }

    public int top() {
        assert !queue.isEmpty();
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}