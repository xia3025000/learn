package leetcode.link;

public class Leetcode19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode trueHead = new ListNode(-1);
        trueHead.next = head;
        ListNode pre = trueHead;
        ListNode first = trueHead.next;
        ListNode second = trueHead;
        int i = 0;
        while (i < n) {
            second = second.next;
            i++;
        }
        while (second.next != null) {
            pre = first;
            first = first.next;
            second = second.next;
        }
        pre.next = first.next;
        return trueHead.next;
    }

    public static void main(String[] args) {
        Leetcode19 leetcode19 = new Leetcode19();
        ListNode node01 = new ListNode(1);
        ListNode node02 = new ListNode(2);
        ListNode node03 = new ListNode(3);
        ListNode node04 = new ListNode(4);
        ListNode node05 = new ListNode(5);
        node01.next = node02;
        node02.next = node03;
        node03.next = node04;
        node04.next = node05;
        leetcode19.removeNthFromEnd(node01, 2);
    }
}
