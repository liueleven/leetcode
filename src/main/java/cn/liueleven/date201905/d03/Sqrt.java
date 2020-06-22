package cn.liueleven.date201905.d03;

import org.junit.Assert;

/**
 * @description: x 的平方根： https://leetcode-cn.com/explore/learn/card/binary-search/209/template-i/836/
 *
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 *
 *
 * @date: 2020-05-03 16:21
 * @author: 十一
 */
public class Sqrt {

    public static void main(String[] args) {
        int input = 4;
        int r = sqrt(input);
        System.out.println(String.format("input: %s, sqrt: %s", input,r));
        Assert.assertEquals(2,r);

        input = 8;
        r = sqrt(input);
        System.out.println(String.format("input: %s, sqrt: %s", input,r));
        Assert.assertEquals(2,r);

        input = 15;
        r = sqrt(input);
        System.out.println(String.format("input: %s, sqrt: %s", input,r));
        Assert.assertEquals(3,r);
    }



    /**
     * int mySqrt(int x)
     *     {
     *         if(x == 1)
     *             return 1;
     *         int min = 0;
     *         int max = x;
     *         while(max-min>1)
     *         {
     *             int m = (max+min)/2;
     *             if(x/m<m)
     *                 max = m;
     *             else
     *                 min = m;
     *         }
     *         return min;
     *     }
     * @param input
     * @return
     */
    private static int sqrt(int input) {
        // 定义好边界
        int left = 0;
        int right = input;
        // 循环退出条件
        while (right - left > 1 ) {
            // 二分
            int mid = (right - left) / 2 + left;
            // 判断比较，缩短比较范围
            if (input / mid < mid) {
                // 太大了，缩小范围，mid * mid > input 可能有溢出风险
                right = mid;
            }else {
                left = mid;
            }
        }
        return left;
    }
}
