package array;

import java.util.*;

/**
 * @Auther: Carl
 * @Date: 2021/06/10/19:42
 * @Description: 括号生成
 */
public class LeetCode_22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backTrack(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    private void backTrack(List<String> res, StringBuilder cur, int open, int close, int n) {
        if (cur.length() == n * 2) {
            res.add(cur.toString());
            return;
        }
        if (open < n) {
            cur.append("(");
            backTrack(res, cur, open + 1, close, n);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(")");
            backTrack(res, cur, open, close + 1, n);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
