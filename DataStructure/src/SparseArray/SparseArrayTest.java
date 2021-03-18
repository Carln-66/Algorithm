package SparseArray;

import java.util.Arrays;

/**
 * @Auther: Carl
 * @Date: 2021/03/18/22:59
 * @Description: 稀疏数组
 *
 * 0	0	0	0	0	0	0	0	0	0	0
 * 0	0	1	0	0	0	0	0	0	0	0
 * 0	0	0	2	0	0	0	0	0	0	0
 * 0	0	0	0	0	0	0	0	0	0	0
 * 0	0	0	0	0	0	0	0	0	0	0
 * 0	0	0	0	0	0	0	0	0	0	0
 * 0	0	0	0	0	0	0	0	0	0	0
 * 0	0	0	0	0	0	0	0	0	0	0
 * 0	0	0	0	0	0	0	0	0	0	0
 * 0	0	0	0	0	0	0	0	0	0	0
 * 0	0	0	0	0	0	0	0	0	0	0
 *
 * 11	11	2
 * 1	2	1
 * 2	3	2
 *
 *  二维数组转稀疏数组的思路：
 *  1.遍历原始的二维数组，得到有效数据的个数sum
 *  2.根据sum就可以创建稀疏数组sparseArr int[sum+1][3]
 *  3.将二维数组的有效数据存入到稀疏数组
 *
 *  稀疏数组转原始二维数组的思路
 *  1.先读取稀疏数组的第一行，根据第一行提供的数据初始化原始的二维数组
 *  2.再读取稀疏数组后几行的数据，并赋给原始的二维数组
 */
public class SparseArrayTest {
    public static void main(String[] args) {
        //创建一个原始的11*11数组
        //0：表示没有棋子，1表示黑子，2表示蓝子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2]=1;
        chessArr1[2][3]=2;
        //输出原始二维数组
        System.out.println("---------------------------------------------");
        System.out.println("-----原始的二维数组-----");
        for(int[] row : chessArr1){
            for (int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //将二维数组转稀疏数组的思路
        //1. 先遍历二维数组，得到非0数据的个数
        int sum = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j]!=0){
                    sum++;
                }
            }
        }
//        System.out.println("sum: " + sum);

        //2. 创建对应的稀疏数组
        int sparseArr[][] = new int[sum+1][3];

        //给稀疏数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        //遍历二维数组，将非零值存入稀疏数组中
        int count = 0;  //添加计数器，用于记录当前添加的是第几个非零数据
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j]!=0){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }
        System.out.println("---------------------------------------------");
        //输出稀疏数组的形式
        System.out.println("打印稀疏数组");
        for (int[] row : sparseArr){
            for (int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //稀疏数组转二维数组
        //1. 先读取稀疏数组的第一行，根据第一行的数据创建原始的二维数组
        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
        //输出恢复后的二维数组
        System.out.println("---------------------------------------------");
        System.out.println("恢复后的二维数组");
        for(int[] row : chessArr2){
            for (int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        System.out.println("---------------------------------------------");
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        for(int[] row : chessArr2){
            for (int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
}