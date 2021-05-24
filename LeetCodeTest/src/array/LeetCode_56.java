package array;

import java.util.Arrays;

/**
 * @Auther: Carl
 * @Date: 2021/05/24/12:44
 * @Description: 合并区间
 */
public class LeetCode_56 {
    public int[][] merge(int[][] intervals) {
        //按照空间起始位置进行排序
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        //创建结果数组
        int[][] res = new int[intervals.length][2];
        int index = -1;
        //遍历intervals
        for (int[] interval : intervals) {
            //如果结果数组为空，或者当前这个区间的起始位置大于当前结果数组的结束位置，说明区间没有重合的区域，所以不合并，将当前的这个区间加入结果集
            if (index == -1 || interval[0] > res[index][1]) {
                res[++index] = interval;
            } else {    //否则说明区间有重合，将当前结果集的结束位置更新为两个之中较大的那个
                res[index][1] = Math.max(res[index][1], interval[1]);
            }
        }
        return Arrays.copyOf(res, index + 1);
    }
}
