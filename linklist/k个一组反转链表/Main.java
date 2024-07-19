package linklist.k个一组反转链表;

import linklist.ListNode;

//25. K个一组反转链表:https://leetcode.cn/problems/reverse-nodes-in-k-group/
public class Main {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head;
        ListNode end = termEnd(start, k);
        if (end == null) {
            return head;
        }
        head = end;
        reverse(start, head);
        ListNode lastNodeEnd = start;
        while (lastNodeEnd.next != null) {
            start = start.next;
            end = termEnd(start, k);
            if (end == null) {
                return head;
            }
            reverse(start,end);
            lastNodeEnd.next = end;
            lastNodeEnd = start;
        }
        return head;
    }

    public ListNode termEnd(ListNode start, int k) {
        while (--k != 0 && start != null) {
            start = start.next;
        }
        return start;
    }

    public void reverse(ListNode start, ListNode end) {
        end = end.next;
        ListNode pre = null, cur = start, next = null;
        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        start.next = end;
    }


}
