import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Auther: Carl
 * @Date: 2021/06/06/9:38
 * @Description:
 */
public class Practice3 {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean dfs(TreeNode root, int lower, int upper) {
        if (root == null) return true;
        if (root.val <= lower || root.val >= upper) return false;
        boolean b1 = dfs(root.left, lower, root.val);
        boolean b2 = dfs(root.right, root.val, upper);
        return b1 && b2;
    }
}
