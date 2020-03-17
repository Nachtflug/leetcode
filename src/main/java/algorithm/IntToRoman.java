package algorithm;


/**
 * 12. 整数转罗马数字
 * https://leetcode-cn.com/problems/integer-to-roman/
 */
public class IntToRoman {

    public static String intToRoman(int num) {
        char[] o = new char[]{'I', 'X', 'C', 'M'};
        char[] f = new char[]{'V', 'L', 'D'};
        int l = 0;
        // stringBuilder copy操作太多，优化一下，每位最多4字符，设总长16个字符，最后copy一次
        char[] tmpSeq = new char[16];
        int pos = 15;
        while (num > 0) {
            int i = num % 10;
            if (i < 4) {
                while (i-- > 0) {
                    tmpSeq[pos] = o[l]; pos --;
                }
            } else if (i == 4) {
                tmpSeq[pos] = f[l]; pos --;
                tmpSeq[pos] = o[l]; pos --;
            } else if (i < 9) {
                while (i-- > 5) {
                    tmpSeq[pos] = o[l]; pos --;
                }
                tmpSeq[pos] = f[l]; pos --;
            } else {
                tmpSeq[pos] = o[l + 1]; pos --;
                tmpSeq[pos] = o[l]; pos --;
            }
            l ++;
            num /= 10;
        }
        char[] trim = new char[15 - pos];
        System.arraycopy(tmpSeq, pos + 1, trim, 0, 15 - pos);
        return new String(trim);

    }



}
