import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther: Carl
 * @Date: 2021/06/02/18:20
 * @Description:
 */
public class LRUCache<V> {
    private int capacity = 1024;
    private Map<String, ListNode<String, V>> table = new ConcurrentHashMap<>();
    private ListNode<String, V> head;
    private ListNode<String, V> tail;

    public LRUCache() {
        head = new ListNode<>();
        tail = new ListNode<>();
        head.next = tail;
        tail.prev = head;
        head.prev = null;
        tail.next = null;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public V get(String key) {
        ListNode<String, V> node = table.get(key);
        if (node == null) return null;
        node.next.prev = node.prev;
        node.prev.next = node.next;
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
        table.put(key, node);
        return node.value;
    }

    public void put(String key, V value) {
        ListNode<String, V> node = table.get(key);
        if (node == null) {
            if (capacity == table.size()) {
                table.remove(key);
                tail.prev.prev.next = tail;
                tail.prev = tail.prev.prev;
            }
            node = new ListNode<>();
            node.key = key;
            node.value = value;
            table.put(key, node);
        }
        node.value = value;
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }


    private static class ListNode<K, V> {
        private K key;
        private V value;
        ListNode<K, V> prev;
        ListNode<K, V> next;

        public ListNode() {

        }

        public ListNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
