package cn.liueleven.date201902.p5;

/**
 * @description: 动态规划法，将一个字符串倒置然后比较，他们相同的最大字符串，就是回文
 * 例如：abad，倒置: daba  然后比较相同的字符串是 aba 那么 aba 就是最大回文了
 * @date: 2020-02-23 16:02
 * @author: 十一
 */
public class Dynamic implements LongestPalindrome {

    @Override
    public String longestPalindrome(String s) {
        if (s.equals("")) {
            return "";
        }
        String origin = s;
        //字符串倒置
        String reverse = new StringBuffer(s).reverse().toString();
        int length = s.length();
        int[][] arr = new int[length][length];
        // 最大字符串的长度
        int maxLen = 0;
        // 最大长度字符串索引的下标
        int maxEnd = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                // 比较公共子串 abcba  aba  aacdfcaa
//                1 0 1
//                0 2 0
//                1 0 3
//                System.out.println("origin: " + origin.charAt(i) + " reverse: " + reverse.charAt(j));
                if (origin.charAt(i) == reverse.charAt(j)) {
                    // 特殊处理
                    if (i == 0 || j == 0) {
                        arr[i][j] = 1;
                    } else {
                        // 这个位置元素 = 上一个位置的元素 + 1
                        arr[i][j] = (arr[i - 1][j - 1]) + 1;
                    }
                }
                int beforeRev = length - 1 - j;
                //判断下标是否对应
                if (beforeRev + arr[i][j] - 1 == i) {
                    maxLen = arr[i][j];
                    //以 i 位置结尾的字符
                    maxEnd = i;
                }
            }

        }
        // 截取字符串
        int start = maxEnd - maxLen + 1;
        int end = maxEnd + 1;
        return s.substring(start, end);
    }

    public static void main(String[] args) {
//        System.out.println(new Dynamic().longestPalindrome("aba"));
//        System.out.println(new Dynamic().longestPalindrome("aacdfcaa"));
//        System.out.println(new Dynamic().longestPalindrome("abcba"));
        System.out.println(new Dynamic().longestPalindrome("babad"));
    }
}


