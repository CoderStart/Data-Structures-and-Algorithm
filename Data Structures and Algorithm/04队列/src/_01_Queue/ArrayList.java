package _01_Queue;

public class ArrayList<E> extends AbstractList<E> {
    private E[] elements; // 存储所有的元素

    private static final int DEFAULT_CAPACITY = 10;

    // 有参构造方法
    public ArrayList(int capaticy) {
        capaticy = (capaticy < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capaticy;
        elements = (E[]) new Object[capaticy];
    }

    // 无参构造方法
    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    // 清除所有的元素
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;

        // 这里缩容仅供参考
        if (elements != null && elements.length > DEFAULT_CAPACITY) {
            elements = (E[]) new Object[DEFAULT_CAPACITY];
        }
    }


    // 返回指定索引处的元素
    public E get(int index) {
        rangeCheck(index);
        return elements[index];
    }

    // 修改指定索引处的元素，返回被修改的元素
    public E set(int index, E element) {
        rangeCheck(index);
        E old = elements[index];
        elements[index] = element;
        return old;
    }

    // 在指定索引处插入指定的元素
    public void add(int index, E element) {
        // 加上这句，就不允许存储null了
        // if (element == null)    return;

        rangeCheckForAdd(index);

        ensureCapacity(size + 1);

        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    // 删除指定索引处的元素，返回被删除的元素
    public E remove(int index) {
        rangeCheck(index);
        E old = elements[index];
        for (int i = index + 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }
        // size--;
        // elements[size] = null;
        elements[--size] = null;

        // 缩容
        trim();

        return old;
    }

    // 返回指定元素的索引
    public int indexOf(E element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null)    return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(elements[i]))    return i;
            }
        }

        return ELEMENT_NOT_FOUND;
    }

    // 保证要有capacity的容量
    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity)    return;

        int newCapacity = oldCapacity + (oldCapacity >> 1);

        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }

        elements = newElements;
        System.out.println(oldCapacity + "扩容为" + newCapacity);
    }

    // 缩容
    private void trim() {
        int capacity = elements.length;
        if (size >= (capacity >> 1) || capacity <= DEFAULT_CAPACITY)    return;

        int newCapacity = capacity >> 1;
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
        System.out.println(capacity + "缩容为" + newCapacity);
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("size = ").append(size).append(", [");
        for (int i = 0; i < size; i++) {
            if (i != 0) string.append(", ");
            string.append(elements[i]);
            // if (i != size - 1)  string.append(", ");
        }
        string.append("]");
        return string.toString();
    }
}
