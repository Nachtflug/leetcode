package algorithm;

import pojo.ListNode;

public class RemoveNthFromEndTest {

    public static void main(String[] args) {
        System.out.println(RemoveNthFromEnd.removeNthFromEnd(ListNode.fromArray(new int[]{1, 2}), 2));
        System.out.println(RemoveNthFromEnd.removeNthFromEnd(ListNode.fromArray(new int[]{1, 2, 3, 4}), 2));
        System.out.println(RemoveNthFromEnd.removeNthFromEnd(ListNode.fromArray(new int[]{1, 2, 3, 4}), 1));
        System.out.println(RemoveNthFromEnd.removeNthFromEnd(ListNode.fromArray(new int[]{1}), 1));
    }

}
