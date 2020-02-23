package cn.liueleven.date201902.p5;

/**
 * @description: 暴力破解法
 * @date: 2019-02-17 13:34
 * @author: 十一
 */
public class Violence implements LongestPalindrome{


    @Override
    public  String longestPalindrome(String s) {
        int len = s.length();
        String maxStr = "";
        int maxLen = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                String substring = s.substring(i, j);
                if (isPalindromic(substring) && substring.length() > maxLen) {
                    maxLen = substring.length();
                    maxStr = substring;
                }
            }
        }
        return maxStr;

    }

    /**
     * 比较一个字符串是否是回文
     * @param s
     * @return
     */
    public boolean isPalindromic(String s) {
        int length = s.length() / 2;
        int len = s.length();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

}
