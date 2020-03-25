package algorithm;

import pojo.ListNode;

/**
 * 876. 链表的中间结点
 *
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 */
public class MiddleNode {



    public static ListNode middleNode(ListNode head) {

        ListNode ret = head;
        int i = 0;
        while (head != null) {
            head = head.next;
            if (i++ % 2 == 1)
                ret = ret.next;
        }

        return ret;
    }


}
