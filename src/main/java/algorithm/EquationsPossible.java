package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 990. 等式方程的可满足性
 *
 * 给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
 *
 * 只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。 
 *
 *  
 *
 * 示例 1：
 *
 * 输入：["a==b","b!=a"]
 * 输出：false
 * 解释：如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，但无法满足第二个方程。没有办法分配变量同时满足这两个方程。
 * 示例 2：
 *
 * 输出：["b==a","a==b"]
 * 输入：true
 * 解释：我们可以指定 a = 1 且 b = 1 以满足满足这两个方程。
 * 示例 3：
 *
 * 输入：["a==b","b==c","a==c"]
 * 输出：true
 * 示例 4：
 *
 * 输入：["a==b","b!=c","c==a"]
 * 输出：false
 * 示例 5：
 *
 * 输入：["c==c","b==d","x!=z"]
 * 输出：true
 *  
 */
public class EquationsPossible {

    public static class Node {
        int val;

        List<Node> cons = new ArrayList<>();

        boolean isConnectedTo(Node that) {
            return this.val == that.val;
        }

        void connect(Node that) {

            if (this.val < that.val) {
                that.notifyValueChangeTo(this.val);
            } else if (this.val > that.val)
                this.notifyValueChangeTo(that.val);
            this.cons.add(that);
            that.cons.add(this);
        }

        void notifyValueChangeTo(int val) {
            this.val = val;
            cons.stream().filter(n -> n.val != val)
                    .forEach(n -> n.notifyValueChangeTo(val));
        }

        static Node of(int v) {
            Node node = new Node();
            node.val = v;
            return node;
        }
    }

    // 只记录相等的情况
    public static boolean equationsPossible(String[] equations) {
        HashMap<Integer, Node> eqCache = new HashMap<>();
        List<int[]> neq = new ArrayList<>();
        for (String equation : equations) {
            int l = equation.charAt(0);
            int r = equation.charAt(3);
            if (equation.charAt(1) == '=') {
                Node ls = eqCache.computeIfAbsent(l, Node::of);
                Node rs = eqCache.computeIfAbsent(r, Node::of);
                ls.connect(rs);
            } else {
                if (l == r)
                    return false;
                neq.add(new int[]{l, r});
            }
        }

        for (int[] lr : neq) {
            Node sl = eqCache.get(lr[0]);
            if (sl == null)
                continue;
            Node sr = eqCache.get(lr[1]);
            if (sr== null)
                continue;

            if (sl.isConnectedTo(sr))
                return false;
        }
        
        return true;
    }

}
