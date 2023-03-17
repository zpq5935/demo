package book.unit01.common;

import java.util.Iterator;

/**
 * 容器通用接口规范
 * @author 22517
 *
 * @param <T>
 */
public interface ICollection<T> extends Iterable<T> {
    int size();

    boolean isEmpty();

    @Override
    Iterator<T> iterator();

    void add(T ele);

    T remove();
}
