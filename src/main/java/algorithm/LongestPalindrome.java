package algorithm;

/**
 * 409. 最长回文串
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 */
public class LongestPalindrome {

    public static int longestPalindrome(String s) {
        boolean[] f = new boolean['z' + 1];

        char[] cs = s.toCharArray();
        int ret = 0;
        for (char c : cs) {
            if (f[c]) {
                ret += 2;
                f[c] = false;
            } else
                f[c] = true;
        }
        return  ret == s.length() ? ret : ret + 1;
    }

}
