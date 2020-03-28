package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 820. 单词的压缩编码
 * 给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。
 *
 * 例如，如果这个列表是 ["time", "me", "bell"]，我们就可以将其表示为 S = "time#bell#" 和 indexes = [0, 2, 5]。
 *
 * 对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，直到 "#" 结束，来恢复我们之前的单词列表。
 *
 * 那么成功对给定单词列表进行编码的最小字符串长度是多少呢？
 *
 *
 *
 * 示例：
 *
 * 输入: words = ["time", "me", "bell"]
 * 输出: 10
 * 说明: S = "time#bell#" ， indexes = [0, 2, 5] 。
 */
public class MinimumLengthEncoding {

    /**
     * 分析能重用一个子串的情况只有某个单词是另一个单词的后缀，比如 me -> time
     * 所以分析所有后缀的情况，再把最少数量的单词长度相加，再加上连接符的长度即可
     * 从尾部开始分组单词，分组时丢弃已经扫描完毕的单词，直到每组只有一个单词
     * 类似于字典数，但是更容易想到
     * @param words
     * @return
     */
    public static int minimumLengthEncoding(String[] words) {

        Group initGroup = Group.of(words, 0);
        List<Group> groups = initGroup.divide();

        int l = 0;
        while (groups.size() > 0) {
            Group g = groups.remove(0);
            if (g.isPure()) {
                l += g.length() + 1;
            } else {
                groups.addAll(g.divide());
            }
        }

        return l;
    }


    public static class Group {
        public String[] words;
        public int ptr;

        public static Group of(String[] words, int ptr) {
            Group g = new Group();
            g.words = words;
            g.ptr = ptr;
            return g;
        }

        public boolean isPure() {
            return words.length == 1;
        }

        public int length() {
            return words[0].length();
        }

        public List<Group> divide() {
            ArrayList<Group> groups = new ArrayList<>();
            if (isPure()) {
                groups.add(this);
                return groups;
            }
            int next = ptr + 1;
            HashMap<Character, List<String>> divides = new HashMap<>(words.length);
            for (String word : words) {
                if (next > word.length())
                    continue; //丢弃全覆盖的
                char c = word.charAt(word.length() - next);
                divides.computeIfAbsent(c, k -> new ArrayList<>()).add(word);
            }
            if (divides.isEmpty()) { //全部相同的情况
                groups.add(Group.of(new String[]{words[0]}, next));
            } else for (List<String> words : divides.values()) {
                groups.add(Group.of(words.toArray(new String[]{}), next));
            }
            return groups;
        }


    }

}
