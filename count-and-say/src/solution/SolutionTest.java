package solution;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Carl
 * @Date: 2021/02/15/22:28
 * @Description:
 * 给定一个正整数 n ，输出外观数列的第 n 项。
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 * 你可以将其视作是由递归公式定义的数字字符串序列：
 * countAndSay(1) = "1"
 * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
 * 前五项如下：
 *  1.     1
 *  2.     11
 *  3.     21
 *  4.     1211
 *  5.     111221
 *  第一项是数字 1
 *  描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
 *  描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
 *  描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
 *  描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
 *  要描述一个数字字符串，首先要将字符串分割为最小数量的组，每个组都由连续的最多相同字符组成。然后对于每个组，先描述字符的数量，然后描述字符，形成一个描述组。要将描述转换为数字字符串，先将每组中的字符数量用数字替换，再将所有描述组连接起来。
 *
 *  输入：n = 4
 *  输出："1211"
 */
public class SolutionTest {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.countAndSay(4);
        System.out.println(s);
    }
    //for循环
//    public String countAndSay(int n) {
//        StringBuilder result = new StringBuilder();
//        result.append(1);
//        for (int i = 1; i < n; i++) {
//            StringBuilder current = new StringBuilder();
//            int start = 0;
//            for (int j = 1; j < result.length(); j++) {
//                if (result.charAt(j) != result.charAt(start)) {
//                    current.append(j - start).append(result.charAt(start));
//                    start = j;
//                }
//            }
//            current.append(result.length() - start).append(result.charAt(start));
//            result = current;
//        }
//        return result.toString();
//    }
//}
}
//递归
class Solution {
    public String countAndSay(int n) {
        // 递归终止条件
        if (n == 1) {
            return "1";
        }
        // 获取到上一层的字符串
        String s = countAndSay(n - 1);
        StringBuilder result = new StringBuilder();
        // 记录每个数字的开始索引
        int start = 0;
        for (int i = 1; i < s.length(); i++) {
            // 当数字发生改变时执行
            if (s.charAt(i) != s.charAt(start)) {
                result.append(i - start).append(s.charAt(start));
                start = i;
            }
        }
        // 字符串最后一个数字
        result.append(s.length() - start).append(s.charAt(start));
        return result.toString();
    }
}
