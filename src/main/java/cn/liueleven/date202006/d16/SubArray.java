package cn.liueleven.date202006.d16;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 一定要写注释啊
 * @date: 2020-06-16 22:21
 * @author: 十一
 */
public class SubArray {

    @Test
    public void testSubArray() {
        int[] nums = {-2,1,-1,4,-1,2,-5,3};
        SubArray sub = new SubArray();
        System.out.println(sub.subArray(nums));
    }

    public int subArray(int[] nums) {

        int opt[] = new int[nums.length];
        opt[0] = nums[0];
        opt[1] = nums[0] > nums[1] ? nums[0] : nums[1];

        for (int i = 2; i < nums.length; i++) {
            int a1 = nums[i];
            int a2 = opt[i - 1] + nums[i];
            int a3 = opt[i - 1];
            opt[i] = max(a1,a2,a3);

        }

        System.out.println(Arrays.toString(opt));
        return opt[nums.length-1];
    }

    public int max(int ...nums) {
        int m = 0;
        for (int num : nums) {
            if(num > m) {
                m = num;
            }
        }
        return m;
    }
}
