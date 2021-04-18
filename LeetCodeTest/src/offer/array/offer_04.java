package offer.array;

/**
 * @Auther: Carl
 * @Date: 2021/04/05/20:15
 * @Description:    剑指offer #04 二维数组中的查找
 */
public class offer_04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {    //判断特殊情况
            return false;
        }
        int rows = matrix.length, columns = matrix[0].length;   //定义二维数组行和列的长度
        int row = 0, column = columns - 1;  //初始化起始坐标位置为二维数组的右上角
        while (row < rows && column >= 0) {     //由于行是递增，列是递减，所以采用该种限制条件
            int num = matrix[row][column];  //定义坐标
            if (num == target) {    //找到值，返回
                return true;
            } else if (num > target) {  //若该点值比目标大，向该行的前面的列寻找
                column--;
            } else {    //若该点值比目标小，去下一行寻找
                row++;
            }
        }
        return false;   //遍历完若未找到，返回false
    }
}
