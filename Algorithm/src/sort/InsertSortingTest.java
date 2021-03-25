package sort;

/**
 * @Auther: Carl
 * @Date: 2021/03/24/22:31
 * @Description: 插入排序
 */
public class InsertSortingTest {

    public static void main(String[] args) {
//        int[] arr = {-1, 0, -5, 7, 25, 2, -9, 14};
//        InsertSortingTest.insertSort(arr);
//        System.out.println(Arrays.toString(arr));

        //测试插入排序的时间复杂度O(n^2)，随机创建100000个随机数据的数组
        int[] arr = new int[100000];
        for (int i = 0; i < 100000; i++) {
            arr[i] = (int) (Math.random() * 800000); //数据生成区间[0, 100000)
        }

        //排序100000条数据用时771
        long t1 = System.currentTimeMillis();
        InsertSortingTest.insertSort(arr);
        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];
            int insertIndex = i - 1;

            //insertIndex >= 0 保证给insertVal插入位置时不越界
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            //当退出while循环时候，说明插入的位置找到    insertIndex + 1
            //判断是否需要重置
            arr[insertIndex + 1] = insertVal;
        }
    }
}
