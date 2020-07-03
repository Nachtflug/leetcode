package algorithm;

import pojo.TreeNode;

/**
 * 108. 将有序数组转换为二叉搜索树难度简单480收藏分享切换为英文关注反馈将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortedArrayToBST {


    public TreeNode sortedArrayToBST(int[] nums) {
        return doBuild(nums, 0, nums.length);
    }

    private TreeNode doBuild(int[] nums, int st, int ed) {
        if (st == ed)
            return null;
        int mid = (st + ed) >> 1;
        TreeNode cur = new TreeNode(nums[mid]);

        cur.left = doBuild(nums, st, mid);
        cur.right = doBuild(nums, mid + 1, ed);

        return cur;
    }

}
