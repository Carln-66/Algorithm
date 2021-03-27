package sort;

/**
 * @Auther: Carl
 * @Date: 2021/03/26/19:55
 * @Description: 基数排序
 */
public class RadixSortTest {
    public static void main(String[] args) {
        int[] arr = {11, -1, 0, -5, 7, 25, 2, -9, 14};
    }

    public static void RadixSort(int[] arr){
        //第一轮(针对每个元素的个位数进行排序处理)

        //定义一个二维数组表示10个桶，每个桶就是一个数组
        //1. 二维数组包含10个一维数组
        //2. 为了防止在放入数据的时候数据溢出，每个一维数组(桶)的大小定义为arr.length
        //3. 基数排序使用空间换取时间的经典算法
        int[][] bucket = new int[10][arr.length];

        //为了记录每个桶中实际存放了多少数据，定义一个一维数组来记录各个桶每次放入的数据个数
        int[] bucketElementCounts = new int[10];
    }
}
