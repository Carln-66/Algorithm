package LeetCodeTest.offer.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Carl
 * @Date: 2021/04/07/21:22
 * @Description: 剑指offer #07 重建二叉树
 */
public class offer_07 {
    Map<Integer, Integer> map = new HashMap<>();
    int[] preorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recur(0, 0, inorder.length - 1);
    }

    public TreeNode recur(int pre_root, int in_left, int in_right) {
        if (in_left > in_right) return null;
        int index = map.get(preorder[pre_root]);    //获取中序遍历中对应前序遍历的根节点的位置索引
        TreeNode root = new TreeNode(preorder[pre_root]);
        root.left = recur(pre_root + 1, in_left, index - 1);
        root.right = recur(pre_root + (index - in_left) + 1, index + 1, in_right);
        return root;
    }
}