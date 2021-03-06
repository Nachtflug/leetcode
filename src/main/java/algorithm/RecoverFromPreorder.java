package algorithm;

import pojo.TreeNode;

/**
 * 1028. 从先序遍历还原二叉树
 * 我们从二叉树的根节点 root 开始进行深度优先搜索。
 *
 * 在遍历中的每个节点处，我们输出 D 条短划线（其中 D 是该节点的深度），然后输出该节点的值。（如果节点的深度为 D，则其直接子节点的深度为 D + 1。根节点的深度为 0）。
 *
 * 如果节点只有一个子节点，那么保证该子节点为左子节点。
 *
 * 给出遍历输出 S，还原树并返回其根节点 root。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入："1-2--3--4-5--6--7"
 * 输出：[1,2,5,3,4,6,7]
 * 示例 2：
 *
 *
 *
 * 输入："1-2--3---4-5--6---7"
 * 输出：[1,2,5,3,null,6,null,4,null,7]
 * 示例 3：
 *
 *
 *
 * 输入："1-401--349---90--88"
 * 输出：[1,401,null,349,88,90]
 *
 *
 * 提示：
 *
 * 原始树中的节点数介于 1 和 1000 之间。
 * 每个节点的值介于 1 和 10 ^ 9 之间。
 */
public class RecoverFromPreorder {

    public static TreeNode recoverFromPreorder(String s) {
        if (s.length() == 0)
            return null;
        TreeNode[] nodes = new TreeNode[1000];

        char[] chars = s.toCharArray();
        int dig = 0, i = 0;
        while (i < chars.length && chars[i] != '-') {
            int w = chars[i] - '0';
            dig *= 10;
            dig += w;
            i++;
        }
        nodes[0] = new TreeNode(dig);
        int lastD = 0;
        while (i < chars.length) {
            int d = 0;
            while (chars[i] == '-') {
                d ++;
                i ++;
            }
            dig = 0;
            while (i < chars.length && chars[i] != '-') {
                int w = chars[i] - '0';
                dig *= 10;
                dig += w;
                i++;
            }
            TreeNode n = new TreeNode(dig);
            if (d <= lastD) {
                nodes[d - 1].right = n;
            } else {
                nodes[d - 1].left = n;
            }
            nodes[d] = n;
            lastD = d;
        }

        return nodes[0];
    }

    public static void main(String[] args) {

        TreeNode x = recoverFromPreorder("1-401--349---90--88");
        System.out.println(x);

    }

}
