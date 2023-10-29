package book.unit01.stack;

public class LinkedListStack<Item> {

    private Node fisrt;
    private int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Item pop() {
        Item retData = fisrt.data;
        fisrt = fisrt.next;
        size--;
        return retData;
    }

    public void push(Item element) {
        Node oldFirst = fisrt;
        fisrt = new Node();
        fisrt.data = element;
        fisrt.next = oldFirst;
        size++;
    }

    class Node {
        private Item data;
        private Node next;
    }
}
