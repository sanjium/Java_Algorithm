package linklist.分割链表;

import linklist.ListNode;

// 86. 分割链表：https://leetcode.cn/problems/partition-list/description/
public class Main {

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode h1 = null, c1 = null, h2 = null, c2 = null;
        ListNode cur = head;

        while (cur != null) {
            if (cur.val < x) {
                if (h1 == null) {
                    h1 = new ListNode(cur.val);
                    c1 = h1;
                } else {
                    c1.next = new ListNode(cur.val);
                    c1 = c1.next;
                }
            } else {
                if (h2 == null) {
                    h2 = new ListNode(cur.val);
                    c2 = h2;
                } else {
                    c2.next = new ListNode(cur.val);
                    c2 = c2.next;
                }
            }
            cur = cur.next;
        }
        if (c1 != null) {
            c1.next = h2;
            return h1;
        } else {
            return h2;
        }
    }

}
