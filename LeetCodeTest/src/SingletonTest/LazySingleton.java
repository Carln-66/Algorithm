package SingletonTest;

/**
 * @Auther: Carl
 * @Date: 2021/06/16/19:47
 * @Description:
 */
public class LazySingleton {
    private static LazySingleton instance = null;

    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
