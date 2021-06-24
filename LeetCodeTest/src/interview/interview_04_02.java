package interview;

import java.util.Arrays;

/**
 * @Auther: Carl
 * @Date: 2021/06/24/19:25
 * @Description: 最小高度树
 */
public class interview_04_02 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        TreeNode n = new TreeNode(nums[nums.length / 2]);
        n.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, nums.length / 2));
        n.right = sortedArrayToBST(Arrays.copyOfRange(nums, nums.length / 2 + 1, nums.length));
        return n;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

