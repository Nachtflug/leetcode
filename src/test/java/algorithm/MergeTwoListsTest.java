package algorithm;

import pojo.ListNode;

public class MergeTwoListsTest {


    public static void main(String[] args) {

        System.out.println(MergeTwoLists.mergeTwoLists(
                ListNode.fromArray(new int[]{1, 2, 3}),
                ListNode.fromArray(new int[]{4, 5, 6})
        ));

        System.out.println(MergeTwoLists.mergeTwoLists(
                ListNode.fromArray(new int[]{1, 3, 5}),
                ListNode.fromArray(new int[]{2, 4, 6})
        ));

        System.out.println(MergeTwoLists.mergeTwoLists(
                ListNode.fromArray(new int[]{1}),
                ListNode.fromArray(new int[]{1, 2, 3, 4, 5, 6})
        ));

        System.out.println(MergeTwoLists.mergeTwoLists(
                ListNode.fromArray(new int[]{1}),
                ListNode.fromArray(new int[]{1})
        ));
    }


}
