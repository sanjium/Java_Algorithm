package heap.合并K个升序链表;


import linklist.ListNode;

import java.util.Arrays;
import java.util.PriorityQueue;

//LCR 078. 合并 K 个升序链表
public class Main {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((a, b) -> {
            return a.val - b.val;
        });

        for (ListNode list : lists) {
            if (list != null) {
                priorityQueue.add(list);
            }
        }

        if (priorityQueue.isEmpty()) {
            return null;
        }

        ListNode head = priorityQueue.poll();
        ListNode temp = head;
        if (head.next != null) {
            priorityQueue.add(head.next);
        }
        while (!priorityQueue.isEmpty()) {
            ListNode poll = priorityQueue.poll();
            if (poll.next != null) {
                priorityQueue.add(poll.next);
            }
            temp.next = poll;
            temp = temp.next;
        }

        return head;
    }

}
