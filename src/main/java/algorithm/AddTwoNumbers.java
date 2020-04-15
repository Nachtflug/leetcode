package algorithm;

import pojo.ListNode;

/**
 * 445. 两数相加 II
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 *
 *
 * 进阶：
 *
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 *
 *
 *
 * 示例：
 *
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 */
public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        int inc = 0;
        boolean isFirst = true;
        ListNode ret = new ListNode(0), cur = ret;
        do {
            int val = l1.val + l2.val + inc;
            if (val > 9) {
                inc = 1;
                val -= 10;
            } else
                inc = 0;
            if (isFirst) {
                ret.val = val;
                isFirst = false;
            } else {
                cur.next = new ListNode(val);
                cur = cur.next;
            }
        } while ((l1 = l1.next) != null && (l2 = l2.next) != null);

        if (l1 != null) {
            cur.next = l1;
            l1.val += inc;
            cur = cur.next;
            inc = 0;
        } else if (l2.next != null) {
            cur.next = l2.next;
            l2.next.val += inc;
            cur = cur.next;
            inc = 0;
        }
        while (cur.val > 9) {
            cur.val -= 10;
            if (cur.next == null)
                cur.next = new ListNode(1);
            else
                cur.next.val ++;
            cur = cur.next;
        }

        if (inc == 1)
            cur.next = new ListNode(1);


        return reverse(ret);
    }


    private static ListNode reverse(ListNode h) {

        ListNode pre = null;

        while (h.next != null) {
             ListNode next = h.next;
             h.next = pre;
             pre = h;
             h = next;
        }

        h.next = pre;

        return h;
    }

}
