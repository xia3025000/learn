package leetcode.link;

public class Leetcode147 {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode low = null;
        ListNode high = null;
        ListNode next = null;
        ListNode curr = null;
        ListNode pre = null;
        curr = dummy.next;
        pre = dummy;
        while (curr != null) {
            low = dummy;
            high = dummy.next;
            next = curr.next;
            while (high != curr) {
                if (high.val >= curr.val) {
                    low.next = curr;
                    curr.next = high;
                    pre.next = next;
                    break;
                } else {
                    high = high.next;
                    low = low.next;
                }
            }
            pre = curr;
            curr = next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Leetcode147 leetcode147 = new Leetcode147();
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        leetcode147.insertionSortList(node1);
    }

}
