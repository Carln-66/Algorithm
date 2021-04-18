package offer.array;

/**
 * @Auther: Carl
 * @Date: 2021/04/16/17:12
 * @Description:    #29 顺时针打印矩阵
 */
public class offer_29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];  //排除初始数组即为0的情况
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;   //l:左边界, r:右边界, t:上边界, b:下边界, x:结果数组的索引
        int[] res = new int[(r + 1) * (b + 1)]; //定义结果数组，长度为数组的长乘高
        while (true) {
            for (int i = l; i <= r; i++) {  //从左到右
                res[x++] = matrix[t][i];    //给当前x赋完值后加一
            }
            if (++t > b) break;     //为下面的循环判断能否进行，若上边界再向下移动一行超出下边界，说明此时结束，退出循环
            for (int i = t; i <= b; i++) {  //从上至下
                res[x++] = matrix[i][r];
            }
            if (l > --r) break;
            for (int i = r; i >= l; i--) {  //从右到左
                res[x++] = matrix[b][i];
            }
            if (t > --b) break;
            for (int i = b; i >= t; i--) {  //从下到上
                res[x++] = matrix[i][l];
            }
            if (++l > r) break;
        }
        return res;
    }
}
