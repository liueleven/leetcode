package cn.liueleven.date201902.p8;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 *
 *
 *
 * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
 *
 * 说明：m 和 n 的值均不超过 100。
 *
 * 示例 1:
 *
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * 示例 2:
 *
 * 输入: m = 7, n = 3
 * 输出: 28
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date: 2020-02-24 18:56
 * @author: 十一
 */
public class UniquePaths {
    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;

    // runState is stored in the high-order bits
    private static final int RUNNING    = -1 << COUNT_BITS;
    private static final int SHUTDOWN   =  0 << COUNT_BITS;
    private static final int STOP       =  1 << COUNT_BITS;
    private static final int TIDYING    =  2 << COUNT_BITS;
    private static final int TERMINATED =  3 << COUNT_BITS;
    public static void main(String[] args) throws Exception {
//
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.execute(null);
//        System.out.println("RUNNING: "+RUNNING);
//        System.out.println("SHUTDOWN: "+SHUTDOWN);
//        System.out.println("STOP: "+STOP);
//        System.out.println("TIDYING: "+TIDYING);
//        System.out.println("TERMINATED: "+TERMINATED);
//        executorService.submit()
//        gotoLabel();

        Map map = new HashMap<Integer,Integer>(1);
        map.put(1,1);
        map.put(3,3);
        map.put(2,2);

        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }

        TreeMap treeMap = new TreeMap<Integer,Integer>();
        treeMap.put(1,1);
        treeMap.put(3,3);
        treeMap.put(2,2);
        Iterator iterator1 = treeMap.entrySet().iterator();
        while (iterator1.hasNext()) {
            Object next = iterator1.next();
            System.out.println(next);
        }
    }

    static void gotoLabel() {
        int count = 2;
        label:
        while (true) {
            if (count > 10) {
                continue label;
            }
            System.out.println(count);
            count ++;
        }

    }

    public  int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 1;
        }

        int[][] dp = new int[m][n];
        // 初始化
        for(int i = 0; i < m; i++){
            dp[i][0] = 1;
        }
        for(int i = 0; i < n; i++){
            dp[0][i] = 1;
        }
        // 有0的下标都初始为1了，所以从1开始
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        // 网格是从1开始的，数组是从0开始的，所以这里数组下标都要减1
        return dp[m-1][n-1];
    }

    private static class Test implements Callable {

        /**
         * Computes a result, or throws an exception if unable to do so.
         *
         * @return computed result
         * @throws Exception if unable to compute a result
         */
        @Override
        public Object call() throws Exception {
            TimeUnit.SECONDS.sleep(2);
            return "hello";
        }
    }

}
