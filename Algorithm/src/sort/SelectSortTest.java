package sort;

import java.util.Arrays;

/**
 * @Auther: Carl
 * @Date: 2021/03/24/21:07
 * @Description:  选择排序
 */
public class SelectSortTest {

    public static void main(String[] args) {
//        int[] arr = {-5, 7, 25, 2, -9, 14};
//        SelectSortTest.selectSort(arr);
//        System.out.println(Arrays.toString(arr));

        //测试选择排序的时间复杂度O(n^2)，随即创建100000个随机数据的数组
        int[] arr = new int[100000];
        for (int i = 0; i < 100000; i++) {
            arr[i] = (int) (Math.random() * 800000); //数据生成区间[0, 8000000)
        }

        //排序100000条数据用时2705
        long t1 = System.currentTimeMillis();
        SelectSortTest.selectSort(arr);
        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
    }

    //选择排序：时间复杂度n^2
    public static void selectSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    index = j;
                }
            }
            if (index != i) {
                arr[index] = arr[i];
                arr[i] = min;
            }
        }
    }
}
