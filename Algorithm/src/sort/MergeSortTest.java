package sort;

import java.util.Arrays;

/**
 * @Auther: Carl
 * @Date: 2021/03/25/13:08
 * @Description: 归并排序
 */
public class MergeSortTest {
    public static void main(String[] args) {
//        int[] arr = {11, -1, 0, -5, 7, 25, 2, -9, 14};
//        int[] temp = new int[arr.length];
//        mergeSort(arr, 0, arr.length - 1, temp);
//        System.out.println(Arrays.toString(arr));

        //测试希尔排序移位法随机创建100000个随机数据的数组
        int[] arr = new int[100000];
        int[] temp = new int[arr.length];
        for (int i = 0; i < 100000; i++) {
            arr[i] = (int) (Math.random() * 800000); //数据生成区间[0, 100000)
        }

        //排序100000条数据用时14
        long t3 = System.currentTimeMillis();
        MergeSortTest.mergeSort(arr, 0, arr.length - 1, temp);
        long t4 = System.currentTimeMillis();
        System.out.println(t4 - t3);
    }

    /**
    * @Author: Carl
    * @Date: 2021/3/25 15:43
    * @param: [arr, left, right, temp]
    * @return: void
    * @Description: 拆分数组
    */
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;   //中间索引
            //向左递归进行分解
            mergeSort(arr, left, mid, temp);
            //向右递归进行分解
            mergeSort(arr, mid + 1, right, temp);
            //合并
            merge(arr, left, mid, right, temp);
        }
    }

    /**
    * @Author: Carl
    * @Date: 2021/3/25 13:17
    * @param: [arr, left, mid, right, temp]
    * @return: void
    * @Description:
     * arr: 排序的原始数组
     * left: 左边有序序列的初始索引
     * mid: 中间索引
     * right: 右边索引
     * temp: 中转数组
    */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;   //初始化i，左边有序序列的初始索引
        int j = mid + 1;    //初始化j，右边有序序列的初始索引
        int t = 0;  //指向temp数组的当前索引

        //把左右两边有序数组的元素按照大小规则依次填充到temp数组，直到有一个数组全部处理完成为止
        while (i <= mid && j <= right) {
            //若左边有序数组当前指针处的数字大于右边数组当前指针出的数字，则将左侧数字放入temp[]
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t++;
                i++;
            } else {
                temp[t] = arr[j];
                t++;
                j++;
            }
        }

        //把未处理完成的数组数据依次拷贝到temp数组中
        while (i <= mid) {  //表示左侧数组元素还有剩余
            temp[t] = arr[i];
            t++;
            i++;
        }

        while (j <= right) {  //表示右侧数组元素还有剩余
            temp[t] = arr[j];
            t++;
            j++;
        }

        //将temp数组的元素重新拷贝到arr[]
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }
}
