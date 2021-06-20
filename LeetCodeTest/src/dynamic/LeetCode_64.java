package dynamic;

/**
 * @Auther: Carl
 * @Date: 2021/06/20/13:43
 * @Description: 最小路径和
 */
public class LeetCode_64 {
    public int minPathSum(int[][] grid) {
        int[][] arr = new int[grid.length][grid[0].length];
        arr[0][0] = grid[0][0];
        //dp[][]数组行和列存放边界条件，分别为各自元素位置前面元素的总和，表示到这个位置只能有唯一路径长度
        for (int i = 1; i < arr.length; i++) {
            arr[i][0] = arr[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < arr[0].length; i++) {
            arr[0][i] = arr[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                arr[i][j] = Math.min(arr[i - 1][j], arr[i][j - 1]) + grid[i][j];
            }
        }
        return arr[arr.length - 1][arr[0].length - 1];
    }
}
