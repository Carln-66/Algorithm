package strings;

/**
 * @Auther: Carl
 * @Date: 2021/06/06/22:14
 * @Description:
 */
public class LeetCode_8 {
    public int myAtoi(String s) {
        int i = 0;
        int len = s.length();
        int sign = 1;
        int res = 0;
        while (i < len && s.charAt(i) == ' ') { //如果字符串前导位置为空格，循环到有数据的那一个位置
            i++;
        }
        int start = i;  //记录一下当前之后所有数据开始的位置
        for (; i < len; i++) {
            int c = s.charAt(i);
            if (i == start && c == '+') {   //判断是否是+，并且+要在初始位置
                sign = 1;
            } else if (i == start && c == '-') {    //判断是-
                sign = -1;
            } else if (Character.isDigit(c)) {  //判断是数字
                int num = c - '0';
                //如果是数字，其他不用考虑，只需要考虑两种超限的情况，这里不细说，具体去"https://leetcode-cn.com/problems/reverse-integer/"看
                if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && num > Integer.MAX_VALUE % 10)) {
                    return Integer.MAX_VALUE;
                } else if (res < Integer.MIN_VALUE / 10 || (res ==Integer.MIN_VALUE / 10 && -num < Integer.MIN_VALUE % 10)) {
                    return  Integer.MIN_VALUE;
                }
                res = res * 10 + sign * num;
            } else {    //如果有一次循环既不是数字，又不是'+'和'-'，那么立即退出循环，并返回当前res中已经储存的值
                break;
            }
        }
        return res;
    }
}
