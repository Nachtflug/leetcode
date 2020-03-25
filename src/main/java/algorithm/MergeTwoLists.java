package algorithm;

import pojo.ListNode;

/**
 * 21. 合并两个有序链表
 *
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeTwoLists {


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0), h = temp;

        while (l1 != null || l2 != null) {
            if (l1 == null || (l2 != null && l1.val >= l2.val)) {
                temp.next = l2;
                temp = l2;
                l2 = l2.next;
            } else if (l2 == null || l2.val > l1.val) {
                temp.next = l1;
                temp = l1;
                l1 = l1.next;
            }
        }
        return h.next;
    }

}
