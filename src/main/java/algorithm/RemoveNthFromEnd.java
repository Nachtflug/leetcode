package algorithm;

import pojo.ListNode;

public class RemoveNthFromEnd {


    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0)
            return head;
        if (head.next == null && n == 1)
            return null;
        int st = 0;
        ListNode t = head, h;
        while (st++ < n) {
            t = t.next;
        }

        if (t == null)
            return head.next;

        h = head;

        while (t.next != null) {
            t = t.next;
            h = h.next;
        }

        h.next = h.next.next;

        return head;
    }



}