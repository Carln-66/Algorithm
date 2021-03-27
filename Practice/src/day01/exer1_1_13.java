package day01;

import org.junit.Test;

/**
 * @Auther: Carl
 * @Date: 2021/03/26/20:38
 * @Description: 数组的转置
 */
public class exer1_1_13 {
    @Test
    public void test() {
        int[][] b = { { 100, 200, 300 }, { 400, 500, 600 } };
        for (int i = 0; i < b[0].length; i++) {
            for (int j = 0; j < b.length; j++) {
                System.out.print(b[j][i]+"\t");
            }
            System.out.println();
        }
    }
}
