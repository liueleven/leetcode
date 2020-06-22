package cn.liueleven.date202006.d16;

import org.junit.Assert;
import org.junit.Test;

/**
 * @description:
 * 在一组数中，求不相邻之间的数最大和是多少
 * 例如：
 * 3 3 4 1 9 3 6 6
 * 最大值是 22
 * @date: 2020-06-16 02:32
 * @author: 十一
 */
public class Sum {

    @Test
    public void testRecOpt() {
        int[] arr = {3,3,4,1,9,3,6,6};
        int i = arr.length;
        Sum sum = new Sum();
        int r = sum.recOpt(i, arr);
        System.out.println(r);
        Assert.assertEquals(22,r);

        int[] arr2 = {1,2,4,1,7,8,3};
        int i2 = arr2.length;
        r = sum.recOpt(i2, arr2);
        System.out.println(r);
        Assert.assertEquals(15,r);
    }

    @Test
    public void testDpOpt() {
        int[] arr = {3,3,4,1,9,3,6,6};
        Sum sum = new Sum();
        int r = sum.dpOpt(arr);
        System.out.println(r);
        Assert.assertEquals(22,r);

        int[] arr2 = {1,2,4,1,7,8,3};
        r = sum.dpOpt(arr2);
        System.out.println(r);
        Assert.assertEquals(15,r);
    }

    /**
     * 递归求最优解
     * @param i      序号 - 1 = 数组下标
     * @param arr    数组
     * @return
     */
    public int recOpt(int i,int[] arr) {
        // 1. 递归先写退出条件
        if (i == 1) {
            return arr[i - 1];
        }
        if (i == 2) {
            return max(arr[i - 1], arr[i - 2]);
        }
        // 2. 选，就是左边隔一个的最优解 + 自己
        int a = recOpt(i - 2,arr) + arr[i - 1];
        // 3. 不选，就是左边的最优解
        int b = recOpt(i-1,arr);
        return max(a,b);
    }

    public int max(int a,int b) {
        return a > b ? a : b;
    }

    public int dpOpt(int[] arr) {
        // 保存每种情况的值
        int opt[] = new int[arr.length];
        // 这两种情况是已知的
        opt[0] = arr[0];
        opt[1] = max(arr[0],arr[1]);

        for (int i = 2; i < arr.length; i++) {
            int a = opt[i - 2] + arr[i];
            int b = opt[i - 1];
            opt[i] = max(a,b);
        }
        return opt[arr.length -1];

    }
}
