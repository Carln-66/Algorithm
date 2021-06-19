package array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Auther: Carl
 * @Date: 2021/06/19/18:10
 * @Description: 组合总和
 */
public class LeetCode_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        backTrack(res, 0, target, candidates, path);
        return res;
    }

    /**
     * 回溯+剪枝
     * @param res 结果集
     * @param startPos 当前层中开始的位置
     * @param target 目标值，每次递归减去当前的candidates[i]作为下一层的target
     * @param candidates 源数组
     * @param path 当前的路径
     */
    private void backTrack(List<List<Integer>> res, int startPos, int target, int[] candidates, Deque<Integer> path) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startPos; i < candidates.length; i++) {
            path.addLast(candidates[i]);
            backTrack(res, i, target - candidates[i], candidates, path);
            path.removeLast();
        }
    }
}
