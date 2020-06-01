package algorithm;

import pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 199. 二叉树的右视图
 *
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 */
public class RightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<TreeNode> ts = new ArrayList<>(), roll = new ArrayList<>(), tmp;
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        ts.add(root);
        while (!ts.isEmpty()) {
            TreeNode last = ts.get(ts.size() - 1);
            ans.add(last.val);
            for (TreeNode t : ts) {
                if (t.left != null)
                    roll.add(t.left);
                if (t.right != null)
                    roll.add(t.right);
            }
            tmp= ts;
            ts = roll;
            roll = tmp;
            roll.clear();
        }

        return ans;
    }

}
