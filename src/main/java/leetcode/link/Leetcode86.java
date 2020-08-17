package leetcode.link;

public class Leetcode86 {

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode curr = head;
        while (curr != null) {
            if (curr.val == x) {
                break;
            }
            curr = curr.next;
        }
        if (curr == null || curr.next == null) {
            return head;
        }
        ListNode flagNode = curr;
        ListNode secondLink = null;
        ListNode secondHead = null;
        while (curr != null) {
            if (curr.next != null && curr.next.val < x) {
                if (secondHead == null) {
                    secondLink = curr.next;
                    secondHead = curr.next;
                } else {
                    secondLink.next = curr.next;
                    secondLink = curr.next;
                }
                secondLink.next = null;
                if (curr.next.next == null || curr.next.next.val >= x) {
                    curr.next = curr.next.next;
                }
            }
            curr = curr.next;
        }
        curr = head;
        ListNode secondCurr = secondHead;
        ListNode newCurr = null;
        if (curr == null) {
            newCurr = secondCurr;
            secondCurr = secondCurr.next;
        } else if (secondCurr == null) {
            newCurr = curr;
            curr = curr.next;
        } else {
            if (curr.val <= secondCurr.val) {
                newCurr = curr;
                curr = curr.next;
            } else {
                newCurr = secondCurr;
                secondCurr = secondCurr.next;
            }
        }
        newCurr.next = null;
        ListNode newHead = newCurr;
        while ((curr != null && curr != flagNode) || secondCurr != null) {
            if (curr == flagNode || curr == null) {
                newCurr.next = secondCurr;
                newCurr = secondCurr;
                secondCurr = secondCurr.next;
            } else if (secondCurr == null) {
                newCurr.next = curr;
                newCurr = curr;
                curr = curr.next;
            } else {
                if (curr.val < secondCurr.val) {
                    newCurr.next = curr;
                    newCurr = curr;
                    curr = curr.next;
                } else {
                    newCurr.next = secondCurr;
                    newCurr = secondCurr;
                    secondCurr = secondCurr.next;
                }
            }
        }
        return newHead;
    }

    public static void main(String[] args) {
        Leetcode86 leetcode86 = new Leetcode86();
        ListNode node01 = new ListNode(2);
        ListNode node02 = new ListNode(1);
//        ListNode node03 = new ListNode(3);
//        ListNode node04 = new ListNode(2);
//        ListNode node05 = new ListNode(5);
//        ListNode node06 = new ListNode(2);
        node01.next = node02;
//        node02.next = node03;
//        node03.next = node04;
//        node04.next = node05;
//        node05.next = node06;
        leetcode86.partition(node01, 2);
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}