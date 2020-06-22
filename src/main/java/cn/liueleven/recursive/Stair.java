package cn.liueleven.recursive;

import org.junit.Assert;
import org.junit.Test;

/**
 * @description:
 * 题目：小青蛙跳台阶，一次只能是1个或2个台阶，跳到n个有多少种跳法。
 *
 * 当 n=1 return 1, n=2 return 2;
 *
 * 递归方程：f(n) = f(n-1) + f(n-2);
 * @date: 2020-06-18 00:14
 * @author: 十一
 */
public class Stair {


    @Test
    public void test1() {
        int r = f(1);
        Assert.assertEquals(r,1);
        r = f(2);
        Assert.assertEquals(r,2);
        r = f(3);
        Assert.assertEquals(r,3);
        r = f(4);
        Assert.assertEquals(r,5);
        r = f(5);
        Assert.assertEquals(r,8);
    }

    public int f(int n) {
        if (n <= 2) {
            return n;
        }
        return f(n-1) + f(n-2);
    }
}
