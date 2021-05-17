/**
 * @Auther: Carl
 * @Date: 2021/05/17/13:15
 * @Description:
 */
public class Singleton {
    private volatile static Singleton instance;

    public Singleton() {

    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
