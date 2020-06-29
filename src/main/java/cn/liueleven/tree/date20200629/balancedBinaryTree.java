package cn.liueleven.tree.date20200629;

import org.junit.Assert;
import org.junit.Test;

/**
 * @description: 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * <p>
 * 示例 1:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7]
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回 true 。
 * <p>
 * 示例 2:
 * <p>
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * <p>
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * 返回 false 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/balanced-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date: 2020-06-29 15:32
 * @author: 十一
 */
public class balancedBinaryTree {

    @Test
    public void f1Test() {

        TreeNode n1
                = buildBinaryTree(new TreeNode()
                , new Integer[]{3, 9, 20, null, null, 15, 7}, 1);

        Assert.assertTrue(f1(n1));

        TreeNode n2
                = buildBinaryTree(new TreeNode()
                , new Integer[]{1,2,2,3,3,null,null,4,4}, 1);

        Assert.assertFalse(f1(n2));

        TreeNode n3
                = buildBinaryTree(new TreeNode()
                , new Integer[]{1,2,2,3,null,null,3,4,null,null,4}, 1);

        Assert.assertFalse(f1(n3));

    }

    @Test
    public void isBalanceTest() {
        TreeNode n1
                = buildBinaryTree(new TreeNode()
                , new Integer[]{3, 9, 20, null, null, 15, 7}, 1);

        Assert.assertTrue(isBalanced(n1));

        TreeNode n2
                = buildBinaryTree(new TreeNode()
                , new Integer[]{1,2,2,3,3,null,null,4,4}, 1);

        Assert.assertFalse(isBalanced(n2));

        TreeNode n3
                = buildBinaryTree(new TreeNode()
                , new Integer[]{1,2,2,3,null,null,3,4,null,null,4}, 1);

        Assert.assertFalse(isBalanced(n3));
    }


    public boolean f1(TreeNode root) {
        if (root == null) {
            return true;
        }
        return height(root) != -1;

    }

    private int height(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int lh = height(root.left);
        if (lh == -1) {
            return -1;
        }
        int rh = height(root.right);
        if (rh == -1) {
            return -1;
        }
        // 深度加1
        // 如果左边和右边相差值大于2，那么就是不平衡，返回 -1
        // 如果左边和右边相差值小于2，那么只要让最高的那个加1，因为小的那个也只是小1，在当前节点是平衡的
        return Math.abs(lh-rh) < 2 ? Math.max(lh, rh) + 1 : -1;

    }

    // 用数组建立普通二叉树
    public TreeNode buildBinaryTree(TreeNode root, Integer[] nums, int index) {
        if (root == null) {
            return root;
        }
        if (index > nums.length / 2)
            return root;
        if (index == 1)
            root.val = nums[0];
        Integer lv = nums[index * 2 - 1];
        if (lv == null) {
            root.left = null;
        }else {
            root.left = new TreeNode();
        }

        Integer rv = nums[index * 2];
        if (rv == null) {
            root.right = null;
        }else {
            root.right = new TreeNode(rv);
        }
        buildBinaryTree(root.left, nums, index + 1);
        buildBinaryTree(root.right, nums, index + 2);
        return root;
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public TreeNode() {
        }


    }


    boolean res = true;

    public boolean isBalanced(TreeNode root) {

        helper(root);
        return res;

    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left) + 1;
        int right = helper(root.right) + 1;
        if (Math.abs(right - left) > 1) res = false;
        return Math.max(left, right);
    }

}
