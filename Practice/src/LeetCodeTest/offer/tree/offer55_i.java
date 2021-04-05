package LeetCodeTest.offer.tree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @Auther: Carl
 * @Date: 2021/04/05/19:31
 * @Description: 剑指offer  #55-i  二叉树的深度
 */
public class offer55_i {

    //递归解法
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    //利用队列 层序遍历/广度优先遍历
    public int maxDepth1(TreeNode root) {
        if (root == null) return 0;
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>(); //初始化队列
        queue.add(root);    //添加根节点
        while (!queue.isEmpty()) {  //判断条件，队列中是否有元素
            res++;
            int n = queue.size();   //n为当前层结点数量
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();   //将当前位置结点出列，寻找该节点的子节点
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return res;
    }
}
