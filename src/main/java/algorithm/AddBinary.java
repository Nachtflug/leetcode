package algorithm;

/**
 * 67. 二进制求和
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 *
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 *
 * 提示：
 *
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 */
public class AddBinary {

    public static String addBinary(String a, String b) {

        boolean incre = false;

        if (a.length() > b.length()) {
            String temp = a;
            a = b;
            b = temp;
        }

        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (; i < ac.length; i++) {
            int c = ac[ac.length - i - 1] + bc[bc.length - i - 1] - 2 * '0';
            if (incre)
                c ++;
            incre = c > 1;
            if (incre)
                c -= 2;
            sb.insert(0, "" + c);
        }
        for (;i < bc.length; i++) {
            int c = bc[bc.length - i - 1] - '0';
            if (incre)
                c ++;
            incre = c > 1;
            if (incre)
                c -= 2;
            sb.insert(0, "" + c);
        }
        if (incre)
            sb.insert(0, "1");

        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println(addBinary("101", "1011"));
    }

}
