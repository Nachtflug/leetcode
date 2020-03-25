package algorithm;

/**
 * 20. 有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 *     左括号必须用相同类型的右括号闭合。
 *     左括号必须以正确的顺序闭合。
 *
 * 注意空字符串可被认为是有效字符串。
 */
public class BracketsValidation {

    public static boolean isValid(String s) {

        int pos = 0;
        char[] stack = new char[s.length()];

        for (char c : s.toCharArray()) {
            if (c == '[' || c == '(' || c == '{') {
                stack[pos ++] = c;
            } else if (c == ']' || c == ')' || c == '}') {
                if (-- pos < 0 || stack[pos] != c - (c == ')' ? 1 : 2))
                    return false;
            }
        }


        return pos == 0;
    }

}
