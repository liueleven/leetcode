package cn.liueleven.date201902.p6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @description: 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * @date: 2020-02-17 10:34
 * @author: 十一
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        // 3
//        String s = "abcabcbb";
        // 1
//        String s = "bbbbbbb";
        // 3
        String s = "pwwkew";
        // 1
//        String s = " ";
//        // 0
//        String s = "";
        // 1
//        String s = "c";
        LongestSubstringWithoutRepeatingCharacters lswrc = new LongestSubstringWithoutRepeatingCharacters();
        int longest = lswrc.lengthOfLongestSubstring2(s);
        System.out.println("长度：" + longest);

    }

    /**
     * 执行了 17 ms
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.trim().length() == 0) {
            return 1;
        }
        int max = 0;
        List result = new ArrayList();
        for (int i = 0; i < s.length(); i++) {
            char num = s.charAt(i);
            if (!result.contains(num)) {
                result.add(num);
                continue;
            }
            max = result.size() > max ? result.size() : max;
            // 删除前面重复的
            Iterator iterator = result.iterator();
            while (iterator.hasNext()) {
                if (iterator.next().equals(num)) {
                    iterator.remove();
                    break;
                } else {
                    iterator.remove();
                }
            }
            result.add(num);
        }
        return result.size() > max ? result.size() : max;
    }

    /**
     * 抄别人的 3 ms
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        // 128 是因为ascii就128个字符
        int nums[] = new int[128];
        for (int i = 0; i < 128; i++) {
            nums[i] = -1;
        }

        //l是第一个非重复元素的下标。
        //cur是当前计数器的值
        int l = 0, max = 0, curLen = 0, sLen = s.length();
        for (int i = 0; i < sLen; i++) {
            // 使用了ascii 码表 https://baike.baidu.com/item/ASCII/309296?fromtitle=ascii%E7%A0%81%E8%A1%A8&fromid=19660475&fr=aladdin 字符转换
            // 让int数组的元素和下标都有意义，下标表示：是哪个字符，数组元素表示：在字符串中的下标
            int index = s.charAt(i);
            if (nums[index] < l) {
                nums[index] = i;
                curLen++;
            } else {

                max = curLen > max ? curLen : max;
                curLen -= nums[index] - l;
                l = nums[index] + 1;
                nums[index] = i;
            }
        }
        return curLen > max ? curLen : max;
    }
}
