package dynamic;

/**
 * @Auther: Carl
 * @Date: 2021/06/20/13:19
 * @Description: 不同路径
 */
public class LeetCode_62 {
    public int uniquePaths(int m, int n) {
        int[][] arr = new int[m][n];
        /*
        1 1 1 1 1 1 1
        1 0 0 0 0 0 0
        1 0 0 0 0 0 0
        1 0 0 0 0 0 0
        将数组初始化为如上情况，这种情况就是动态规划的边界条件
        因为在横竖的边界上可行路径只有唯一一种
         */
        for (int i = 0; i < m; i++) {
            arr[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            arr[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                arr[i][j] = arr[i][j - 1] + arr[i - 1][j];
            }
        }
        return arr[m - 1][n - 1];
    }
}
