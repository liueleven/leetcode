package cn.liueleven.date201902.p2020.p03;

import com.sun.org.apache.regexp.internal.RE;
import org.junit.Assert;

import java.util.regex.Pattern;

/**
 * @description: https://leetcode-cn.com/problems/string-to-integer-atoi/
 * 输入一个字符串将开头有效的字符数字转换成整数输出，- 负号也是正常的，超过int最大最小值则输出最大最小值即可
 * 例如：
 * "22334"                -> 22334
 * "-23ssd"               -> -23
 * "999999999999999990"   -> 2147483647
 * "abc 23"               -> 0
 * "   23"                -> 23
 * @date: 2020-03-22 11:14
 * @author: 十一
 */
public class Atoi {

    public static void main(String[] args) {
        System.out.println(Pattern.matches("\\d", "2"));
        String str = "22334";
        Assert.assertEquals(22334, new Atoi().myAtoi(str));
        str = "-23ssd";
        Assert.assertEquals(-23, new Atoi().myAtoi(str));
        str = "abc 23";
        Assert.assertEquals(0, new Atoi().myAtoi(str));
        str = "     2  3";
        Assert.assertEquals(2, new Atoi().myAtoi(str));
        str = "99999999999";
        Assert.assertEquals(Integer.MAX_VALUE, new Atoi().myAtoi(str));
        str = "  -42";
        Assert.assertEquals(-42, new Atoi().myAtoi(str));
        str = "  -";
        Assert.assertEquals(0, new Atoi().myAtoi(str));
        str = "+1";
        Assert.assertEquals(1, new Atoi().myAtoi(str));
        str = "+";
        Assert.assertEquals(0, new Atoi().myAtoi(str));
        str = "-91283472332";
        Assert.assertEquals(-2147483648, new Atoi().myAtoi(str));
        str = "   +0 123";
        Assert.assertEquals(0, new Atoi().myAtoi(str));
        str = "  0000000000012345678";
        Assert.assertEquals(12345678, new Atoi().myAtoi(str));
        str = "20000000000000000000";
        Assert.assertEquals(Integer.MAX_VALUE, new Atoi().myAtoi(str));
        str = "-   234";
        Assert.assertEquals(0, new Atoi().myAtoi(str));
    }

    public int myAtoi(String str) {
        System.out.println("in:" + str);
        if (str == null || str.length() == 0) {
            return 0;
        }
        int symbol = 1;
        str = str.trim();
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        str = str.trim();
        for (int i = 0; i < str.length(); i++) {
            if ((int)' ' == (int)str.charAt(i)) {
                if (sb.length() > 0 || !" ".equals(String.valueOf(str.charAt(0)))) {
                    break;
                }
                continue;
            }

            if ((int)'-' == (int)str.charAt(i) && i == 0) {
                symbol = -1;
                flag = true;
                continue;
            }
            if ((int)'+' == (int)str.charAt(i) && i == 0) {
                flag = true;
                continue;
            }

            if (Pattern.matches("\\d",String.valueOf(str.charAt(i)))) {
               sb.append(str.charAt(i));
            }else if (i == 0){
                return 0;
            } else {
                break;
            }

        }

        String s = sb.toString();
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            if (String.valueOf(s.charAt(i)).equals("0")) {
                idx ++;
            }else {
                break;
            }

        }
        s = s.substring(idx);
        if (s.length() == 0) {
            return 0;
        }
        if (s.length() > 10) {
            return symbol > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        Long a = Long.valueOf(s) * symbol;
        int res = a > Integer.MAX_VALUE
                ? Integer.MAX_VALUE : (a < Integer.MIN_VALUE
                ? Integer.MIN_VALUE : a.intValue());
        System.out.println(res);

        return res;

    }

}
