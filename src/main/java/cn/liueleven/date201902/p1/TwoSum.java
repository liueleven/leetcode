package cn.liueleven.date201902.p1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 两数之和
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.

    Example：
    Given nums = [2, 7, 11, 15], target = 9,

    Because nums[0] + nums[1] = 2 + 7 = 9,
    return [0, 1].

 * @date: 2019-02-16 10:50
 * @author: 十一
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums =  {3,2,4};
        int target = 6;
        int[] result = returnIndices(nums,target);
        System.out.println(Arrays.toString(result));
    }

    // 方案一
//    public static int[] returnIndices(int[] nums,int target) {
//        if(nums == null || nums.length < 2) {
//            return new int[0];
//        }
//
//        Map<Integer,Integer> map = new HashMap<Integer,Integer>(nums.length);
//        for(int i=0; i<nums.length; i++) {
//            map.put(nums[i],i);
//        }
//
//        for (int i=0; i<nums.length; i++) {
//            int result = target - nums[i];
//            // 一个数只能使用一次
//            if(map.get(result) != null && map.get(result) != i) {
//                return new int[]{i,map.get(result)};
//            }
//        }
//        return new int[0];
//    }

    // 方案二
    public static int[] returnIndices(int[] nums,int target) {
        if(nums == null || nums.length < 2) {
            return new int[0];
        }

        Map<Integer,Integer> map = new HashMap<Integer,Integer>(nums.length);
        for (int i=0; i<nums.length; i++) {
            int result = target - nums[i];
            if(map.get(result) != null && map.get(result) != i) {
                return new int[]{map.get(result),i};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }
}
