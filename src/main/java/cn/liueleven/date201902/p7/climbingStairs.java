package cn.liueleven.date201902.p7;

/**
 * @description: 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date: 2020-02-24 17:14
 * @author: 十一
 */
public class climbingStairs {

    public static void main(String[] args) {
        System.out.println(new climbingStairs().climbStairs(4));
    }

    int climbStairs(int n ){
        if(n <= 2) {
            return n;
        }

        // 先创建一个数组来保存历史数据
        int[] dp = new int[n+1];
        // 特殊情况提前给出初始值
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        // 通过关系式来计算出 dp[n]
        for(int i = 3; i <= n; i++){
            // 每次将算过的保存起来
            dp[i] = dp[i-1] + dp[i-2];
        }
        // 把最终结果返回
        return dp[n];
    }
}
