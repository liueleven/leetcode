package cn.liueleven.recursive;

import org.junit.Assert;
import org.junit.Test;

/**
 * @description:
 *
 * 1. 求 n 的阶乘；
 *
 * 4 = 4 x 3 x 2 x 1
 * 3 = 3 x 2 x 1
 * 2 = 2 x 1
 * 1 = 1
 *
 * 当 n <= 2 return n；
 *
 * 递归方程：n x f(n-1);
 *
 * @date: 2020-06-17 07:44
 * @author: 十一
 */
public class Factorial {


    int [] arr;
    @Test
    public void test1() {

        int r = f(5);
        Assert.assertEquals(r,120);
        arr = null;
        r = f(4);
        Assert.assertEquals(r,24);
        arr = null;
        r = f(3);
        Assert.assertEquals(r,6);
        arr = null;
        r = f(2);
        Assert.assertEquals(r,2);
        arr = null;
        r = f(1);
        Assert.assertEquals(r,1);
    }



    public int f(int n) {
        if (n <= 2) {
            return n;
        }
        return n * f(n - 1);
    }

}
