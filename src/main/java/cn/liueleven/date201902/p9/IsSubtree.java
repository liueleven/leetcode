package cn.liueleven.date201902.p9;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。
 * s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subtree-of-another-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @description: 一定要写注释啊
 * @date: 2020-04-19 18:27
 * @author: 十一
 */
public class IsSubtree {

    @Test
    public void test1() {
        TreeNode t1 = new TreeNode(1);
        t1.right = new TreeNode(2);
        t1.left = new TreeNode(3);


        TreeNode t2 = new TreeNode(1);
        t2.right = new TreeNode(2);
        t2.left = new TreeNode(3);

        IsSubtree isSubtree = new IsSubtree();
        boolean subtree = isSubtree.isSubtree(t1, t2);
        Assert.assertTrue(subtree);
    }

    @Test
    public void test2() {
        TreeNode t1 = new TreeNode(1);
        t1.right = new TreeNode(2);
        t1.left = null;


        TreeNode t2 = new TreeNode(1);
        t2.right = new TreeNode(2);
        t2.left = new TreeNode(3);

        IsSubtree isSubtree = new IsSubtree();
        boolean subtree = isSubtree.isSubtree(t1, t2);
        Assert.assertFalse(subtree);
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        System.out.println(String.format("s.val= %s,t.val= %s", s.val,t.val));
        if (s.val == t.val) {
            if(tranverse(s.left,t.left) && tranverse(s.right,t.right)){
                return true;
            }
        }

        return isSubtree(s.left,t) || isSubtree(s.right,t);

    }

    public  boolean tranverse(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val == t.val) {
            return tranverse(s.left,t.left) && tranverse(s.right,t.right);
        }
        return false;
    }

    /**
     * Definition for a binary tree node.
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
