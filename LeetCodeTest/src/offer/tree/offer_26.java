package offer.tree;

/**
 * @Auther: Carl
 * @Date: 2021/04/21/15:22
 * @Description:    #26 树的子结构
 * https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/solution/di-gui-fang-shi-jie-jue-by-sdwwld/
 */
public class offer_26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return (isSub(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    private boolean isSub(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return (isSub(A.left, B.left) && isSub(A.right, B.right));
    }
}
