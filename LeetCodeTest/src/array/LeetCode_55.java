package array;

/**
 * @Auther: Carl
 * @Date: 2021/06/20/0:30
 * @Description: 跳跃游戏
 */
public class LeetCode_55 {
    public boolean canJump(int[] nums) {
        if (nums == null) {
            return false;
        }
        //maxPos始终维护能够跳跃到达的最大位置
        int maxPos = 0;
        //出循环的条件是i到达了当前能够到达的最大位置，之后无论是否有数字都无法再到达了
        for (int i = 0; i <= maxPos; i++) {
            //temp维护的是遍历到当前这个数字后能够到达的最新位置
            int temp = nums[i] + i;
            //进行一个比较，取最远位置
            maxPos = Math.max(temp, maxPos);
            //若当前位置大于等于数组下标长度，说明已经能够到达数组末尾，退出循环
            if (maxPos >= nums.length - 1) return true;
        }
        return false;
    }
}
