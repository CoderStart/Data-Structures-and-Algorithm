package _01_ArrayListInt;

public class ArrayList {
    private int size; // 存储元素的个数
    private int[] elements; // 存储所有的元素

    private static final int DEFAULT_CAPACITY = 10;
    private static final int ELEMENT_NOT_FOUND = -1;

    // 有参构造方法
    public ArrayList(int capaticy) {
        capaticy = (capaticy < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capaticy;
        elements = new int[capaticy];
    }

    // 无参构造方法
    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    // 清除所有的元素
    public void clear() {
        size = 0;
    }

    //  返回元素的个数
    public int size() {
        return size;
    }

    // 判断是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 返回指定元素的索引
    public int indexOf(int element) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == element) return i;
        }
        return ELEMENT_NOT_FOUND;
    }

    // 判断是否包含指定元素
    public boolean contains(int element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    // 返回指定索引处的元素
    public int get(int index) {
        rangeCheck(index);
        return elements[index];
    }

    // 修改指定索引处的元素，返回被修改的元素
    public int set(int index, int element) {
        rangeCheck(index);
        int old = elements[index];
        elements[index] = element;
        return old;
    }

    // 在指定索引处插入指定的元素
    public void add(int index, int element) {
        rangeCheckForAdd(index);

        ensureCapacity(size + 1);

        for (int i = size - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }
        elements[index] = element;
        size++;
    }

    // 将指定的元素追加到末尾
    public void add(int element) {
        // elements[size++] = element;
        add(size, element);
    }

    // 删除指定索引处的元素，返回被删除的元素
    public int remove(int index) {
        rangeCheck(index);
        int old = elements[index];
        for (int i = index + 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }
        size--;
        return old;
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

    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
        }
    }

    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
        }
    }

    // 保证要有capacity的容量
    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity)    return;

        int newCapacity = oldCapacity + (oldCapacity >> 1);

        int[] newElements = new int[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }

        elements = newElements;

        System.out.println(oldCapacity + "扩容为" + newCapacity);
    }
}
