package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 * <p>
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class LetterCombinations {

    private static char[][] keyboard = new char['A'][];

    static {
        keyboard['2'] = new char[]{'a', 'b', 'c'};
        keyboard['3'] = new char[]{'d', 'e', 'f'};
        keyboard['4'] = new char[]{'g', 'h', 'i'};
        keyboard['5'] = new char[]{'j', 'k', 'l'};
        keyboard['6'] = new char[]{'m', 'n', 'o'};
        keyboard['7'] = new char[]{'p', 'q', 'r', 's'};
        keyboard['8'] = new char[]{'t', 'u', 'v'};
        keyboard['9'] = new char[]{'w', 'x', 'y', 'z'};
    }

    public static List<String> letterCombinations(String digits) {

        char[] ds = digits.toCharArray();
        int digCount = ds.length;
        if (digCount == 0) return new ArrayList<>();
        int size = 1;
        for (char d : ds) {
            size *= keyboard[d].length;
        }

        List<String> s = new ArrayList<>(size);
        int[] ptr = new int[digCount + 1];
        while (ptr[digCount] == 0) {
            StringBuilder sb = new StringBuilder(digCount);
            for (int j = 0; j < digCount; j++) {
                char[] cs = keyboard[ds[j]];
                sb.append(cs[ptr[j]]);
            }
            s.add(sb.toString());
            ptr[0] ++;
            for (int j = 0; j < ptr.length - 1; j++) {
                if (ptr[j] >= keyboard[ds[j]].length) {
                    ptr[j + 1] ++;
                    ptr[j] = 0;
                }
            }
        }

        return s;
    }



}
