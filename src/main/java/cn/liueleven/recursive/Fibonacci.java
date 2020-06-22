package cn.liueleven.recursive;

import org.junit.Assert;
import org.junit.Test;

/**
 * @description:
 *
 * 斐波那契数列，求第 n 位是数多少
 * 1 1 2 3 5 8 13 21
 *
 * 从第 3 位数开始，它的值是前两位的和；
 *
 * 当 n = 1 or 2 return;
 *
 * 递归方程：f(n) = f(n-1) + f(n-2);
 * @date: 2020-06-18 00:09
 * @author: 十一
 */
public class Fibonacci {

    @Test
    public void test1() {
        int r = f(5);
        Assert.assertEquals(r,5);
        r = f(4);
        Assert.assertEquals(r,3);
        r = f(3);
        Assert.assertEquals(r,2);
        r = f(6);
        Assert.assertEquals(r,8);
        r = f(7);
        Assert.assertEquals(r,13);
        r = f(1);
        Assert.assertEquals(r,1);
        r = f(2);
        Assert.assertEquals(r,1);
    }

    public int f(int n) {
        if (n <= 2) {
            return 1;
        }
        return f(n-1) + f(n-2);
    }
}
