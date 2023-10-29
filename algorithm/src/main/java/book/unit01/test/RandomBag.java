package book.unit01.test;

import book.unit01.common.ICollection;

import java.util.Iterator;
import java.util.Random;

/**
 * p105-1.3.35-随机背包
 * 
 * @author 22517
 *
 */
public class RandomBag<T> implements ICollection<T> {
    private T[] array = (T[]) new Object[10];
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
    public void add(T ele) {
        if (size == array.length) {
            resize(array.length * 2);
        }
        array[size++] = ele;
    }

    public void resize(int newCapacity) {
        T[] newArr = (T[]) new Object[newCapacity];
        for (int i = 0; i < array.length; i++)
            newArr[i] = array[i];
        array = newArr;

    }

    @Override
    public T remove() {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new InnertIterator();
    }

    /**
     * 随机访问迭代器
     * 
     * @author 22517
     *
     * @param <T>
     */
    class InnertIterator<T> implements Iterator<T> {

        private int index = size;
        private T[] elements = (T[]) array;

        @Override
        public boolean hasNext() {
            return index > 0;
        }

        @Override
        public T next() {
            int i = new Random().nextInt(index);
            index--;
            if (i == index ) {
                return elements[i];
            }
            T temp = elements[i];
            elements[i] = elements[index];
            return temp;
        }
    }

    public static void main(String[] args) {
        RandomBag<Integer> randomBag = new RandomBag<>();
        for (int i = 0; i < 10; i++) {
            randomBag.add(i);
        }
        //
        Iterator<Integer> iterator = randomBag.iterator();
        while (iterator.hasNext())
            System.out.print(iterator.next()+" ");
    }



}
