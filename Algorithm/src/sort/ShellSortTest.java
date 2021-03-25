package sort;

import java.util.Arrays;

/**
 * @Auther: Carl
 * @Date: 2021/03/24/23:37
 * @Description: 希尔排序
 */
public class ShellSortTest {
    public static void main(String[] args) {
//        int[] arr = {11, -1, 0, -5, 7, 25, 2, -9, 14};
//        ShellSortTest.shellSort(arr);
//        System.out.println(Arrays.toString(arr));

//        //测试希尔排序交换法随机创建100000个随机数据的数组
//        int[] arr = new int[100000];
//        for (int i = 0; i < 100000; i++) {
//            arr[i] = (int) (Math.random() * 800000); //数据生成区间[0, 100000)
//        }
//
//        //排序100000条数据用时6887
//        long t1 = System.currentTimeMillis();
//        ShellSortTest.shellSort(arr);
//        long t2 = System.currentTimeMillis();
//        System.out.println(t2 - t1);
//
        //测试希尔排序移位法随机创建100000个随机数据的数组
        int[] arr1 = new int[100000];
        for (int i = 0; i < 100000; i++) {
            arr1[i] = (int) (Math.random() * 800000); //数据生成区间[0, 100000)
        }

        //排序100000条数据用时16
        long t3 = System.currentTimeMillis();
        ShellSortTest.optiShellSort(arr1);
        long t4 = System.currentTimeMillis();
        System.out.println(t4 - t3);
    }

    //希尔排序--交换法
    public static void shellSort(int[] arr) {
        int temp = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //第一轮排序将分成arr.length/2组
            for (int i = gap; i < arr.length; i++) {
                //遍历各组中所有的元素(共gap组，每组有2个元素)，步长为gap
                for (int j = i - gap; j >= 0; j -= gap) {
                    //如果当前元素大于加上步长后的哪个元素，说明交换
                    //此步骤并没有采用插入式排序的思想，因而会花费大量时间
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
    }

    //对交换式希尔排序进行优化->移位法
    public static void optiShellSort(int[] arr) {
        //设置增量gap，并逐步缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //从第gap个元素，逐个对其所在的组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    //退出while循环后，说明temp找到了插入位置
                    arr[j] = temp;
            }
        }
    }
}
