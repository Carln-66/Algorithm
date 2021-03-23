package recursion;

/**
 * @Auther: Carl
 * @Date: 2021/03/23/10:06
 * @Description:    迷宫问题
 */
public class Maze {
    public static void main(String[] args) {
        //创建一个二维数组，模拟迷宫
        //地图
        int[][] map = new int[8][7];

        //用1表示墙
        //上下边置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        //左右边置为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        //设置障碍
        map[3][1] = 1;
        map[3][2] = 1;
        map[3][3] = 1;

        //输出地图
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("------------------测试------------------");

        setWay(map, 1, 1);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
    }

    //使用递归回溯寻找最佳路径
    /**
    * @Author: Carl
    * @Date: 2021/3/23 10:15
    * @param: [map, i, j]
    * @return: boolean
    * @Description:
     * i，j:出发点（1，1）；
     * 如果找到通路返回true，否则返回false
     * 出口位置：（6，5）
     * 当map[i][j]为0时，表示该点没有走过；为1时表示墙；2表示通路可以走；3表示该点已经走过，但是走不通
     * 走迷宫时，确定的行进方向策略优先级为：下 > 右 > 上 > 左，若该点不通则回溯
    */
    public static boolean setWay(int[][] map, int i, int j){
        //确定结束条件，当走到（6，5）说明已经走到出口，方法结束
        if (map[6][5] == 2) {
            return true;
        } else {
            //若当前这个点还没走过
            if (map[i][j] == 0) {
                //按照策略：下 > 右 > 上 > 左

                //假定该点可以走通，将该点置为2，若无法走通，在后面更改值
                map[i][j] = 2;
                //向下走
                if (setWay(map, i + 1, j)) {
                    return true;
                }
                //向右走
                else if (setWay(map, i, j + 1)) {
                    return true;
                }
                //向上走
                else if (setWay(map, i - 1, j)) {
                    return true;
                }
                //向左走
                else if (setWay(map, i, j - 1)) {
                    return true;
                } else {
                    //若上下左右都无法通行，那么说明此路是死路
                    //将该点设为3
                    map[i][j] = 3;
                    return false;
                }
            }
            //若map[i][j]不为0，其所有可能性1，2，3都不能够再走
            else {
                return false;
            }
        }
    }
}
