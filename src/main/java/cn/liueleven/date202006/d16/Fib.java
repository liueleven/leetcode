package cn.liueleven.date202006.d16;

import org.junit.Test;

import java.io.File;

/**
 * @description: dp 求斐波那契数列 第 n 个数是多少
 *
 * 1, 1, 2, 3, 5, 8, 13...
 *
 * 例如：
 * 第4个数是3，
 * 第6个数是8
 * @date: 2020-06-16 00:02
 * @author: 十一
 */
public class Fib {


    @Test
    public void dpTest() {
        Fib fib = new Fib();
        System.out.println(fib.re(1));
        System.out.println(fib.re(2));
        System.out.println(fib.re(3));
        System.out.println(fib.re(4));
        System.out.println(fib.re(5));
        System.out.println(fib.re(6));
    }

    /**
     * 递归，但是重复的太多了 overlap
     * 公式：
     * f(n) = f(n-1) + f(n-2) and n = 1 or 2 return 1
     * @param i
     * @return
     */
    public int re(int i) {
        System.out.printf("i:" + i + ",");
        if (i == 1 || i == 2) {
            return 1;
        }

        int r = re(i - 1);
        int r2 = re(i - 2);
        System.out.println("r1:" + r + ",r2:" + r2 + ",i:"+i);
        return r+r2;
    }


}
