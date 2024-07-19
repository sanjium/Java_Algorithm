package linklist.随机链表的复制;

import linklist.ListNode;

public class Main {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node temp = head;
        while (temp != null) {
            Node node = new Node(temp.val);
            node.next = temp.next;
            temp.next = node;
            temp = temp.next.next;
        }

        temp = head;
        while (temp != null) {
            temp.next.random = temp.random == null ? null : temp.random.next;
            temp = temp.next.next;
        }

        Node pre = head;
        Node next = head.next;
        Node newNode = next;
        while (next != null) {
            pre.next = next.next;
            next.next = pre.next == null ? null : pre.next.next;
            pre = pre.next;
            next = next.next;
        }

        return newNode;
    }

}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}