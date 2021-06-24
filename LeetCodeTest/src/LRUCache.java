import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LRUCache {
    class ListNode {
        private int key;
        private int value;
        private ListNode prev;
        private ListNode next;

        public ListNode() {
        }

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private int size;
    private Map<Integer, ListNode> cache = new ConcurrentHashMap<>();
    private ListNode head;
    private ListNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        ListNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        removeNode(node);
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        ListNode node = cache.get(key);
        if (node == null) {
            ListNode newNode = new ListNode(key, value);
            cache.put(key, newNode);
            moveToHead(newNode);
            size++;
            if (size > capacity) {
                ListNode tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        } else {
            node.key = key;
            node.value = value;
            removeNode(node);
            moveToHead(node);
            cache.put(key, node);
        }
    }

    public void removeNode(ListNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    public void moveToHead(ListNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    public ListNode removeTail() {
        ListNode node = tail.prev;
        removeNode(node);
        return node;
    }
}