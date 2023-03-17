package book.unit01.stack;

import java.util.Iterator;

/**
 * 数组实现Stack
 * 栈-FILO
 *
 * @param <Item>
 * @author 22517
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {
    public static void main(String[] args) {
        ResizingArrayStack<String> resizingArrayStack = new ResizingArrayStack();
        resizingArrayStack.push("1");
        resizingArrayStack.push("2");
        resizingArrayStack.push("3");
        for (String s : resizingArrayStack) {
            System.out.println(s);
        }
    }

    private Item[] elementDate = (Item[]) new Object[1];
    ;

    private int size = 0;// 当前具有的元素大小

    public void push(Item item) {
        if (size == elementDate.length)
            resize(size * 2);
        elementDate[size++] = item;
    }

    public Item pop(Item item) {
        return elementDate[--size];
    }

    private void resize(int newCapacity) {
        Item[] newDate = (Item[]) new Object[newCapacity];
        int length = elementDate.length;
        for (int i = 0; i < length; i++)
            newDate[i] = elementDate[i];
        elementDate = newDate;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<Item> iterator() {
//        return  null;
        return new ReverseArrayIterator();
    }

    class ReverseArrayIterator implements Iterator<Item> {

        int i = size;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return elementDate[--i];
        }
    }

}
