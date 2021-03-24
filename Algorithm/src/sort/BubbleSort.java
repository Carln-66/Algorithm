package sort;

import sun.util.calendar.LocalGregorianCalendar;

import java.sql.Date;
import java.util.Arrays;

/**
 * @Auther: Carl
 * @Date: 2021/03/24/19:54
 * @Description:
 */
public class BubbleSort {
    public static void main(String[] args) {

//        int[] arr = {-5, 7, 25, 2, -9, 14};
//        BubbleSort.bubbleSort(arr);

        //测试冒泡排序的时间复杂度O(n^2)，随即创建80000个随机数据的数组
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000); //数据生成区间[0, 80000)
        }

        long t1 = System.currentTimeMillis();
        BubbleSort.bubbleSort(arr);
        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
    }

    public static void bubbleSort(int[] arr){
        //第一次循环，将数组中最大的数字排在最后
        int temp = 0;   //temp用来辅助交换顺序
        boolean flag = false;   //表示是否进行过交换
        for (int i = 0; i < arr.length - 1 ; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //若前面数字比后面大，则将其交换
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag) {
                break;
            } else {
                flag = false;   //结束当次循环后flag若进行过交换则仍为true，需要重置false以进入下一次循环
            }
        }
    }
}
