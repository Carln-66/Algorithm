import java.util.Map;

public class Practice {
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

    private int size;
    private int capacity;
    private Map<Integer, ListNode> cache;
    private ListNode head;
    private ListNode tail;

    public Practice(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        ListNode node = cache.get(key);
        if (node == null) {
            throw new RuntimeException("当前缓存中无该值");
        }
        removeNode(node);
        addToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        ListNode node = cache.get(key);
        if (node == null) {
            ListNode newNode = new ListNode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            ++size;
            if (size >= capacity) {
                ListNode tailNode = removeTail();
                cache.remove(tailNode.key);
                --size;
            }
        } else {
            removeNode(node);
            addToHead(node);
        }
    }

    public void removeNode(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addToHead(ListNode node) {
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    public ListNode removeTail() {
        ListNode prevNode = tail.prev;
        removeNode(prevNode);
        return prevNode;
    }
}
