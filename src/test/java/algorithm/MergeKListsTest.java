package algorithm;

import pojo.ListNode;

public class MergeKListsTest {

    public static void main(String[] args) {
        System.out.println(MergeKLists.mergeKLists(new ListNode[]{
                ListNode.fromArray(new int[]{1, 2, 3}),
                ListNode.fromArray(new int[]{4, 5, 6}),
                ListNode.fromArray(new int[]{7, 8, 9})
        }));

        System.out.println(MergeKLists.mergeKLists(new ListNode[]{
                ListNode.fromArray(new int[]{1}),
                ListNode.fromArray(new int[]{2}),
                ListNode.fromArray(new int[]{2}),
                ListNode.fromArray(new int[]{3}),
                ListNode.fromArray(new int[]{4}),
        }));

        System.out.println(MergeKLists.mergeKLists(new ListNode[]{
                ListNode.fromArray(new int[]{1, 2, 3}),
                null,
                ListNode.fromArray(new int[]{7, 8, 9})
        }));
    }

}
