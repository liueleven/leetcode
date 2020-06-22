package cn.liueleven.date201905.d03;

import org.junit.Assert;

/**
 * @description: 二分查找：https://leetcode-cn.com/explore/learn/card/binary-search/208/background/833/
 *
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * 示例 1:
 *
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * 示例 2:
 *
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 *
 * 提示：
 *
 * 你可以假设 nums 中的所有元素是不重复的。
 * n 将在 [1, 10000]之间。
 * nums 的每个元素都将在 [-9999, 9999]之间。
 *
 *
 * @date: 2020-05-03 10:03
 * @author: 十一
 */
public class BinSearch {

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};

        int target = 0;
        int index = search(nums,target);
        System.out.println("index: " + index);
        Assert.assertEquals(1,index);

        target = -1;
        index = search(nums,target);
        System.out.println("index: " + index);
        Assert.assertEquals(0,index);

        target = 9;
        index = search(nums,target);
        System.out.println("index: " + index);
        Assert.assertEquals(4,index);

        target = 12;
        index = search(nums,target);
        System.out.println("index: " + index);
        Assert.assertEquals(5,index);

        target = 2;
        index = search(nums,target);
        System.out.println("index: " + index);
        Assert.assertEquals(-1,index);

        target = 13;
        index = search(nums,target);
        System.out.println("index: " + index);
        Assert.assertEquals(-1,index);

        target = -5;
        nums = new int[]{5};
        index = search(nums,target);
        System.out.println("index: " + index);
        Assert.assertEquals(-1,index);

        target = 2;
        nums = new int[]{2,3,5};
        index = search(nums,target);
        System.out.println("index: " + index);
        Assert.assertEquals(0,index);
    }

    private static int search(int[] nums,int target) {

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] > target) {
                right = mid - 1;
            }else if (nums[mid] < target) {
                left = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }


}
