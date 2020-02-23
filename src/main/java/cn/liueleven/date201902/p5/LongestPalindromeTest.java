package cn.liueleven.date201902.p5;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @description: 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * @date: 2020-02-23 15:25
 * @author: 十一
 */
public class LongestPalindromeTest {




    private LongestPalindrome longestPalindrome;

    @Before
    public void init() {
        // 暴力破解法
        longestPalindrome = new Violence();
    }


    @Test
    public void test2() {
        String str1 = "dabaabad";
        String palindrome = longestPalindrome.longestPalindrome(str1);
        Assert.assertEquals("dabaabad",palindrome);
        System.out.println(longestPalindrome.longestPalindrome(str1));
    }

    @Test
    public void test3() {
        String str1 = "cbbd";
        String palindrome = longestPalindrome.longestPalindrome(str1);
        Assert.assertEquals("bb",palindrome);
        System.out.println(longestPalindrome.longestPalindrome(str1));
    }

    @Test
    public void test4() {
        String str1 = "dababad";
        String palindrome = longestPalindrome.longestPalindrome(str1);
        Assert.assertEquals("dababad",palindrome);
        System.out.println(longestPalindrome.longestPalindrome(str1));
    }

    @Test
    public void test5() {
        String str1 = "babad";
        String palindrome = longestPalindrome.longestPalindrome(str1);
        Assert.assertEquals("bab",palindrome);
        System.out.println(longestPalindrome.longestPalindrome(str1));
    }

    @Test
    public void test6() {
        String str1 = "ac";
        String palindrome = longestPalindrome.longestPalindrome(str1);
        Assert.assertEquals("a",palindrome);
        System.out.println(longestPalindrome.longestPalindrome(str1));
    }

    @Test
    public void test7() {
        String str1 = "bb";
        String palindrome = longestPalindrome.longestPalindrome(str1);
        Assert.assertEquals("bb",palindrome);
        System.out.println(longestPalindrome.longestPalindrome(str1));
    }

    @Test
    public void test8() {
        String str1 = "abb";
        String palindrome = longestPalindrome.longestPalindrome(str1);
        Assert.assertEquals("bb",palindrome);
        System.out.println(longestPalindrome.longestPalindrome(str1));
    }
}
