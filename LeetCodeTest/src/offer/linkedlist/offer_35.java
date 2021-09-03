package offer.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Carl
 * @Date: 2021/09/03/18:13
 * @Description: 复杂链表的复制
 * 利用映射表实现
 */
public class offer_35 {
    public Node copyRandomList(Node head) {
        Node cur = head;
        Map<Node, Node> map = new HashMap<>();
        //构建原节点->新节点的映射关系
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        //返回头部
        cur = head;
        //从map中获取值，重新构建新节点的属性映射
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
