package day01;

/**
 * @Auther: Carl
 * @Date: 2021/03/26/23:09
 * @Description: 返回不大于log2N的最大整数
 */
public class exer1_1_14 {

    public static int lg(int n){
        int shiftRightCount = 0;
        do {
            n >>= 1;
            shiftRightCount++;
        } while (n != 0);
        return shiftRightCount - 1;
    }
    public static void main(String[] args) {
        int value = 17;
        System.out.printf("the result of method log is :%s\r\n", lg(value));
    }

}
