package algorithm;

/**
 * 14. 最长公共前缀
 */
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        int pos = 0, minlen = Integer.MAX_VALUE;
        char[][] strcs = new char[strs.length][];
        for (int i = 0; i < strs.length; i++) {
            strcs[i] = strs[i].toCharArray();
            if (minlen > strs[i].length())
                minlen = strs[i].length();
        }
        DONE:
        while (pos < minlen) {
            char bench = strcs[0][pos];
            for (int i = 1; i < strcs.length; i++) {
                if (strcs[i][pos] != bench)
                    break DONE;
            }
            pos ++;
        }
        return strs[0].substring(0, pos);
    }

}
