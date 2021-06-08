import java.util.Arrays;

/**
 * @Auther: Carl
 * @Date: 2021/06/08/16:09
 * @Description:
 */
public class MyStack<T> {
    private Object[] stack;
    private int size;
    public MyStack() {
        stack = new Object[10];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Object peek() {
        T t = null;
        if (size > 0) {
            t = (T) stack[size - 1];
        }
        return t;
    }

    public Object pop() {
        T t = (T) peek();
        if (size > 0) {
            stack[size - 1] = null;
            size--;
        }
        return t;
    }

    public void push(T t) {
        expandCapacity(size + 1);
        stack[size] = t;
        size++;
    }

    public void expandCapacity(int size) {
        int len = stack.length;
        if (size > len) {
            size += size / 2 + 1;
            stack = Arrays.copyOf(stack, size);
        }
    }
}
