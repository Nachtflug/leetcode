package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateParenthesis {

    public static List<String> generateParenthesis(int n) {


        ArrayList<String> ans = new ArrayList<>();
        gen(new char[n * 2], 0, 0, ans);
        return ans;
    }

    private static void gen(char[] cs, int cnt, int pos, List<String> ans) {
        if (pos == cs.length) {
            ans.add(new String(cs));
            return;
        }

        if (cnt > cs.length - pos)
            return;
        else if (cnt == cs.length - pos) {
            Arrays.fill(cs, pos, cs.length, ')');
            ans.add(new String(cs));
            return;
        }

        if (cnt > 0) {
            cs[pos] = ')';
            gen(cs, cnt - 1, pos + 1, ans);
        }

        if (cnt < cs.length >> 1) {
            cs[pos] = '(';
            gen(cs, cnt + 1, pos + 1, ans);
        }
    }

}
