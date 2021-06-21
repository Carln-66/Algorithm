package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Carl
 * @Date: 2021/06/21/22:45
 * @Description: 子集
 */
public class LeetCode_78 {
    //采用递归+回溯
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backTrack(res, nums, 0, new ArrayList<>());
        return res;
    }

    private void backTrack(List<List<Integer>> res, int[] nums, int layer, ArrayList<Integer> temp) {
        res.add(new ArrayList<>(temp));
        for (int i = layer; i < nums.length; i++) {
            temp.add(nums[i]);
            backTrack(res, nums, i + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
