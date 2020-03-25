package pojo;


public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
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
