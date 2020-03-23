package algorithm;

/**
 * 876. 链表的中间结点
 *
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 */
public class MiddleNode {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public static ListNode fromArray(int[] arr) {
            assert arr.length > 1;
            ListNode head = new ListNode(arr[0]), temp = head;
            for (int i = 1; i < arr.length; i++) {
                temp.next = new ListNode(arr[i]);
                temp = temp.next;
            }
            return head;
        }

        @Override
        public String toString() {
            String concat = "->";
            StringBuilder sel = new StringBuilder(this.val + "");
            ListNode temp = this.next;
            while (temp != null) {
                sel.append(concat).append(temp.val);
                temp = temp.next;
            }
            return sel.toString();
        }
    }


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
