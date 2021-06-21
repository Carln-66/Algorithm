import java.util.ArrayList;
import java.util.List;

public class Practice {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backTrack(res, nums, 0, new ArrayList<>());
        return res;
    }

    private void backTrack(List<List<Integer>> res, int[] nums, int layer, List<Integer> temp) {
        res.add(new ArrayList<>(temp));
        for (int i = layer; i < nums.length; i++) {
            temp.add(nums[i]);
            backTrack(res, nums,i + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
