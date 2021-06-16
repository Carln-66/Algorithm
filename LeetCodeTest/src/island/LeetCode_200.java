package island;

/**
 * @Auther: Carl
 * @Date: 2021/05/21/12:34
 * @Description: 岛屿的数量
 */
public class LeetCode_200 {
    //深度优先遍历
    int res = 0;
    public int numIslands(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int row, int column) {
        if (row >= grid.length || column >= grid[0].length || row < 0 || column < 0 || grid[row][column] == '0') {
            return;
        }
        grid[row][column] = '0';
        dfs(grid, row - 1, column);
        dfs(grid, row + 1, column);
        dfs(grid, row, column - 1);
        dfs(grid, row, column + 1);
    }
}
