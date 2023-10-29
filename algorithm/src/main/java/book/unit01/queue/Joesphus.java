package book.unit01.queue;

import book.unit01.common.ICollection;

import java.util.Iterator;

public class Joesphus<T> implements ICollection<T> {

    private T[] array = (T[]) new Object[10];
    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size <= 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public void add(T ele) {
        if (size == array.length)
            resize(size * 2);
        array[size++] = ele;
    }

    public void resize(int newCapacity) {
        T[] newArr = (T[]) new Object[newCapacity];
        for (int i = 0; i < array.length; i++)
            newArr[i] = array[i];
        array = newArr;
    }

    public void showSafe(int number) {
        int lastIndex = number;
        while (size > 1) {

            T retData = remove((lastIndex % size) - 1);
            System.out.print(retData + " ");
            lastIndex += number - 1;
            lastIndex = lastIndex > this.size ? lastIndex % this.size : lastIndex;
        }
        size = 0;
        System.out.println(array[0]);

    }

    @Override
    public T remove() {
        // TODO Auto-generated method stub
        return null;
    }

    public T remove(int index) {
        T retData = array[index];
        for (int i = index; i < size - 1; i++)
            array[i] = array[i + 1];
        size--;
        return retData;
    }

    /**
     * MainTest
     */
    public static void main(String[] args) {
        Joesphus<Integer> joesphus = new Joesphus<>();
        for (int i = 0; i < 7; i++)
            joesphus.add(i);
        joesphus.showSafe(3);
    }
}
