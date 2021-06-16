import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Carl
 * @Date: 2021/06/16/15:57
 * @Description:
 */
public class LRUCacha {

    static class ListNode{
        private int key;
        private int value;
        private ListNode prev;
        private ListNode next;
        public ListNode(){}
        public ListNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private int size;
    private Map<Integer, ListNode> cache = new HashMap<>();
    private ListNode head;
    private ListNode tail;

    public LRUCacha(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        ListNode node = cache.get(key);
        if (node == null) return -1;
        removeNode(node);
        addToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        ListNode node = cache.get(key);
        if (node == null) {
            if (size > capacity) {
                int removeTail = removeTail();
                cache.remove(removeTail);
                --size;
            }
            ListNode newNode = new ListNode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            ++size;
        } else {
            node.value = value;
            removeNode(node);
            addToHead(node);
        }
    }

    private void addToHead(ListNode node) {
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    private void removeNode(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private int removeTail() {
        ListNode node = tail.prev;
       removeNode(node);
        return node.key;
    }
}
