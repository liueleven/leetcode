package cn.liueleven.date201902.p8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: LeetCode https://leetcode-cn.com/problems/zigzag-conversion/
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 *
 * 其实就是将一串字母，按照N的格式打印出来
 * @date: 2020-03-20 22:37
 * @author: 十一
 */
public class ZigzagConversion {

    public static void main(String[] args) {
        String s = "1234567";
        int row = 2;
        System.out.println(new ZigzagConversion().convert(s, row));
    }



    /**
     * 找关系，行数的变化，分别是1234，4321，1234,...这样有规律的
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if(numRows < 2) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for(int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int flag = -1,i = 0,idx = 0;
        while (i < s.length()) {

            rows.get(idx).append(s.charAt(i));
            // 这两种情况要变化，也就是1-4，4-1，1-4，...,反复这样的过程
            if (idx == 0 || idx == numRows -1) {
                flag = - flag;
            }
            idx += flag;
            i ++;

        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder row : rows) {
            sb.append(row);
        }

        return sb.toString();
    }
}
