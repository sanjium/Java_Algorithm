package stack.最小栈;

// 155.最小栈：https://leetcode.cn/problems/min-stack/description/
class MinStack {

    final int MAX_COUNT = 15000;

    int[] data;
    int[] min;
    int size;

    public MinStack() {
        data = new int[MAX_COUNT];
        min = new int[MAX_COUNT];
        size = 0;
    }

    public void push(int val) {
        data[size] = val;
        if (size == 0 || val <= min[size - 1]) {
            min[size] = val;
        }else if (val > min[size - 1]) {
            min[size] = min[size - 1];
        }
        size++;
    }

    public void pop() {
        size--;
    }

    public int top() {
        return data[size - 1];
    }

    public int getMin() {
        return min[size - 1];
    }
}