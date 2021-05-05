package dynamic;

/**
 * @Auther: Carl
 * @Date: 2021/05/05/20:04
 * @Description: #45 跳跃游戏-ii
 */
public class LeetCode_45_ii {
    public int jump(int[] nums) {
        int length = nums.length;
        int maxPosition = 0;    //此步最大能到达的位置
        int steps = 0;  //结果，走了多少步
        int end = 0;    //用来维护的边界

        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) { //此时，i已经到达之前经过不断地比较得到的在当前的基础位置下能够跳达的最大位置了，说明这一步是可行的
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
