import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int group = scanner.nextInt();
        int[] res = new int[group];
        for (int i = 0; i < group; i++) {
            int rows = scanner.nextInt();
            int columns = scanner.nextInt();
            String[][] map = new String[rows][columns];
            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < columns; k++) {
                    map[i][j] = scanner.next();
                }
            }
            res[i] = getShortestTrack(map);
        }
        for (int num : res) {
            System.out.println(num);
        }
    }

    private static int getShortestTrack(String[][] map) {
        int res = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j].equals("@")) {
                    trace(map, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private static void trace(String[][] map, int row, int column) {
        if (row > map.length || column > map[0].length || row < 0 || column < 0) return;
        if (!map[row][column].equals(".")) return;
        map[row][column] = "X";
        trace(map, row + 1, column);
        trace(map, row, column + 1);
        trace(map, row - 1, column);
        trace(map, row, column + 1);
    }
}
