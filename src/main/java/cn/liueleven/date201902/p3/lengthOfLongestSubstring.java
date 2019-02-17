package cn.liueleven.date201902.p3;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

    示例 1:
    输入: "abcabcbb"
    输出: 3
    解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

 * @date: 2019-02-17 11:12
 * @author: 十一
 */
public class lengthOfLongestSubstring {

    public static void main(String[] args) {
//        String str = "pwwkew";
//        String str = "bbbbb";
        String str = "abccbcbb";
//        String str = "abcabcbb";
//        String str = "ohvhjdml";
//        String str = "au";
//        String str = "";
        int maxStrLength = findMaxStrLength(str);
        System.out.println("输入：" + str);
        System.out.println("长度：" + maxStrLength);
    }

    /**
     * 方案一：暴力破解法，如果有重复，不断移动下标，直到全部遍历完
     *
     * @param str
     * @return
     */
//    public static int findMaxStrLength(String str) {
//
//        if(str == null || "".equals(str)) {
//            return 0;
//        }
//
//        if(str.length() == 1) {
//            return 1;
//        }
//
//        String[] strings = str.split("");
//        int pos = 0;
//        String tmp = "";
//        String maxStr = "";
//        int maxLen = 0;
//        int index = 0;
//        while (pos < str.length() && index < strings.length ) {
//            if(tmp.contains(strings[index])) {
//                if(maxLen < tmp.length()) {
//                    maxLen = tmp.length();
//                    maxStr = tmp;
//                }
//                pos += 1;
//                index = pos;
//                tmp = "";
//
//            }else {
//                tmp = tmp + strings[index];
//                index += 1;
//            }
//
//        }
//        if(maxLen < tmp.length()) {
//            maxLen = tmp.length();
//            maxStr = tmp;
//        }
//
//
//        System.out.println("子串：" + maxStr);
//        return maxLen;
//    }

    /**
     * 这是官网的最优解，只需要O(n)即可，还是遍历该字符串，只是返回长度，没有返回子串
     * @param s
     * @return
     */
    public static int findMaxStrLength(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
