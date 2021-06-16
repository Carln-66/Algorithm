package SingletonTest;

/**
 * @Auther: Carl
 * @Date: 2021/06/16/19:50
 * @Description:
 */
public class EagerSingleton {
    private static EagerSingleton instance = new EagerSingleton();
    private EagerSingleton() {}
    public static EagerSingleton getInstance() {
        return instance;
    }
}
