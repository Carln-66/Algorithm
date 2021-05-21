package stack;

import java.util.Stack;

/**
 * @Auther: Carl
 * @Date: 2021/05/21/12:55
 * @Description: 每日温度
 */
public class LeetCode_739 {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                Integer preIndex = stack.pop();
                res[preIndex] = i - preIndex;
            }
            stack.push(i);
        }
        return res;
    }
}
