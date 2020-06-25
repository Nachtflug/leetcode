package aimOffer;

/**
 * 面试题 16.18. 模式匹配
 * 你有两个字符串，即pattern和value。 pattern字符串由字母"a"和"b"组成，用于描述字符串中的模式。例如，字符串"catcatgocatgo"匹配模式"aabab"（其中"cat"是"a"，"go"是"b"），该字符串也匹配像"a"、"ab"和"b"这样的模式。但需注意"a"和"b"不能同时表示相同的字符串。编写一个方法判断value字符串是否匹配pattern字符串。
 *
 * 示例 1：
 *
 * 输入： pattern = "abba", value = "dogcatcatdog"
 * 输出： true
 * 示例 2：
 *
 * 输入： pattern = "abba", value = "dogcatcatfish"
 * 输出： false
 * 示例 3：
 *
 * 输入： pattern = "aaaa", value = "dogcatcatdog"
 * 输出： false
 * 示例 4：
 *
 * 输入： pattern = "abba", value = "dogdogdogdog"
 * 输出： true
 * 解释： "a"="dogdog",b=""，反之也符合规则
 * 提示：
 *
 * 0 <= len(pattern) <= 1000
 * 0 <= len(value) <= 1000
 * 你可以假设pattern只包含字母"a"和"b"，value仅包含小写字母。
 */
public class PatternMatching {

    public static boolean patternMatching(String pattern, String value) {

        int countA = 0, countB = 0;
        for (char ch: pattern.toCharArray()) {
            if (ch == 'a') {
                ++countA;
            } else {
                ++countB;
            }
        }
        boolean bGa = countB > countA;
        pattern = pattern.replaceAll("a", bGa ? "B" : "A").replaceAll("b", bGa ? "A" : "B");
        if (bGa) {
            int tmp = countA;
            countA = countB;
            countB = tmp;
        }
        if (value.length() == 0) {
            return countB == 0;
        }
        if (pattern.length() == 0) {
            return false;
        }
        int firstA = pattern.indexOf('a');
        int firstB = firstA == 0 ? pattern.indexOf('b') : 0;
        for (int lenA = 0; countA * lenA <= value.length(); ++lenA) {
            int rest = value.length() - countA * lenA;
            if ((countB == 0 && rest != 0) || (countB != 0 && rest % countB != 0)) continue;

            int lenB = (countB == 0 ? 0 : rest / countB);


            int firstIdxA = firstA * lenB;
            int firstIdxB = firstB * lenA;
            String valueA = value.substring(firstIdxA, firstIdxA + lenA);
            String valueB = firstIdxB < 0 ? "" : value.substring(firstIdxB, firstIdxB + lenB);
            if (valueA.equals(valueB)) continue;

            if (pattern.replaceAll("A", valueA).replaceAll("B", valueB).equals(value))
                return true;

        }
        return false;

    }

    public static void main(String[] args) {

        System.out.println(patternMatching("bbba", "xxxxxx"));
    }

}
