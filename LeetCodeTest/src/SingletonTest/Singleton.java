package SingletonTest;

/**
 * @Auther: Carl
 * @Date: 2021/05/17/13:15
 * @Description: 线程安全单例模式
 */
public class Singleton {
    private static volatile Singleton instance;
    private Singleton(){}
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
