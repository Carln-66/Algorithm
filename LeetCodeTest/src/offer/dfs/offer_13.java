package offer.dfs;

/**
 * @Auther: Carl
 * @Date: 2021/04/20/15:57
 * @Description: #13 机器人的运动范围
 */
public class offer_13 {
    boolean[][] route;
    int res = 0;

    public int movingCount(int m, int n, int k) {
        if (m == 1 && n == 1) return 1;     //判断默认条件
        route = new boolean[m][n];  //初始化boolean数组，默认值为false
        dfs(0, 0, k, m, n);     //从(0,0)开始dfs
        return res;
    }

    /**
     * @param i 当前所在行
     * @param j 当前所在列
     * @param k 题目传入参数
     * @param m 给定行数
     * @param n 给定列数
     */
    private void dfs(int i, int j, int k, int m, int n) {
        if (i > m || j > n || route[i][j]) return;      //回溯的三种情况，超过最大行列值或当前坐标位置值为true，也就是走过的路径
        if (sum(i) + sum(j) > k) return;        //另外一种情况，i, j值之和大于题目要求的数位和
        route[i][j] = true;     //若经过上面两层判断到此处，说明该点已经未走过，先将其设置为true，记录为走过
        res++;  //结果集+1
        dfs(i + 1, j, k, m, n);     //向下一行递归
        dfs(i, j + 1, k, m, n);     //向右面递归
    }

    /**
     * @param num 行或列数字
     * @return 计算行列值的数位和
     */
    private int sum(int num) {
        if (num < 10) return num;
        if (num == 100) return 1;
        return num % 10 + num / 10;
    }
}
