package book.unit01.linkdelist;

import java.util.Iterator;

/**
 * 链表实现背包
 * 
 * @author 22517
 *
 */
public class Bag<T> implements Iterable<T> {
    private Node first;
    private int size;

    class Node {
        private T ele;
        private Node next;
    }

    @Override
    public Iterator<T> iterator() {
        return new InnerListIterator();
    }

    class InnerListIterator implements Iterator<T> {
        private Node current = first;
       

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T data = current.ele;
            current = current.next;
            return data;
        }
    }
}
