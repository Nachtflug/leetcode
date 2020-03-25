package algorithm;

import pojo.ListNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *23. 合并K个排序链表
 *
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class MergeKLists {

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        PriorityQueue<ListNode> heap = new PriorityQueue<>(lists.length, Comparator.comparingInt(l -> l.val));
        for (ListNode list : lists) {
            if (list != null)
                heap.add(list);
        }
        ListNode h = new ListNode(0), t = h;


        while (heap.size() > 0) {
            ListNode p = heap.poll();
            if (p.next != null) {
                heap.add(p.next);
            }
            t.next = p;
            t = p;
        }

        return h.next;

    }

}