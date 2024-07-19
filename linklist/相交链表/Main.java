package linklist.相交链表;

import linklist.ListNode;

public class Main {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode temp1 = headA;
        ListNode temp2 = headB;

        int sizeA = 0;
        int sizeB = 0;
        while (temp1 != null) {
            sizeA++;
            temp1 = temp1.next;
        }

        while (temp2 != null) {
            sizeB++;
            temp2 = temp2.next;
        }

        temp1 = headA;
        temp2 = headB;

        if (sizeA > sizeB) {
            for (int i = 0; i < sizeA - sizeB; i++) {
                temp1 = temp1.next;
            }
        }

        if (sizeB > sizeA) {
            for (int i = 0; i < sizeB - sizeA; i++) {
                temp2 = temp2.next;
            }
        }

        while (temp1 != null && temp2 != null) {
            if (temp1 == temp2) {
                return temp1;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return null;
    }

}
