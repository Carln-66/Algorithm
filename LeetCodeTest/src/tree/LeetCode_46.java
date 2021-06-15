package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Auther: Carl
 * @Date: 2021/05/04/18:41
 * @Description: #46 全排列
 */
public class LeetCode_46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }
        int len = nums.length;
        dfs(len, output, res, 0);
        return res;
    }

    private void dfs(int len, List<Integer> output, List<List<Integer>> res, int first) {
        //当所有的数都填完时
        if (first == len) {
            res.add(new ArrayList<>(output));
        }
        for (int i = first; i < len; i++) {
            //动态维护数组
            Collections.swap(output, first, i);
            //向下递归
            dfs(len, output, res, first + 1);
            //回溯
            Collections.swap(output, first, i);
        }
    }
}
