package algorithm;

import pojo.ListNode;

public class MiddleNodeTest {


    public static void main(String[] args) {
        System.out.println(MiddleNode.middleNode(ListNode.fromArray(new int[]{1, 2, 3, 4})));
        System.out.println(MiddleNode.middleNode(ListNode.fromArray(new int[]{6, 6, 7, 6, 6})));
        System.out.println(MiddleNode.middleNode(ListNode.fromArray(new int[]{6, 6, 6, 7, 6, 6})));
    }

}
