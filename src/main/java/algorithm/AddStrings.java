package algorithm;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * 415. 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 * 注意：
 *
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 */
public class AddStrings {

    public String addStrings(String num1, String num2) {

        StringBuilder ans = new StringBuilder();
        boolean inc = false;

        char[] cs1 = num1.toCharArray();
        char[] cs2 = num2.toCharArray();
        if (cs1.length > cs2.length) {
            char[] tmp = cs1;
            cs1 = cs2;
            cs2 = tmp;
        }
        int i = 0, cs1Pre = cs1.length - 1, cs2Pre = cs2.length - 1;
        for (; i < cs1.length; i++) {
            int a = cs1[cs1Pre - i] - '0';
            int b = cs2[cs2Pre - i] - '0';
            int sum = a + b;
            if (inc)
                sum += 1;
            inc = append(ans, sum);

        }

        for (; i < cs2.length; i++) {
            int b = cs2[cs2Pre - i] - '0';
            if (inc)
                b ++;
            inc = append(ans, b);
        }
        if (inc)
            append(ans, 1);
        return ans.toString();
    }

    private boolean append(StringBuilder ans, int sum) {
        boolean inc;
        if (sum > 9) {
            inc = true;
            sum -= 10;
        } else
            inc = false;
        ans.insert(0, sum);
        return inc;
    }

    public static void main(String[] args) {
        System.out.println(new AddStrings().addStrings("123", "45678123"));
    }

}
