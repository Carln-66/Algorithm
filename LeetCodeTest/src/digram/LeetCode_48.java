package digram;

/**
 * @Auther: Carl
 * @Date: 2021/06/19/20:21
 * @Description: 旋转图像
 */
public class LeetCode_48 {
    //通过规律matrix[i][j]旋转后位置matrix[j][n - i - 1]求解
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] newMatrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                newMatrix[j][n - i - 1] = matrix[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = newMatrix[i][j];
            }
        }
    }
}
