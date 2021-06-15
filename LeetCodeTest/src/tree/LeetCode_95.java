package tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: Carl
 * @Date: 2021/06/15/15:58
 * @Description: 不同的二叉搜索树II
 */
public class LeetCode_95 {
    //利用分治思想
    public List<TreeNode> generateTrees(int n) {
        return buildTree(1, n);
    }

    public List<TreeNode> buildTree(int left, int right) {
        List<TreeNode> res = new LinkedList<>();
        if (left > right) {
            res.add(null);
            return res;
        }
        for (int i = left; i <= right; i++) {
            List<TreeNode> leftTree = buildTree(left, i - 1);
            List<TreeNode> rightTree = buildTree(i + 1, right);
            for (TreeNode leftNode : leftTree) {
                for (TreeNode rightNode : rightTree) {
                    res.add(new TreeNode(i, leftNode, rightNode));
                }
            }
        }
        return res;
    }
}
