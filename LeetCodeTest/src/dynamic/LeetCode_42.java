package dynamic;

/**
 * @Auther: Carl
 * @Date: 2021/05/06/20:22
 * @Description: #42    接雨水
 */
public class LeetCode_42 {
    //动态规划解法
    public int trap(int[] height) {
        int sum = 0;    //结果
        int[] max_left = new int[height.length];    //左侧最高墙
        int[] max_right = new int[height.length];   //右侧最高墙
        //它前边的墙的左边的最高高度和它前边的墙的高度选一个较大的，就是当前列左边最高的墙了。
        for (int i = 1; i < height.length - 1; i++) {
            max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
        }
        //它后边的墙的右边的最高高度和它后边的墙的高度选一个较大的，就是当前列右边最高的墙了。
        for (int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }
        //设置当前的位置，开始遍历
        for (int i = 1; i < height.length; i++) {
            //找到左右高墙中较矮的那个
            int min = Math.min(max_left[i], max_right[i]);
            //若当前位置比最矮的墙高，那么当前位置是不能蓄水的，只有当前墙位置比最矮的墙还矮，才能够蓄水
            if (height[i] < min) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }


    /*
    我们先明确几个变量的意思：

left_max：左边的最大值，它是从左往右遍历找到的
right_max：右边的最大值，它是从右往左遍历找到的
left：从左往右处理的当前下标
right：从右往左处理的当前下标
定理一：在某个位置i处，它能存的水，取决于它左右两边的最大值中较小的一个。

定理二：当我们从左往右处理到left下标时，左边的最大值left_max对它而言是可信的，但right_max对它而言是不可信的。（见下图，由于中间状况未知，对于left下标而言，right_max未必就是它右边最大的值）

定理三：当我们从右往左处理到right下标时，右边的最大值right_max对它而言是可信的，但left_max对它而言是不可信的。

                                   right_max
 left_max                             __
   __                                |  |
  |  |__   __??????????????????????  |  |
__|     |__|                       __|  |__
        left                      right
对于位置left而言，它左边最大值一定是left_max，右边最大值“大于等于”right_max，这时候，如果left_max<right_max成立，那么它就知道自己能存多少水了。无论右边将来会不会出现更大的right_max，都不影响这个结果。 所以当left_max<right_max时，我们就希望去处理left下标，反之，我们希望去处理right下标。
     */

    //动态规划+双指针解法
    public int trap1(int[] height) {
        int sum = 0;
        int left_max = 0;
        int right_max = 0;
        int left = 1;
        int right = height.length - 2;
        for (int i = 1; i < height.length - 1; i++) {
            if (height[left - 1] < height[right + 1]) {
                left_max = Math.max(left_max, height[left - 1]);
                int min = left_max;
                if (height[left] < min) {
                    sum = sum + (min - height[left]);
                }
                left++;
            } else {
                right_max = Math.max(right_max, height[right + 1]);
                int min = right_max;
                if (height[right] < min) {
                    sum = sum + (min - height[right]);
                }
                right--;
            }
        }
        return sum;
    }
}
