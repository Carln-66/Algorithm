package LeetCodeTest.offer.tree;

/**
 * @Auther: Carl
 * @Date: 2021/04/04/23:11
 * @Description:    剑指offer_54  二叉搜索树的第k大节点
 */
public class offer_54 {
    int res, k;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        inOrder(root);
        return res;

    }

    void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.right);
        if (k == 0) {
            return;
        }
        if (--k == 0) {
            res = root.val;
        }
        inOrder(root.left);
        return;
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
