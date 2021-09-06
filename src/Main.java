public class Main {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int x = 0;
        int y = column - 1;
        while (x < row && y >= 0) {
            int num = matrix[x][y];
            if (num == target) {
                return true;
            } else if (num < target){
                x++;
            } else {
                y--;
            }
        }
        return false;
    }
}