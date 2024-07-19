package queue.设计循环队列;

// 622. 设计循环队列：https://leetcode.cn/problems/design-circular-queue/description/
class MyCircularQueue {

    public int[] queue;

    public int l;

    public int r;

    public int size;

    public int limit;


    public MyCircularQueue(int k) {
        queue = new int[k];
        limit = k;
        l = r = size = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        } else {
            queue[r] = value;
            r = r == limit - 1 ? 0 : (r + 1);
            size++;
            return true;
        }
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        } else {
            l = l == limit - 1 ? 0 : (l + 1);
            size--;
            return true;
        }
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        } else {
            return queue[l];
        }
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        } else {
            return r == 0 ? queue[limit - 1] : queue[r - 1];
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == limit;
    }
}
