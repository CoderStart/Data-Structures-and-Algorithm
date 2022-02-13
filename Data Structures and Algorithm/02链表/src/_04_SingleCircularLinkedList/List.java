package _04_SingleCircularLinkedList;

public interface List<E> {
    public static final int ELEMENT_NOT_FOUND = -1;

    // 清除所有的元素
    void clear();

    //  返回元素的个数
    int size();

    // 判断是否为空
    boolean isEmpty();

    // 判断是否包含指定元素
    boolean contains(E element);

    // 将指定的元素追加到末尾
    void add(E element);

    // 返回指定索引处的元素
    E get(int index);

    // 修改指定索引处的元素，返回被修改的元素
    E set(int index, E element);

    // 在指定索引处插入指定的元素
    void add(int index, E element);

    // 删除指定索引处的元素，返回被删除的元素
    E remove(int index);

    // 返回指定元素的索引
    int indexOf(E element);
}
