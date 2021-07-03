import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 * @Auther: Carl
 * @Date: 2021/06/29/0:48
 * @Description:
 */
public class LRUCache {
    static class ListNode {
        private int key;
        private int val;
        private ListNode prev;
        private ListNode next;

        public ListNode() {
        }

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private ListNode head;
    private ListNode tail;
    private Map<Integer, ListNode> map = new HashMap<>();
    private int size;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        ListNode node = map.get(key);
        if (node != null) {
            removeNode(node);
            move2Head(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        ListNode node = map.get(key);
        if (node == null) {
            ListNode newNode = new ListNode(key, value);
            move2Head(newNode);
            map.put(key, newNode);
            size++;
            if (capacity > size) {
                ListNode tail = removeFromTail();
                map.remove(tail.key);
                size--;
            }
        } else {
            node.val = value;
            map.put(key, node);
            removeNode(node);
            move2Head(node);
        }
    }

    private void removeNode(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void move2Head(ListNode node) {
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    private ListNode removeFromTail() {
        ListNode node = tail.prev;
        removeNode(node);
        return node;
    }
}
