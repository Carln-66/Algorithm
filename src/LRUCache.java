import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther: Carl
 * @Date: 2021/06/02/18:20
 * @Description:
 */
public class LRUCache<V> {
    /**
     * 容量
     */
    private int capacity = 1024;

    /**
     * node记录表
     */
    private Map<String, ListNode<String, V>> table = new ConcurrentHashMap<>();

    /**
     * 双向链表头部
     */
    private ListNode<String, V> head;

    /**
     * 双向链表尾部
     */
    private ListNode<String, V> tail;

    public LRUCache() {
        head = new ListNode<>();
        tail = new ListNode<>();
        head.next = tail;
        tail.prev = head;
    }

    public LRUCache(int capacity) {
        this();
        this.capacity = capacity;
    }

    public V get(String key) {
        ListNode<String, V> node = table.get(key);
        if (node == null) {
            return null;
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
        head.next = node.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
        table.put(key, node);
        return node.value;
    }

    public void put(String key, V value) {
        ListNode<String, V> node = table.get(key);
        if (node == null) {
            if (table.size() == capacity) {
                table.remove(tail.prev, key);
                tail.prev.prev.next = tail;
                tail.next = null;
            }
            node = new ListNode<>();
            node.key = key;
            node.value = value;
            table.put(key, node);
        }
        node.value = value;
        head.next = node.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }


    public static class ListNode<K, V> {
        private K key;
        private V value;
        ListNode<K, V> prev;
        ListNode<K, V> next;
        public ListNode(){

        }

        public ListNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
