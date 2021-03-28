package day01;

/**
 * @Auther: Carl
 * @Date: 2021/03/27/12:37
 * @Description: 先进先出队列
 */
public class Queue<Item> {
    private Node first; //指向队首
    private  Node last; //指向队尾
    private int N;  //队列元素数量
    private class Node{
        Item item;  //元素值
        Node next;   //元素指向下一个节点
    }

    public boolean isEmpty(){
        return N == 0;
        //return first.item == null
    }

    public int size(){
        return N;
    }

    public void enqueue(Item item){
        Node oldLast = last;
        Node last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        }else {
            oldLast.next = last;
        }
        N++;
    }

    public Item dequeue(){
        Item item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        N--;
        return item;
    }
}
