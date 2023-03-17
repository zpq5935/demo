package book.unit01.linkdelist;

/**
 * 双向链表
 * 
 * @author 22517
 *
 */
public class DoubleNode<T> {
    private Node first;
    private int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return first == null;
    }

    /**
     * 头结点之前插入
     * 
     * @param ele
     * @return
     */
    public void insertBeforeFirst(T ele) {
        Node newFisrt = new Node();
        newFisrt.ele = ele;
        newFisrt.next = first;
        if(first!=null)
            first.pre = newFisrt;
        first = newFisrt;
    }

    /**
     * 尾结点之后插入
     * 
     * @param ele
     * @return
     */
    public void insertAfterLast(T ele) {
        
    }

    /**
     * 删除头结点
     * 
     * @param ele
     * @return
     */
    public T deleteFirst(T ele) {
        return null;
    }

    /**
     * 删除尾结点
     * 
     * @param ele
     * @return
     */
    public T deleteLast(T ele) {
        return null;
    }

    /**
     * 指定位置index插入
     * 
     * @param ele
     * @param index
     * @return
     */
    public void insert(T ele, int index) {
    }

    /**
     * 指定删除位置index
     * 
     * @param index
     * @return
     */
    public T delete(int index) {
        return null;
    }

    class Node {
        private T ele;
        private Node pre;
        private Node next;
    }
}
