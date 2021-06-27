import java.util.*;

/**
 * @Auther: Carl
 * @Date: 2021/06/25/13:15
 * @Description: 走迷宫
 */
public class Maze {
    public static void main(String[] args) {
        Maze maze = new Maze();
        int[][] map = maze.initMaze();
        Position position = maze.initPos();
        List<int[]> path = maze.findPath(map, position);
        for (int[] arr : path) {
            System.out.println("(" + arr[0] + ", " + arr[1] + ")");
        }
        System.out.println(maze.shortestPath(map, position));
    }

    private int[][] initMaze() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入迷宫行数");
        int row = scanner.nextInt();
        System.out.println("请输入迷宫列数");
        int column = scanner.nextInt();
        int[][] map = new int[row][column];
        System.out.println("请输入迷宫中的数据");
        for (int i = 0; i < row; i++) {
            System.out.println("请输入第" + (i + 1) + "行");
            for (int j = 0; j < column; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
        System.out.println("您输入的迷宫地图为: ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        return map;
    }

    public Position initPos() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入入口行列位置（中间回车分割）: ");
        Position position = new Position(scanner.nextInt(), scanner.nextInt());
        System.out.println("目前的位置为: ");
        position.show();
        return position;
    }

    /**
     * 寻找可行出口路径
     * @param map 地图
     * @param pos 当前位置
     * @return 当前可行出口
     */
    public List<int[]> findPath(int[][] map, Position pos) {
        System.out.println("寻找路径。。。");
        int rows = map.length;
        int columns = map[0].length;
        //visit[][]用于存储之前循环遍历到的位置，将这个位置置1表示不能再重复走这个点
        int[][] visit = new int[rows][columns];
        //path用于存储当前临时路径
        Stack<Position> path = new Stack<>();
        //添加初始节点并把visit[][]置1表示无法再次到达这个点
        path.add(pos);
        visit[pos.row][pos.column] = 1;
        //temp用于存储当前的位置
        Position temp;
        //若path为空或者是pos到达任意一个为0的数组边界，说明找到了出口或者是没有出口
        while (!path.isEmpty() && !(pos.row == rows - 1 || pos.column == columns - 1)) {
            //记录前一个节点位置，利用这个位置进行寻找
            pos = path.peek();
            //向右
            if (pos.column + 1 < columns && map[pos.row][pos.column + 1] == 0 && visit[pos.row][pos.column + 1] != 1) {
                temp = new Position(pos.row, pos.column + 1);
                path.add(temp);
                visit[temp.row][temp.column] = 1;
            }
            //向下
            else if (pos.row + 1 < rows && map[pos.row + 1][pos.column] == 0 && visit[pos.row + 1][pos.column] != 1) {
                temp = new Position(pos.row + 1, pos.column);
                path.add(temp);
                visit[temp.row][temp.column] = 1;
            }
            //向左
            else if (pos.column - 1 > -1 && map[pos.row][pos.column - 1] == 0 && visit[pos.row][pos.column - 1] != 1) {
                temp = new Position(pos.row, pos.column - 1);
                path.add(temp);
                visit[temp.row][temp.column] = 1;
            }
            //向上
            else if (pos.row - 1 > -1 && map[pos.row - 1][pos.column] == 0 && visit[pos.row - 1][pos.column] != 1) {
                temp = new Position(pos.row - 1, pos.column);
                path.add(temp);
                visit[temp.row][temp.column] = 1;
            }
            //若四个位置都无法到达，说明当前位置不可行，退出
            else {
                path.pop();
            }
        }
        if (path.isEmpty()) {
            System.out.println("无可行路径");
            return new LinkedList<>();
        }
        Deque<int[]> res = new LinkedList<>();
        for (Position p : path) {
            res.addLast(new int[]{p.row, p.column});
        }
        res.removeFirst();
        return (List) res;
    }

    /**
     * 计算最短路径
     * @param map 地图
     * @param pos 当前位置
     * @return 最短路径
     */
    public int shortestPath(int[][] map, Position pos) {
        int rows = map.length;
        int columns = map[0].length;
        int[][] count = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(count[i], Integer.MAX_VALUE);
        }
        count[pos.row][pos.column] = 0;
        Deque<Position> queue = new LinkedList<>();
        queue.add(pos);
        int[] r = {0, 1, 0, -1};
        int[] c = {1, 0, -1, 0};
        while (!queue.isEmpty()) {
            pos = queue.pollLast();
            for (int i = 0; i < 4; i++) {
                int tempR = pos.row + r[i];
                int tempC = pos.column + c[i];
                if (tempR > -1 && tempR < rows && tempC > -1 && tempC < columns && map[tempR][tempC] == 0) {
                    if (count[tempR][tempC] > count[pos.row][pos.column] + 1) {
                        count[tempR][tempC] = count[pos.row][pos.column] + 1;
                        Position temp = new Position(tempR, tempC);
                        queue.addFirst(temp);
                    }
                }
            }
        }
        return count[rows - 1][columns - 1];
    }

    //静态内部类用于保存位置信息
    static class Position {
        int row;
        int column;

        public Position(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public void show() {
            System.out.println("(" + row + ", " + column + ")");
        }
    }
}
