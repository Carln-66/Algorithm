package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: Carl
 * @Date: 2021/05/24/13:33
 * @Description: 二叉树的锯齿形层序遍历
 */
public class LeetCode_103 {
    //利用dfs遍历
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, res, 0);
        return res;
    }

    private void dfs(TreeNode cur, List<List<Integer>> res, int level) {
        if (cur == null) {
           return;
        }
        //若res.size() <= level，说明下一层的集合还没有被创建，需要创建下一层的集合
        if (res.size() <= level) {
            LinkedList<Integer> newLevel = new LinkedList<>();
            res.add(newLevel);
        }
        //获取当前遍历到第几层，是第几层就对该层进行操作
        List<Integer> list = res.get(level);
        //默认根节点为第0层，偶数层从左往右遍历，奇数层从右往左遍历
        if (level % 2 == 0) {
            list.add(cur.val);
        } else {
            list.add(0, cur.val);
        }
        dfs(cur.left, res, level + 1);
        dfs(cur.right, res, level + 1);
    }
}
