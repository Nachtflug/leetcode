package algorithm;

import java.util.*;

/**
 * 139. 单词拆分
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 *
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 *
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 */
public class WordBreak {

    // 1. dfs
    // 2. dp 从末尾开始，记录位点之后的子串是否能被还原
    // 3. 记首字母，加快搜索
    public static boolean wordBreak(String s, List<String> wordDict) {

        Map<Character, List<String>> wordByChar = new HashMap<>();
        for (String str : wordDict) {
            char c = str.charAt(0);
            if (wordByChar.get(c) == null)
                wordByChar.put(c, new ArrayList<>());
            wordByChar.get(c).add(str);
        }

        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;

        char[] cs = s.toCharArray();

        MATCH:
        for (int i = cs.length - 1; i >= 0; i--) {
            char cur = cs[i];
            List<String> l = wordByChar.get(cur);
            if (l != null) {
                int len = cs.length - i;
                SEARCH:
                for (String match : l) {
                    // 字串大于待匹配串，继续搜索
                    if (match.length() > len)
                        continue;
                    // 余项不能完结，继续搜索
                    if (!dp[i + match.length()])
                        continue;
                    for (int j = 1; j < match.length(); j++) {
                        // 匹配串有字符不匹配，继续搜索
                        if (cs[i + j] != match.charAt(j))
                            continue SEARCH;
                    }
                    // 匹配
                    dp[i] = true;
                    continue MATCH;
                }
            }
            dp[i] = false;
        }
        return dp[0];
    }

    public static void main(String[] args) {

        System.out.println(wordBreak("motherfucker", Arrays.asList("mother", "fucker")));

    }

}
