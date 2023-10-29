package book.unit03.st;

/**
 * 顺序查找树 这不就是普通链表吗
 * @param <Key>
 * @param <Value>
 */
public class SequentialSearchST<Key extends Comparable<Key>, Value> implements ST<Key, Value> {
    private Node first;

    @Override
    public void put(Key key, Value val) {
        for (Node x = first; x != null; x = x.next) {
            if (x.equals(key))
                x.value = val;
            return;
        }
        first = new Node(key, val, first);
    }

    @Override
    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (x.equals(key))
                return x.value;
        }
        return null;
    }

    @Override
    public void delete(Key key) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean contain(Key key) {
        return get(key) != null;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Key min() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Key max() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Key floor(Key key) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Key ceiling(Key key) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int rank(Key key) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Key select(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteMin() {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteMax() {
        // TODO Auto-generated method stub

    }

    @Override
    public Iterable<Key> keys() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        // TODO Auto-generated method stub
        return null;
    }

    class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, SequentialSearchST<Key, Value>.Node next) {
            super();
            this.key = key;
            this.value = value;
            this.next = next;
        }

    }
}
