package day01;

import org.junit.Test;

import java.util.Iterator;
import java.util.Objects;

/**
 * @Auther: Carl
 * @Date: 2021/03/27/10:07
 * @Description: 一个标准的实现了栈结构的类
 */
public class ResizingArrayStack<Item> implements Iterable<Item>{

    private int size;
    private Item[] a = (Item[]) new Object[1];

    public boolean isEmpty(){
        return size == 0;
    }

    public int getSize(){
        return this.size;
    }

    //将栈移动到一个大小为max的数组中
    public void resize(int max){
        Item[] item = (Item[]) new Object[max];
        for (int i = 0; i < size; i++) {
            item[i] = a[i];
        }
    }

    public void push(String item){
        if (a.length == size) {
            resize(a.length * 2);
        }
        a[size++] = (Item) item;
    }

    public Item pop(){
        Item item = a[--size];
        a[size] = null;
        if (size > 0 && a.length/4 == size) {
            resize(a.length / 2);
        }
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator{ //支持先进后出的迭代

        private int i = size;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Object next() {
            return a[--i];
        }

        @Override
        public void  remove(){
        }
    }
}
