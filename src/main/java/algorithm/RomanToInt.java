package algorithm;


/**
 * 13. 罗马数字转整数
 * https://leetcode-cn.com/problems/integer-to-roman/
 */
public class RomanToInt {

    private final static int[] mapping = new int['Y' - 'A'];
    static {
        mapping['I' - 'A'] = 1;
        mapping['V' - 'A'] = 5;
        mapping['X' - 'A'] = 10;
        mapping['L' - 'A'] = 50;
        mapping['C' - 'A'] = 100;
        mapping['D' - 'A'] = 500;
        mapping['M' - 'A'] = 1000;
    }

    public static int romanToInt(String s) {

        char[] cs = s.toCharArray();
        int sum = 0;
        int before = Integer.MAX_VALUE;
        for (char c : cs) {
            int cur = mapping[c - 'A'];
            sum += cur;
            if (cur > before) {
                sum -= before + before;
            }
            before = cur;
        }
        return sum;
    }


}
