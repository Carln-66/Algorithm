package tree;

/**
 * @Auther: Carl
 * @Date: 2021/06/14/19:28
 * @Description: 二叉搜索树的后序遍历序列
 */
public class offer_33 {
    public boolean verifyPostorder(int[] postorder) {
        return helper(postorder, 0, postorder.length - 1);
    }

    private boolean helper(int[] postorder, int left, int right) {
        if (left >= right) {
            return true;
        }
        int root = postorder[right];
        int mid = left;
        while (mid < root) {
            mid++;
        }
        int temp = mid;
        while (temp < right) {
            if (postorder[temp++] < root) {
                return false;
            }
        }
        return helper(postorder, left, mid - 1) && helper(postorder, mid, right - 1);
    }
}
