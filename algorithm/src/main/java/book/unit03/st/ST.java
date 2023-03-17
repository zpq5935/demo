package book.unit03.st;

/**
 * 查找树、搜索树
 * @param <Key>
 * @param <Value>
 */
public interface ST<Key extends Comparable<Key>, Value> {
    void put(Key key, Value val);

    Value get(Key key);

    void delete(Key key);

    boolean contain(Key key);

    int size();

    boolean isEmpty();

    Key min();

    Key max();

    Key floor(Key key);

    Key ceiling(Key key);

    int rank(Key key);

    Key select(int index);

    void deleteMin();

    void deleteMax();

    Iterable<Key> keys();

    Iterable<Key> keys(Key lo, Key hi);
}
