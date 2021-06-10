package array;

import java.util.*;

/**
 * @Auther: Carl
 * @Date: 2021/06/10/18:31
 * @Description: 组合总和II
 */
public class LeetCode_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>(len);
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, candidates, path, 0, target, len);
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] candidates, Deque<Integer> path, int start, int target, int len) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < len; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.addLast(candidates[i]);
            dfs(res, candidates, path, i + 1, target - candidates[i], len);
            path.removeLast();
        }
    }
}
