package 腾讯音乐笔试;

/**
 * @description:
 * @author：三玖
 * @date: 2024/4/18
 */
public class Main {

    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode insert0(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;

        while (temp.next != null) {
            ListNode listNode = new ListNode(0);
            listNode.next = temp.next;
            temp.next = listNode;
            temp = temp.next.next;
        }
        return head;
    }

}
