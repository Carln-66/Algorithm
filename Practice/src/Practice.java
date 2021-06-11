import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Practice {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        int len = s.length();
        if (len == 0) {
            return res;
        }
        Deque<String> path = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[len][len];
        for (int right = 0; right < len; right++) {
            for (int left = 0; left <= right; left++) {
                if (chars[left] == chars[right] && ( right - left <= 2 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                }
            }
        }
        dfs(res, path, 0, dp, len, s);
        return res;
    }

    private void dfs(List<List<String>> res, Deque<String> path, int layer, boolean[][] dp, int len, String s) {
        if (layer == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = layer; i < len; i++) {
            if (dp[layer][i]) {
                path.addLast(s.substring(layer, i + 1));
                dfs(res, path, i + 1, dp, len, s);
                path.removeLast();
            }
        }
    }
}
