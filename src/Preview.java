/**
 * @Auther: Carl
 * @Date: 2021/03/29/18:18
 * @Description:
 */
public class Preview {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int row = 0;
        int column = columns - 1;
        while (row < rows && column >= 0) {
            if (target > matrix[row][column]) {
                row++;
            } else if (target < matrix[row][column]){
                column--;
            } else {
                return true;
            }
        }
        return false;
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