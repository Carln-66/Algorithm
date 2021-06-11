package array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Auther: Carl
 * @Date: 2021/06/11/20:41
 * @Description:
 */
public class LeetCode_131 {

    //回溯算法
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        Deque<String> path = new ArrayDeque<>();
        int len = s.length();
        char[] chars = s.toCharArray();
        dfs(res, path, 0, len, chars);
        return res;
    }

    private void dfs(List<List<String>> res, Deque<String> path, int layer, int len, char[] chars) {
        if (layer == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = layer; i < len; i++) {
            if (!isPartition(chars, layer, i)) {
                continue;
            }
            path.addLast(new String(chars, layer, i + 1 - layer));
            dfs(res, path, layer + 1, len, chars);
            path.removeLast();
        }
    }

    private boolean isPartition(char[] chars, int left, int right) {
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    //回溯优化，加入动态规划
    public List<List<String>> partition1(String s) {
        List<List<String>> res = new ArrayList<>();
        Deque<String> path = new ArrayDeque<>();
        int len = s.length();
        if (len == 0) {
            return res;
        }
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[len][len];
        for (int right = 0; right < len; right++) {
            for (int left = 0; left <= right; left++) {
                //这里 && 后面的判断语句顺序不能颠倒，否则报错
                if (chars[left] == chars[right] && (right - left <= 2 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                }
            }
        }
        dfs1(res, path, 0, len, s, dp);
        return res;
    }

    private void dfs1(List<List<String>> res, Deque<String> path, int layer, int len, String s, boolean[][] dp) {
        if (layer == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = layer; i < len; i++) {
            if (!dp[layer][i]) {
                continue;
            }
            path.addLast(s.substring(layer, i + 1));
            dfs1(res, path, i + 1, len, s ,dp);
            path.removeLast();
        }
    }
}
