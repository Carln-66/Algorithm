public class Main {
    private volatile static Main instance;

    private Main() {
    }

    public Main getInstance() {
        if (instance == null) {
            synchronized (Main.class) {
                if (instance == null) {
                    instance = new Main();
                }
            }
        }
        return instance;
    }
}
