package data_structure.数据流的中位数;


import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

//295. 数据流的中位数：https://leetcode.cn/problems/find-median-from-data-stream/description/
class MedianFinder {

    private PriorityQueue<Integer> minHeap;

    private PriorityQueue<Integer> maxHeap;


    public MedianFinder() {
        minHeap = new PriorityQueue<>((a, b) -> a - b);
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }
        balance();
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            assert maxHeap.peek() != null;
            return (double) (maxHeap.peek() + minHeap.peek()) / 2;
        } else {
            return maxHeap.size() > minHeap.size() ? maxHeap.peek() : minHeap.peek();
        }
    }

    public void balance() {
        if (Math.abs(minHeap.size() - maxHeap.size()) == 2) {
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            } else {
                minHeap.add(maxHeap.poll());
            }
        }
    }

}
