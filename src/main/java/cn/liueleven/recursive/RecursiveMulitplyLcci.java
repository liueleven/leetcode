package cn.liueleven.recursive;

import org.junit.Assert;
import org.junit.Test;

/**
 * @description:
 * 递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。可以使用加号、减号、位移，但要吝啬一些。
 *
 * 示例1:
 *
 *  输入：A = 1, B = 10
 *  输出：10
 * 示例2:
 *
 *  输入：A = 3, B = 4
 *  输出：12
 * 提示:
 *
 * 保证乘法范围不会溢出
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/recursive-mulitply-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @date: 2020-06-21 22:32
 * @author: 十一
 */
public class RecursiveMulitplyLcci {

    @Test
    public void test1() {
        Assert.assertEquals(8,f1(2,4));
        Assert.assertEquals(10,f1(2,5));
        Assert.assertEquals(25,f1(5,5));
        Assert.assertEquals(21,f1(3,7));
    }

    public int f1(int A,int B) {
        if (A == 0 || B == 0) {
            return 0;
        }
        if (B == 1) {
            return A;
        }
        // 需要保证A大于B，这样减少循环次数
        int max;
        if (A < B) {
            max = B;
            B = A;
            A = max;
        }


        return A + f1(A,B -1);

    }


}
