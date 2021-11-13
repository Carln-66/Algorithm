import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther: Carl
 * @Date: 2021/11/13/13:45
 * @Description:
 */
public class LRUCache {
    class ListNode {
        private int key;
        private int value;
        private ListNode next;
        private ListNode prev;

        public ListNode() {

        }

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size;
    private int capacity;
    private Map<Integer, ListNode> cache = new ConcurrentHashMap<>();
    private ListNode head;
    private ListNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        ListNode node = cache.get(key);
        if (node == null) {
            throw new RuntimeException("缓存中无该值");
        }
        removeNode(node);
        move2Head(node);
        return node.value;
    }

    public void put(int key, int value) {
        ListNode node = cache.get(key);
        if (node == null) {
            ListNode newNode = new ListNode(key, value);
            cache.put(key, newNode);
            size++;
            move2Head(newNode);
            if (size > capacity) {
                ListNode deleteNode = removeTail();
                cache.remove(deleteNode.key);
                --size;
            }
        } else {
            node.value = value;
            removeNode(node);
            move2Head(node);
        }
    }

    private void move2Head(ListNode node) {
        node.next = head.next;
        node.prev = head;
        node.next.prev = node;
        head.next = node;
    }

    private void removeNode(ListNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private ListNode removeTail() {
        ListNode prevNode = tail.prev;
        removeNode(prevNode);
        return prevNode;
    }
}
