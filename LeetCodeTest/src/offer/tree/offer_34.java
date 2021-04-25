package offer.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: Carl
 * @Date: 2021/04/25/16:58
 * @Description:    #34 二叉树中和为某一值的路径
 */
public class offer_34 {
    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        recur(root, target);
        return res;
    }

    private void recur(TreeNode root, int tar) {
        if (root == null) return;
        path.add(root.val);
        tar -= root.val;
        if (tar == 0 && root.left == null && root.right == null) {
            res.add(new LinkedList(path));
        }
        recur(root.left, tar);
        recur(root.right, tar);
        path.removeLast();
    }
}
