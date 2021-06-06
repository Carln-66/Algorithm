package sort;

import java.util.Arrays;

/**
 * @Auther: Carl
 * @Date: 2021/03/25/10:41
 * @Description: 快速排序
 */
public class QuickSortTest {
    public static void main(String[] args) {
        int[] arr = {11, -1, 0, -5, 7, 25, 2, -9, 14};
//        QuickSortTest quickSortTest = new QuickSortTest();
//        quickSortTest.quickSort(arr, 0, arr.length - 1);
//        System.out.println(Arrays.toString(arr));

        //测试希尔排序移位法随机创建100000个随机数据的数组
//        int[] arr = new int[100000];
//        for (int i = 0; i < 100000; i++) {
//            arr[i] = (int) (Math.random() * 800000); //数据生成区间[0, 100000)
//        }
//
//        //排序100000条数据用时18
//        long t3 = System.currentTimeMillis();
//        QuickSortTest.quickSort(arr, 0, arr.length - 1);
//        long t4 = System.currentTimeMillis();
//        System.out.println(t4 - t3);
        quickSort(arr, 0, arr.length - 1);
        for (int num : arr) {
            System.out.print(num + " " );
        }
    }

    public static void quickSort(int[] arr, int left, int right) {
        //在不断的递归过程中，直到有一个子数组的左右指针值相等，即只有一个元素，那么不需要排序直接返回
        if (left >= right)
            return;

        int l = left;   //左下标
        int r = right;  //右下标
        int pivot = arr[l];  //判断基准值

        //当左右下标顺序合理的情况下进入循环
        while (l < r) {
            //先从右开始检查，若r所在位置的数字大于基准数，则是正常情况，故而指针不断向左移
            while (l < r && arr[r] >= pivot) {
                r--;
            }
            //若找到了一个数它的值小于基准数，他本应排序在这个数的左边，所以将该数字放在l指针的位置（初始时即为基准数的位置），然后r指针停在原地等待l指针的指令
            if (l < r) {
                arr[l] = arr[r];
            }
            //改为l指针开始向右移动，若该位置数小于基准数，则继续右移
            while (l < r && arr[l] <= pivot) {
                l++;
            }
            //直到找到了一个数大于基准数，那么就将该数放在之前r停留的位置，而后让r继续左移，重复操作
            if (l < r) {
                arr[r] = arr[l];
            }
            //直到两个指针重合，实际上是l=r时，指针重合的位置就应该是基准数的位置，基准数即pivot，将其赋值给l或r。
            if (l >= r) {
                arr[l] = pivot;
            }
            //至此，当前循环以pivot为基准的左右数字次序已经排列好了，pivot左侧的数字均小于pivot，右侧的数字均大于pivot
        }
        //退出该循环的时候，l=r，即当前两指针重合，需要对以pivot为界限的左右两个字数组进行排序，通过递归调用两次本方法

        //第一次排列左侧子数组的顺序
        quickSort(arr, left, r - 1);
        //第二次排列右侧子数组的顺序
        quickSort(arr, l + 1, right);
    }
}
