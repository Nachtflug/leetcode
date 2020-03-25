package algorithm;

import pojo.ListNode;

/**
 * 24. 两两交换链表中的节点
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class SwapPairsInList {

    public static ListNode swapPairs(ListNode head) {

        ListNode h = head, pre = null;
        boolean firstSwap = true;
        while (true) {

            if (h == null || h.next == null)
                return head;

            ListNode l2 = h.next;
            h.next = l2.next;
            l2.next = h;
            if (pre != null) {
                pre.next = l2;
            }
            pre = h;
            h = h.next;
            if (firstSwap) {
                head = l2;
                firstSwap = false;
            }
        }

    }

}
