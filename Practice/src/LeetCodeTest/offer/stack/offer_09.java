package LeetCodeTest.offer.stack;

import java.util.Stack;

/**
 * @Auther: Carl
 * @Date: 2021/04/08/22:05
 * @Description:    剑指offer #09  用两个栈实现队列
 */
public class offer_09 {

}

class CQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    public CQueue() {

    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            return -1;
        }
        Integer res = 0;
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        res = stack2.pop();
        return res;
    }
}
