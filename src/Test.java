/**
 * @Auther: Carl
 * @Date: 2021/11/13/14:44
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(5);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        lruCache.put(4, 4);
        lruCache.put(5, 5);
        lruCache.put(6, 6);
        lruCache.put(4, 100);
        System.out.println(lruCache.get(3));
    }
}
