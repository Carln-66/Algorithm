import java.io.IOException;

/**
 * @Auther: Carl
 * @Date: 2021/06/06/2:31
 * @Description:
 */
public class RunTimeDemo {
    public static void main(String[] args) throws IOException {
        Runtime r = Runtime.getRuntime();
        r.exec("calc");
    }
}
