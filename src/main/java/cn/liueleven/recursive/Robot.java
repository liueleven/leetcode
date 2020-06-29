package cn.liueleven.recursive;

import org.junit.Assert;
import org.junit.Test;

/**
 * @description:
 *
 * 有一个 m * n 的网格，机器人一次只能走一个格点，且只能向右或向下走，要从左上角走到右下角。请设计一个算法，计算机器人有多少种走法。
 *
 * @date: 2020-06-25 12:41
 * @author: 十一
 */
public class Robot {

    @Test
    public void testF1() {
        Assert.assertEquals(6,f1(3, 3));
        Assert.assertEquals(1,f1(1, 3));
        Assert.assertEquals(2,f1(2, 2));
    }

    @Test
    public void testF2() {
        Assert.assertEquals(2,f2(2, 2));
        Assert.assertEquals(6,f2(3, 3));
        Assert.assertEquals(1,f2(1, 3));
    }


    public int f1(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }

        return f1(m-1,n) + f1(m,n-1);
    }

    public int f2(int m, int n) {
        int[][] r = new int[m+1][n+1];
        r[0][0] = 0;
        for (int i = 1; i <= m; i++) {
            for (int i1 = 1; i1 <= n; i1++) {
                if (i1 - 1 == 0 || i - 1 == 0) {
                    r[i][i1] = 1;
                    continue;
                }
                r[i][i1] = r[i-1][i1] + r[i][i1-1];
            }
        }
        return r[m][n];
    }
}
