package offer.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Carl
 * @Date: 2021/06/11/1:14
 * @Description: 二叉树右视图
 */
public class LeetCode_199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(res, root, 0);
        return res;
    }

    public void dfs(List<Integer> res, TreeNode cur, int depth) {
        if (cur == null) {
            return;
        }
        if (res.size() == depth) {
            res.add(cur.val);
        }
        depth++;
        dfs(res, cur.right, depth + 1);
        dfs(res, cur.left, depth + 1);
    }
}
