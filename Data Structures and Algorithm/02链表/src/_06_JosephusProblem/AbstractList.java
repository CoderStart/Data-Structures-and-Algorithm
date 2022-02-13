package _06_JosephusProblem;

public abstract class AbstractList<E> implements List<E> {
    protected int size; // 存储元素的个数

    //  返回元素的个数
    @Override
    public int size() {
        return size;
    }

    // 判断是否为空
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // 判断是否包含指定元素
    @Override
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    // 将指定的元素追加到末尾
    @Override
    public void add(E element) {
        add(size, element);
    }

    protected void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
        }
    }

    protected void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
        }
    }
}
