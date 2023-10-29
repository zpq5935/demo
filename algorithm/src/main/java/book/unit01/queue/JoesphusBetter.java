package book.unit01.queue;

import book.unit01.common.ICollection;

import java.util.Iterator;

public class JoesphusBetter<T> implements ICollection<T> {
    private Node first;
    private Node last;
    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new InnerIterator<>();
    }

    @Override
    public void add(T ele) {
        if (checkEmpty(ele))
            return;
        Node newLast = new Node<>();
        newLast.data = ele;
        newLast.next = first;
        last.next = newLast;
        last = newLast;
        size++;
    }

    public void showSafe(int N) {
        Node current = first;
        Node pre = last;
        while (!isEmpty()) {
            for (int i = 0; i < N - 1; i++)
                pre = pre.next;
            System.out.println(removeNextTo(pre));
            // current = pre.next;
//            System.out.println(current.data);
//            pre.next = current.next;
//            size--;
        }

    }

    @Override
    public T remove() {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean checkEmpty(T data) {
        boolean isEmpty = isEmpty();
        if (isEmpty) {
            Node node = new Node<>();
            node.data = data;
            first = node;
            last = node;
            first.next = last;
            last.next = first;
            size++;
        }
        return isEmpty;
    }

    public T removeNextTo(Node node) {
        Node pre = node;
        Node curent = pre.next;
        pre.next = curent.next;
        size--;
        return (T) curent.data;
    }

    class Node<T> {
        private T data;
        private Node next;
    }

    class InnerIterator<T> implements Iterator<T> {

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public T next() {
            // TODO Auto-generated method stub
            return null;
        }

    }

    public static void main(String[] args) {
        JoesphusBetter<Integer> joesphusBetter = new JoesphusBetter<>();
        for (int i = 0; i < 7; i++)
            joesphusBetter.add(i);
        joesphusBetter.showSafe(3);
    }
}
