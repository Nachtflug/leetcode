package algorithm;

import pojo.ListNode;

public class SwapPairsInListTest {

    public static void main(String[] args) {
        System.out.println(SwapPairsInList.swapPairs(ListNode.fromArray(new int[]{1, 2, 3, 4})));
        System.out.println(SwapPairsInList.swapPairs(ListNode.fromArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0})));
        System.out.println(SwapPairsInList.swapPairs(ListNode.fromArray(new int[]{1, 2, 3})));
        System.out.println(SwapPairsInList.swapPairs(null));
        System.out.println(SwapPairsInList.swapPairs(ListNode.fromArray(new int[]{1})));
        System.out.println(SwapPairsInList.swapPairs(ListNode.fromArray(new int[]{1, 2})));
    }

}
