package stack_queue.栈实现队列;

import java.util.Stack;

// 232.用栈实现队列：https://leetcode.cn/problems/implement-queue-using-stacks/description/
class MyQueue {

    Stack<Integer> in = new Stack<>();
    Stack<Integer> out = new Stack<>();

    public MyQueue() {
    }

    public void inToOut() {
        if (out.empty()) {
            while (!in.empty()) {
                out.push(in.pop());
            }
        }
    }

    public void push(int x) {
        in.push(x);
        inToOut();
    }

    public int pop() {
        inToOut();
        return out.pop();
    }

    public int peek() {
        inToOut();
        return out.peek();
    }

    public boolean empty() {
        return in.empty() && out.empty();
    }
}
