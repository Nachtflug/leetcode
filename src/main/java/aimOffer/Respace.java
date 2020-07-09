package aimOffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 面试题 17.13. 恢复空格
 * 难度
 * 中等
 *
 * 29
 *
 * 收藏
 *
 * 分享
 *
 * 切换为英文
 *
 * 关注
 *
 * 反馈
 * 哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。像句子"I reset the computer. It still didn’t boot!"已经变成了"iresetthecomputeritstilldidntboot"。在处理标点符号和大小写之前，你得先把它断成词语。当然了，你有一本厚厚的词典dictionary，不过，有些词没在词典里。假设文章用sentence表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。
 * 注意：本题相对原题稍作改动，只需返回未识别的字符数
 *
 * 示例：
 * 输入：
 * dictionary = ["looked","just","like","her","brother"]
 * sentence = "jesslookedjustliketimherbrother"
 * 输出： 7
 * 解释： 断句后为"jess looked just like tim her brother"，共7个未识别字符。
 * 提示：
 * 0 <= len(sentence) <= 1000
 * dictionary中总字符数不超过 150000。
 * 你可以认为dictionary和sentence中只包含小写字母。
 */
public class Respace {

    // dp
    public static int respace(String[] dictionary, String sentence) {
        if (sentence.isEmpty())
            return 0;
        int[] dp = new int[sentence.length() + 1];
        dp[0] = 0;
        Map<Character, List<String>> lastChar2Word = new HashMap<>();

        for (String s : dictionary) {
            char lastChar = s.charAt(s.length() - 1);
            lastChar2Word.computeIfAbsent(lastChar, c -> new ArrayList<>()).add(s);
        }
        char[] cs = sentence.toCharArray();
        for (int i = 0; i < sentence.length(); i++) {
            char cur = cs[i];
            List<String> l = lastChar2Word.get(cur);
            if (l == null)
                dp[i + 1] = dp[i] + 1;
            else {
                int min = dp[i] + 1;
                CONTINUE:
                for (String s : l) {
                    int sLen = s.length();
                    if (sLen > i + 1)
                        continue;
                    for (int j = 1; j < s.length(); j++) {
                        if (cs[i - j] != s.charAt(sLen - 1 - j))
                            continue CONTINUE;
                    }
                    min = Math.min(min, dp[i + 1 - sLen]);
                }
                dp[i + 1] = min;
            }
        }
        return dp[sentence.length()];
    }

    public static void main(String[] args) {

        respace(new String[]{"patk","mk","bgmuaukzpbp","tpakjawagaakakmpkkikjpbmppiiazkkdko","apoggddaakoadudmw","mugaxmgwkbptxmbmt",
                "tijagbkixiwzdddbbjjgpk","goaotk","kk","xambkwpozgouaaamzgtpkojgdbxuwkjz","gmwo","bkbpdptkjxjgatdkukxmxkabkjmiuotiikb","ad",
                "babtgmz","kujuak","ikimadpozaxozoaikttzamjakk","jjumibouto"}, "bgmuaukzpbpkujuakpatk");

    }

}
