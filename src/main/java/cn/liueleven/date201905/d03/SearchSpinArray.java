package cn.liueleven.date201905.d03;

import org.junit.Assert;

import java.util.Arrays;

/**
 * @description: 一定要写注释啊
 * @date: 2020-05-04 17:18
 * @author: 十一
 */
public class SearchSpinArray {

    public static void main(String[] args) {
        int target = 2;
        int[] nums = {4,5,6,7,0,1,2};
        int r = search(nums,target);
        Assert.assertEquals(7,r);
    }

    private static int search(int[] nums, int target) {
        int[] arr = sort(nums);

        int left = 0;
        int right = arr.length - 1;
        while (right - left > 0) {
            int mid = (right - left) / 2 + left;
            if (arr[mid] > target) {
                right = mid;
            }else if(arr[mid] < target) {
                left = mid;
            }else {
                return mid;
            }
        }

        return -1;
    }

    private static int[] sort(int[] nums) {
        int flag = 0;
        int[] array = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] > nums[i]) {
                flag = i;
                break;
            }
        }
        if (flag == 0) {
            return nums;
        }
        System.arraycopy(nums,flag,array,0,nums.length-flag);
        System.arraycopy(nums,0,array,flag-1,flag);
        return array;
    }
}
