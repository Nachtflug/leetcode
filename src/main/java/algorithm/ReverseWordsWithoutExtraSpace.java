package algorithm;

import java.util.Arrays;

public class ReverseWordsWithoutExtraSpace {

    public static String reverseWords(String s) {
        if (s.length() == 0) return s;
        char[] cs = s.toCharArray();
        int ptr = 0, wPtr = 0;
        boolean preCharIsSpace = true;
        reverse(cs, 0, 0, cs.length - 1);
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == ' ') {
                if (!preCharIsSpace)
                    ptr += reverse(cs, ptr, wPtr, i - 1);
                preCharIsSpace = true;
            } else {
                if (preCharIsSpace)
                    wPtr = i;
                preCharIsSpace = false;
            }
        }
        if (!preCharIsSpace)
            ptr += reverse(cs, ptr, wPtr, cs.length - 1);

        return new String(Arrays.copyOf(cs, ptr));
    }

    private static int reverse(char[] cs, int ptr, int from, int to) {
        int length = to - from + 1;
        boolean isFirst = ptr == 0;
        if (!isFirst) {
            cs[ptr++] = ' ';
        }
        int delta = from - ptr;
        do {
            char tmp = cs[to];
            cs[to] = cs[from];
            cs[from] = tmp;
        } while (--to > ++from);
        if (delta > 0)
            for (int i = 0; i < length; i++) {
                cs[ptr + i] = cs[ptr + i + delta];
            }

        return length + (isFirst ? 0 : 1);
    }

}
