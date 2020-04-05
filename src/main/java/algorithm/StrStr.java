package algorithm;

/**
 * 28. 实现 strStr()
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 */
public class StrStr {

    /**
     * 简化版KMP 也算dp的一种
     * 双指针并记录首字符出现的位置，跳走
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        int nl = needle.length();
        if (nl == 0)
            return 0;
        char[] nc = needle.toCharArray(), hc = haystack.toCharArray();
        char h = nc[0];
        int startPossibles = haystack.length() - nl + 1;
        if (startPossibles < 0) return -1;
        int[] startPos = new int[startPossibles];
        int pLen = 0, i = 0;
        OUTLOOK:
        while (i < startPossibles) {
            while (hc[i] != h) {i++; continue OUTLOOK;}//找到第一个字符相等
            int curP = pLen;
            boolean done = true;
            for (int j = 1; j < nl; j++) {
                if (hc[i + j] == h && i + j < startPossibles)
                    startPos[pLen++] = i + j;
                if (hc[i + j] != nc[j]) {
                    done = false;
                    break;
                }
            }
            if (done)
                return i;
            for (int j = curP; j < pLen; j++) {
                i = startPos[j];
                done = true;
                for (int x = 1; x < nl; x++) {
                    if (hc[i + x] != nc[x]) {
                        done = false;
                        break;
                    }
                }
                if (done)
                    return i;
            }
            i++;
        }

        return -1;
    }

}
