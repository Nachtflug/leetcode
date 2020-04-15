package algorithm;

import pojo.ListNode;

public class AddTwoNumbersTest {

    public static void main(String[] args) {
        System.out.println(AddTwoNumbers.addTwoNumbers(

                ListNode.fromArray(new int[]{5}),
                ListNode.fromArray(new int[]{5})
        ));
        System.out.println(AddTwoNumbers.addTwoNumbers(

                ListNode.fromArray(new int[]{8,9,9}),
                ListNode.fromArray(new int[]{2})
        ));

        System.out.println(AddTwoNumbers.addTwoNumbers(
                ListNode.fromArray(new int[]{6, 6, 6}),
                ListNode.fromArray(new int[]{9, 9, 6, 1})
        ));

        System.out.println(AddTwoNumbers.addTwoNumbers(
                ListNode.fromArray(new int[]{1}),
                ListNode.fromArray(new int[]{9, 9, 6, 1})
        ));

        System.out.println(AddTwoNumbers.addTwoNumbers(

                ListNode.fromArray(new int[]{9, 9, 6, 1}),
                ListNode.fromArray(new int[]{0})
        ));



    }

}
