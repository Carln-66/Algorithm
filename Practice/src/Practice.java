public class Practice {
    boolean flag;

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int row, int column, int layer) {
        if (word.length() == layer) {
            flag = true;
            return true;
        }
        if (row < 0 || row >= board.length || column < 0 || column >= board[0].length || board[row][column] != word.charAt(layer)) {
            return false;
        }
        if (!flag) {
            char c = board[row][column];
            board[row][column] = '$';
            boolean d1 = dfs(board, word, row + 1, column, layer + 1);
            boolean d2 = dfs(board, word, row - 1, column, layer + 1);
            boolean d3 = dfs(board, word, row, column + 1, layer + 1);
            boolean d4 = dfs(board, word, row, column - 1, layer + 1);
            board[row][column] = c;
            return d1 || d2 || d3 || d4;
        } else {
            return true;
        }
    }
}
