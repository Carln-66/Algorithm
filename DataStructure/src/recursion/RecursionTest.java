package recursion;

/**
 * @Auther: Carl
 * @Date: 2021/03/23/9:12
 * @Description:
 */
public class RecursionTest {
    public static void main(String[] args) {
        test(5);
    }
    public static void test(int n) {
        if (n > 2) {
            test(n - 1);
        }else{
            System.out.println("n = " + n);
        }
    }
}
