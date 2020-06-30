package aimOffer;

import pojo.ListNode;

/**
 * 面试题 02.01. 移除重复节点
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 *
 * 示例1:
 *
 *  输入：[1, 2, 3, 3, 2, 1]
 *  输出：[1, 2, 3]
 * 示例2:
 *
 *  输入：[1, 1, 1, 1, 2]
 *  输出：[1, 2]
 * 提示：
 *
 * 链表长度在[0, 20000]范围内。
 * 链表元素在[0, 20000]范围内。
 * 进阶：
 *
 * 如果不得使用临时缓冲区，该怎么解决？
 */
public class RemoveDuplicateNodes {


    public ListNode removeDuplicateNodes(ListNode head) {


        if (head == null || head.next == null)
            return head;

        boolean[] exist = new boolean[20000];
        exist[head.val] = true;
        ListNode ret = head;
        while (head.next != null) {
            ListNode next = head.next;
            if (exist[next.val])
                head.next = next.next;
            else {
                head = next;
                exist[head.val] = true;
            }
        }


        return ret;
    }

}