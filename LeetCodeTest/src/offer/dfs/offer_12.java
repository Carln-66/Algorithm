package offer.dfs;

/**
 * @Auther: Carl
 * @Date: 2021/06/07/21:11
 * @Description: 矩阵中的路径
 */
public class offer_12 {
    public boolean exist(char[][] board, String word) {
        if (board.length < word.length() || board[0].length < word.length()) return false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                    if (dfs(board, word, i, j, 0) ) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int k) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(k)) return false;
        if (board[i][j] == word.charAt(k)) return true;
        board[i][j] = '$';
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i, j + 1, k + 1) ||
                dfs(board, word, i - 1, j, k + 1) ||dfs(board, word, i, j - 1, k + 1);
        board[i][j] = word.charAt(k);
        return res;
    }
}
